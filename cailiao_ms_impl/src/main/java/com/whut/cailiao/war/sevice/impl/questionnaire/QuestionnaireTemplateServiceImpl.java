package com.whut.cailiao.war.sevice.impl.questionnaire;

import com.whut.cailiao.api.commons.ApiResponse;
import com.whut.cailiao.api.commons.ApiResponseCode;
import com.whut.cailiao.api.model.pagination.Page;
import com.whut.cailiao.api.model.questionnaire.QuestionnaireTemplate;
import com.whut.cailiao.api.service.questionnaire.QuestionnaireTemplateService;
import com.whut.cailiao.war.constant.questionnaire.QuestionnaireConstant;
import com.whut.cailiao.war.dao.questionnaire.QuestionnaireTemplateDao;
import com.whut.cailiao.war.dao.questionnaire.QuestionnaireTemplateEditDao;
import com.whut.cailiao.war.exception.TransactionExecuteException;
import com.whut.cailiao.war.utils.redis.RedisSupport;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by niuyang on 16/3/6.
 */
@Service("questionnaireTemplateService")
public class QuestionnaireTemplateServiceImpl extends RedisSupport implements QuestionnaireTemplateService {

    private Logger logger = LoggerFactory.getLogger(QuestionnaireTemplateServiceImpl.class);

    @Autowired
    private QuestionnaireTemplateEditDao questionnaireTemplateEditDao;

    @Autowired
    private QuestionnaireTemplateDao questionnaireTemplateDao;

    /**
     * finished
     * 获取问卷模板对象
     * (从编辑表中)
     * @param questionnaireTemplateId
     * @return
     */
    @Override
    public ApiResponse getQuestionnaireTemplate(int questionnaireTemplateId) {
        ApiResponse response = ApiResponse.createDefaultApiResponse();
        if (questionnaireTemplateId <= 0) {
            response.setRetCode(ApiResponseCode.PARAM_ERROR);
            logger.error("param error : questionnaireTemplateId is not bigger than zero");
            return response;
        }
        QuestionnaireTemplate questionnaireTemplate = this.questionnaireTemplateEditDao.getQuestionnaireTemplate(questionnaireTemplateId);
        response.addBody("questionnaireTemplate", questionnaireTemplate);
        return response;
    }

    /**
     * finished
     * 临时保存问卷模板
     * 保存到编辑表中
     * @param questionnaireTemplate
     * @return
     */
    @Override
    public ApiResponse saveQuestionnaireTemplateTemp(QuestionnaireTemplate questionnaireTemplate) {
        return this.saveQuestionnaireTemplateTemp(questionnaireTemplate, QuestionnaireConstant.QuestionnaireTemplateStatus.EDITING);
    }

    /**
     * 更新编辑表中问卷模板
     * @param questionnaireTemplate
     * @return
     */
    private ApiResponse saveQuestionnaireTemplateTemp(QuestionnaireTemplate questionnaireTemplate, QuestionnaireConstant.QuestionnaireTemplateStatus status) {
        ApiResponse response = ApiResponse.createDefaultApiResponse();
        if (questionnaireTemplate == null ||
                (questionnaireTemplate.getId() != null && questionnaireTemplate.getId().compareTo(0) <= 0)) {
            response.setRetCode(ApiResponseCode.PARAM_ERROR);
            logger.error("save fail, param error : questionnaireTemplate is null or id is not bigger than zero");
            return response;
        }
        questionnaireTemplate.setLastModifyTime(questionnaireTemplate.getModifyTime());
        questionnaireTemplate.setModifyTime(new Timestamp(System.currentTimeMillis()));
        questionnaireTemplate.setQtStatus(status.value());
        if (questionnaireTemplate.getId() == null) {
            // 多人重复创建则会产生多条记录,不会有影响
            System.err.println("service==" + questionnaireTemplate);
            this.questionnaireTemplateEditDao.insertQuestionnaireTemplate(questionnaireTemplate);
            logger.info("create new questionnaire template success");
        } else {
            // 多人重复修改,需要保证上次修改时间和数据库中记录的最后修改时间一致
            int col = this.questionnaireTemplateEditDao.updateQuestionnaireTemplate(questionnaireTemplate);
            if (col > 0) {
                logger.info("update questionnaire template success,questionnaireTemplateId = ",
                        questionnaireTemplate.getId());
            } else {
                response.setRetCode(ApiResponseCode.CONCURRENT_CONFLICT);
                logger.error("update questionnaire template fail,questionnaireTemplateId = ",
                        questionnaireTemplate.getId() + ", maybe somebody who modify this item at the same time");
            }
        }
        return response;
    }

    /**
     * finished
     * 发布问卷模板
     * 编辑表中问卷状态修改
     * 正式表中插入模板数据
     * @param questionnaireTemplate
     * @return
     */
    @Transactional
    @Override
    public ApiResponse publishQuestionnaireTemplate(QuestionnaireTemplate questionnaireTemplate) {
        ApiResponse response = this.saveQuestionnaireTemplateTemp(questionnaireTemplate, QuestionnaireConstant.QuestionnaireTemplateStatus.PUBLISHED);
        // 修改编辑表状态
        if (response.getRetCode() != ApiResponseCode.SUCCESS) {
            logger.error("public fail, modify edit table error, questionnaireTemplateId = ", questionnaireTemplate.getId());
            throw new TransactionExecuteException();
        }
        // 正式表中插入模板数据
        // 1.正式表中读取数据
        QuestionnaireTemplate questionnaireTemplatePublished = this.questionnaireTemplateDao.getQuestionnaireTemplate(questionnaireTemplate.getId());
        // 2.分情况处理
        if (questionnaireTemplatePublished == null) {
            // 如果主键重复则会有异常,事务回退
            this.questionnaireTemplateDao.insertQuestionnaireTemplate(questionnaireTemplate);
        } else {
            questionnaireTemplate.setLastModifyTime(questionnaireTemplatePublished.getModifyTime());
            // 进行修改时间的判断, 防止并发用户的非正常修改
            int col = this.questionnaireTemplateDao.updateQuestionnaireTemplate(questionnaireTemplate);
            if (col > 0) {
                logger.info("publish questionnaire template success, questionnaireTemplateId = ",
                        questionnaireTemplate.getId());
            } else {
                response.setRetCode(ApiResponseCode.CONCURRENT_CONFLICT);
                logger.error("publish questionnaire template fail,questionnaireTemplateId = ",
                        questionnaireTemplate.getId() + ", maybe somebody who modify this item at the same time");
                throw new TransactionExecuteException();
            }
        }
        return response;
    }

    /**
     * finished
     * 删除问卷模板
     * 删除编辑表中的记录
     * 删除正式表中的记录
     * 删除问卷的发布状态(这个是属于比较暴力的去除发布方案)
     * @param questionnaireTemplateId
     * @return
     */
    @Transactional
    @Override
    public ApiResponse deleteQuestionnaireTemplate(int questionnaireTemplateId) {
        ApiResponse response = ApiResponse.createDefaultApiResponse();
        if (questionnaireTemplateId <= 0) {
            response.setRetCode(ApiResponseCode.PARAM_ERROR);
            logger.error("delete fail, input param error, questionnaireTemplateId = ", questionnaireTemplateId);
            return response;
        }
        // 删除编辑表中记录
        this.questionnaireTemplateEditDao.deleteQuestionnaireTemplate(questionnaireTemplateId);
        // 删除正式表中记录
        this.questionnaireTemplateDao.deleteQuestionnaireTemplate(questionnaireTemplateId);
        return response;
    }

    /**
     * finished
     * 分页获取问卷模板
     * 从编辑表中获取数据
     * @param currentPage
     * @param pageSize
     * @return
     */
    @Override
    public ApiResponse getQuestionnaireTemplateList(int currentPage, int pageSize) {
        ApiResponse response = ApiResponse.createDefaultApiResponse();
        if (currentPage <= 0 || pageSize <= 0) {
            response.setRetCode(ApiResponseCode.PARAM_ERROR);
            logger.error("getQuestionnaireTemplateList fail, input param error, currentPage = ",
                    currentPage, ",pagesSize = ", pageSize);
            return response;
        }
        int totalNum = this.questionnaireTemplateEditDao.getQuestionnaireTemplateCount();
        if (totalNum > 0 && totalNum > (currentPage - 1) * pageSize) {
            List<QuestionnaireTemplate> questionnaireTemplateList = this.questionnaireTemplateEditDao.getQuestionnaireTemplateList((currentPage - 1) * pageSize, pageSize);
            if (CollectionUtils.isNotEmpty(questionnaireTemplateList)) {
                Page<QuestionnaireTemplate> page = new Page<>();
                page.setList(questionnaireTemplateList);
                page.setCurrentPage(currentPage);
                page.setPageSize(pageSize);
                page.setTotalNum(totalNum);
                response.addBody("page", page);
            }
        }
        return response;
    }

    /**
     * 获取发布过的问卷模板列表
     * 从问卷模板的发布表中读取(正式表)
     */
    @Override
    public ApiResponse getPublishedQuestionnaireTemplateList() {
        ApiResponse response = ApiResponse.createDefaultApiResponse();
        List<QuestionnaireTemplate> questionnaireTemplateList = this.questionnaireTemplateDao.getPublishedQuestionnaireTemplateList();
        if (CollectionUtils.isNotEmpty(questionnaireTemplateList)) {
            response.addBody("questionnaireTemplateList", questionnaireTemplateList);
        }
        return response;
    }

}

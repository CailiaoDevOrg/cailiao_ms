package com.whut.cailiao.war.sevice.impl.questionnaire;

import java.sql.Timestamp;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whut.cailiao.api.commons.ApiResponse;
import com.whut.cailiao.api.commons.ApiResponseCode;
import com.whut.cailiao.api.model.pagination.Page;
import com.whut.cailiao.api.model.questionnaire.QuestionnaireContent;
import com.whut.cailiao.api.model.questionnaire.QuestionnaireTemplate;
import com.whut.cailiao.api.service.questionnaire.QuestionnaireService;
import com.whut.cailiao.war.constant.questionnaire.QuestionnaireConstant;
import com.whut.cailiao.war.dao.questionnaire.QuestionnaireContentDao;
import com.whut.cailiao.war.dao.questionnaire.QuestionnaireTemplateDao;
import com.whut.cailiao.war.exception.TransactionExecuteException;
import com.whut.cailiao.war.utils.redis.RedisSupport;

/**
 * Created by niuyang on 16/3/5.
 */
@Service("questionnaireService")
public class QuestionnaireServiceImpl extends RedisSupport implements QuestionnaireService {

    private Logger logger = LoggerFactory.getLogger(QuestionnaireServiceImpl.class);

    @Autowired
    private QuestionnaireTemplateDao questionnaireTemplateDao;

    @Autowired
    private QuestionnaireContentDao questionnaireContentDao;

    /**
     * finished
     * 正在使用中的问卷模板列表
     * 从问卷模板的发布表中读取(正式表)
     */
    @Override
    public ApiResponse getUsingQuestionnaireTemplateList() {
        ApiResponse response = ApiResponse.createDefaultApiResponse();
        List<QuestionnaireTemplate> questionnaireTemplateList = this.questionnaireTemplateDao.getUsingQuestionnaireTemplateList();
        if (CollectionUtils.isNotEmpty(questionnaireTemplateList)) {
            response.addBody("questionnaireTemplateList", questionnaireTemplateList);
        }
        return response;
    }

    /**
     * finished
     * 获取某水泥厂在填写某一问卷的情况
     * @param questionnaireTemplateId
     * @param cementFactoryId
     * @return
     */
    @Override
    public ApiResponse getQuestionnaireContentList(int questionnaireTemplateId, String cementFactoryId) {
        ApiResponse response = ApiResponse.createDefaultApiResponse();
        if (questionnaireTemplateId <= 0 || StringUtils.isBlank(cementFactoryId)) {
            response.setRetCode(ApiResponseCode.PARAM_ERROR);
            logger.error("get questionnaire content list fail, input param error");
            return response;
        }
        List<QuestionnaireContent> questionnaireContentList = this.questionnaireContentDao.getQuestionnaireContentListByCementId(questionnaireTemplateId, cementFactoryId);
        if (CollectionUtils.isNotEmpty(questionnaireContentList)) {
            response.addBody("questionnaireContentList", questionnaireContentList);
        }
        return response;
    }

    /**
     * 查看问卷填写详情
     * @param questionnaireContentId
     * @return
     */
    @Override
    public ApiResponse getQuestionnaireContent(int questionnaireContentId) {
        ApiResponse response = ApiResponse.createDefaultApiResponse();
        if (questionnaireContentId <= 0) {
            response.setRetCode(ApiResponseCode.PARAM_ERROR);
            logger.error("get questionnaire content fail, input param error");
            return response;
        }
        QuestionnaireContent questionnaireContent = this.questionnaireContentDao.getQuestionnaireContent(questionnaireContentId);
        if (questionnaireContent != null) {
            response.addBody("questionnaireContent", questionnaireContent);
        }
        return response;
    }

    /**
     * finished
     * 删除填写的某条问卷
     * @param questionnaireContentId
     * @return
     */
    @Override
    public ApiResponse deleteQuestionnaireContent(int questionnaireContentId) {
        ApiResponse response = ApiResponse.createDefaultApiResponse();
        if (questionnaireContentId <= 0) {
            response.setRetCode(ApiResponseCode.PARAM_ERROR);
            logger.error("delete questionnaire content fail, input param error");
            return response;
        }
        this.questionnaireContentDao.deleteQuestionnaireContent(questionnaireContentId);
        return response;
    }

    /**
     * finished
     * 临时保存已经填写的问卷
     * @param questionnaireContent
     * @return
     */
    @Override
    public ApiResponse saveQuestionnaireContentTemp(QuestionnaireContent questionnaireContent) {
        return saveQuestionnaireContentTemp(questionnaireContent, QuestionnaireConstant.QuestionnaireContentStatus.EDITING);
    }

    /**
     * finished
     * 提交填写的问卷
     * @param questionnaireContent
     * @return
     */
    @Override
    public ApiResponse commitQuestionnaireContent(QuestionnaireContent questionnaireContent) {
        return saveQuestionnaireContentTemp(questionnaireContent, QuestionnaireConstant.QuestionnaireContentStatus.COMMITTED);
    }

    /**
     * 分页获取某模板下提交的问卷
     * @param questionnaireTemplateId
     * @param currentPage
     * @param pageSize
     * @return
     */
    @Override
    public ApiResponse getQuestionnaireContentCommitList(int questionnaireTemplateId, int currentPage, int pageSize) {
        ApiResponse response = ApiResponse.createDefaultApiResponse();
        if (questionnaireTemplateId <= 0 || currentPage <= 0 || pageSize <= 0) {
            response.setRetCode(ApiResponseCode.PARAM_ERROR);
            logger.error("getQuestionnaireContentCommitList fail, input param error");
            return response;
        }
        int totalNum = this.questionnaireContentDao.getQuestionnaireContentCount(questionnaireTemplateId);
        if (totalNum > 0 && totalNum > (currentPage - 1) * pageSize) {
            List<QuestionnaireContent> questionnaireContentList = this.questionnaireContentDao.getQuestionnaireContentCommitList(questionnaireTemplateId, (currentPage - 1) * pageSize, pageSize);
            if (CollectionUtils.isNotEmpty(questionnaireContentList)) {
                Page<QuestionnaireContent> page = new Page<>();
                page.setList(questionnaireContentList);
                page.setCurrentPage(currentPage);
                page.setPageSize(pageSize);
                page.setTotalNum(totalNum);
                response.addBody("page", page);
            }
        }
        return response;
    }

    /**
     * 审核提交的问卷
     * @param questionnaireContentId
     * @param isPass
     * @param rejectReason
     * @return
     */
    @Override
    public ApiResponse examineCommittedQuestionnaireContent(int questionnaireContentId, boolean isPass, String rejectReason) {
        ApiResponse response = ApiResponse.createDefaultApiResponse();
        if (questionnaireContentId <= 0 || (!isPass && StringUtils.isBlank(rejectReason))) {
            response.setRetCode(ApiResponseCode.PARAM_ERROR);
            logger.error("examineCommittedQuestionnaireContent fail, input error");
            return response;
        }
        QuestionnaireContent questionnaireContent = new QuestionnaireContent();
        questionnaireContent.setId(questionnaireContentId);
        if (isPass) {
            questionnaireContent.setStatus(QuestionnaireConstant.QuestionnaireContentStatus.PASS.value());
        } else {
            questionnaireContent.setStatus(QuestionnaireConstant.QuestionnaireContentStatus.EDITING.value());
        }
        questionnaireContent.setRejectReason(rejectReason);
        return response;
    }

    /**
     * finished
     * 保存填写的问卷
     * @param questionnaireContent
     * @param status
     * @return
     */
    private ApiResponse saveQuestionnaireContentTemp(QuestionnaireContent questionnaireContent, QuestionnaireConstant.QuestionnaireContentStatus status) {
        ApiResponse response = ApiResponse.createDefaultApiResponse();
        if (questionnaireContent == null
                || (questionnaireContent.getId() != null && questionnaireContent.getId().compareTo(0) <= 0)) {
            response.setRetCode(ApiResponseCode.PARAM_ERROR);
            logger.error("saveQuestionnaireContentTemp fail, input param error");
            return response;
        }
        questionnaireContent.setLastModifyTime(questionnaireContent.getModifyTime());
        questionnaireContent.setModifyTime(new Timestamp(System.currentTimeMillis()));
        if (questionnaireContent.getId() == null) {
            questionnaireContent.setStatus(status.value());
            this.questionnaireContentDao.insertQuestionnaireContent(questionnaireContent);
        } else {
            if (questionnaireContent.getStatus() == QuestionnaireConstant.QuestionnaireContentStatus.EDITING.value()) {
                questionnaireContent.setStatus(status.value());
                int col = this.questionnaireContentDao.updateQuestionnaireContent(questionnaireContent);
                if (col > 0) {
                    logger.info("update questionnaire content success, questionnaireContentId = ",
                            questionnaireContent.getId());
                } else {
                    response.setRetCode(ApiResponseCode.CONCURRENT_CONFLICT);
                    logger.error("update questionnaire content fail, questionnaireContentId = ",
                            questionnaireContent.getId() + ", maybe somebody who modify this item at the same time");
                    throw new TransactionExecuteException();
                }
            } else {
                response.setRetCode(ApiResponseCode.EDIT_LOCKED);
                logger.info("update questionnaire content fail, questionnaireContent status is not editing");
            }
        }
        return response;
    }

    /**
     * 获取问卷总记录数
     * @param questionnaireTemplateId
     * @return
     */
    @Override
    public ApiResponse getQuestionnaireContentCount(int questionnaireTemplateId) {
        ApiResponse response = ApiResponse.createDefaultApiResponse();
        if (questionnaireTemplateId <= 0) {
            response.setRetCode(ApiResponseCode.PARAM_ERROR);
            logger.error("getQuestionnaireContentCount fail, input param error, questionnaireTemplateId = ", questionnaireTemplateId);
            return response;
        }
        int count = this.questionnaireContentDao.getQuestionnaireContentCount(questionnaireTemplateId);
        response.addBody("totalNum", count);
        return response;
    }
}

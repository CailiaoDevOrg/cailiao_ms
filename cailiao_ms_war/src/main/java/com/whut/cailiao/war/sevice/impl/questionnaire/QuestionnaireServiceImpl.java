package com.whut.cailiao.war.sevice.impl.questionnaire;

import com.whut.cailiao.api.commons.ApiResponse;
import com.whut.cailiao.api.commons.ApiResponseCode;
import com.whut.cailiao.api.model.questionnaire.QuestionnaireTemplate;
import com.whut.cailiao.api.service.questionnaire.QuestionnaireService;
import com.whut.cailiao.war.constant.questionnaire.QuestionnaireConstant;
import com.whut.cailiao.war.dao.questionnaire.QuestionnaireTemplateDao;
import com.whut.cailiao.war.dao.questionnaire.QuestionnaireTemplateEditDao;
import com.whut.cailiao.war.utils.redis.RedisSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

/**
 * Created by niuyang on 16/3/5.
 */
@Service("questionnaireService")
public class QuestionnaireServiceImpl extends RedisSupport implements QuestionnaireService {

    private Logger logger = LoggerFactory.getLogger(QuestionnaireServiceImpl.class);

    @Autowired
    private QuestionnaireTemplateEditDao questionnaireTemplateEditDao;

    @Autowired
    private QuestionnaireTemplateDao questionnaireTemplateDao;

    /**
     * 保存数据到编辑表中
     * @param questionnaireTemplate
     */
    @Override
    public ApiResponse saveQuestionnaireTemplate(QuestionnaireTemplate questionnaireTemplate) {
        ApiResponse response = new ApiResponse();
        if (questionnaireTemplate == null ||
                (questionnaireTemplate.getId() != null && questionnaireTemplate.getId().compareTo(0) <= 0)) {
            response.setRetCode(ApiResponseCode.PARAM_ERROR);
            response.setRetDesc(ApiResponseCode.getDesc(ApiResponseCode.PARAM_ERROR));
            logger.error("can not save, param error : questionnaireTemplate is null or id is not bigger than zero");
            return response;
        }
        Timestamp now = new Timestamp(System.currentTimeMillis());
        questionnaireTemplate.setModifyTime(now);
        questionnaireTemplate.setStatus(QuestionnaireConstant.QuestionnaireTemplateStatus.EDITING.value());
        if (questionnaireTemplate.getId() == null) {
            questionnaireTemplate.setCreateTime(now);
            this.questionnaireTemplateEditDao.insertQuestionnaireTemplate(questionnaireTemplate);
        } else {
            this.questionnaireTemplateEditDao.updateQuestionnaireTemplate(questionnaireTemplate);
        }
        return response;
    }

    /**
     * 获取问卷模板详细内容
     * @param questionnaireTemplateItemId
     * @return
     */
    @Override
    public ApiResponse getQuestionnaireTemplate(int questionnaireTemplateItemId) {
        ApiResponse response = new ApiResponse();
        if (questionnaireTemplateItemId <= 0) {
            response.setRetCode(ApiResponseCode.PARAM_ERROR);
            response.setRetDesc(ApiResponseCode.getDesc(ApiResponseCode.PARAM_ERROR));
            logger.error("param error : questionnaireTemplateItemId is not bigger than zero");
            return response;
        }
        QuestionnaireTemplate questionnaireTemplate = this.questionnaireTemplateEditDao.getQuestionnaireTemplate(questionnaireTemplateItemId);
        response.addBody("questionnaireTemplate", questionnaireTemplate);
        return response;
    }

    /**
     * 发布新问卷模板
     * @param questionnaireTemplate
     * @return
     */
    @Override
    public ApiResponse publishQuestionnaireTemplate(QuestionnaireTemplate questionnaireTemplate) {
        ApiResponse response = new ApiResponse();
        if (questionnaireTemplate == null || questionnaireTemplate.getId() == null ||
                questionnaireTemplate.getId().compareTo(0) <= 0) {
            response.setRetCode(ApiResponseCode.PARAM_ERROR);
            response.setRetDesc(ApiResponseCode.getDesc(ApiResponseCode.PARAM_ERROR));
            logger.error("can not publish, param error : questionnaireTemplate is null or id is null or id is not bigger than zero");
            return response;
        }
        questionnaireTemplate.setStatus(QuestionnaireConstant.QuestionnaireTemplateStatus.PUBLISHED.value());
        saveQuestionnaireTemplate(questionnaireTemplate);
        this.questionnaireTemplateDao.insertQuestionnaireTemplate(questionnaireTemplate);
        return response;
    }

}

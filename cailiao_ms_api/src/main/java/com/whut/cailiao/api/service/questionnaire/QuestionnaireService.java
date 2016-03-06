package com.whut.cailiao.api.service.questionnaire;

import com.whut.cailiao.api.commons.ApiResponse;
import com.whut.cailiao.api.model.questionnaire.QuestionnaireContent;
import com.whut.cailiao.api.model.questionnaire.QuestionnaireTemplate;

/**
 * Created by niuyang on 16/3/5.
 */
public interface QuestionnaireService {

    /**
     * 正在使用中的问卷模板列表
     * 从问卷模板的发布表中读取(正式表)
     */
    ApiResponse getUsingQuestionnaireTemplateList();

    /**
     * 获取某水泥厂在填写某一问卷的情况
     * @Param questionnaireTemplateId
     * @Param cementFactoryId
     * @return
     */
    ApiResponse getQuestionnaireContentList(int questionnaireTemplateId, String cementFactoryId);

    /**
     * 删除填写的某条问卷
     * @param questionnaireContentId
     * @return
     */
    ApiResponse deleteQuestionnaireContent(int questionnaireContentId);

    /**
     * 临时保存已经填写的问卷
     * @param questionnaireContent
     * @return
     */
    ApiResponse saveQuestionnaireContentTemp(QuestionnaireContent questionnaireContent);

    /**
     * 提交填写的问卷
     * @param questionnaireContent
     * @return
     */
    ApiResponse commitQuestionnaireContent(QuestionnaireContent questionnaireContent);

}

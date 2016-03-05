package com.whut.cailiao.war.dao.questionnaire;

import com.whut.cailiao.api.model.questionnaire.QuestionnaireTemplate;

/**
 * Created by niuyang on 16/3/6.
 * 问卷模板发布表
 */
public interface QuestionnaireTemplateDao {

    /**
     * 插入问卷模板
     */
    void insertQuestionnaireTemplate(QuestionnaireTemplate questionnaireTemplate);
}

package com.whut.cailiao.war.dao.questionnaire;

import java.util.Map;

import com.whut.cailiao.api.model.questionnaire.QuestionnaireTemplate;

/**
 * 问卷DAO
 * @author niuyang
 * 编辑表
 *
 */
public interface QuestionnaireTemplateEditDao {

    /**
     * 插入问卷模板
     */
    void insertQuestionnaireTemplate(QuestionnaireTemplate questionnaireTemplate);

    /**
     * 更新问卷模板
     */
    void updateQuestionnaireTemplate(QuestionnaireTemplate questionnaireTemplate);

    /**
     * 获取问卷模板详细内容
     * @return
     */
    QuestionnaireTemplate getQuestionnaireTemplate(int questionnaireTemplateId);

}

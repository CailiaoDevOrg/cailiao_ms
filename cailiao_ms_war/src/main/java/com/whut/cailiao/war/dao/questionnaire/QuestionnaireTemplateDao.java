package com.whut.cailiao.war.dao.questionnaire;

import com.whut.cailiao.api.model.questionnaire.QuestionnaireTemplate;

import java.util.List;

/**
 * Created by niuyang on 16/3/6.
 * 问卷模板发布表(正式表)
 */
public interface QuestionnaireTemplateDao {

    /**
     * 插入问卷模板
     * 插入到正式表
     * @param questionnaireTemplate
     */
    int insertQuestionnaireTemplate(QuestionnaireTemplate questionnaireTemplate);

    /**
     * 获取已发布的模板数据
     * 从正式表中获取
     * @param questionnaireTemplateId
     * @return
     */
    QuestionnaireTemplate getQuestionnaireTemplate(int questionnaireTemplateId);

    /**
     * 更新已发布的数据模板
     * 从正式表中
     * @param questionnaireTemplate
     */
    int updateQuestionnaireTemplate(QuestionnaireTemplate questionnaireTemplate);

    /**
     * 删除问卷模板记录
     * 在正式表中删除
     * @param questionnaireTemplateId
     * @return
     */
    int deleteQuestionnaireTemplate(int questionnaireTemplateId);

    /**
     * 获取正在使用的问卷模板
     * @return
     */
    List<QuestionnaireTemplate> getUsingQuestionnaireTemplateList();

}

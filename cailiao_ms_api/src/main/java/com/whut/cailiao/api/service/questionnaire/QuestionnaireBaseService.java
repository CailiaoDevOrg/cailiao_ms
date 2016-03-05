package com.whut.cailiao.api.service.questionnaire;

import com.whut.cailiao.api.model.questionnaire.QuestionnaireTemplate;

/**
 * 问卷管理模块基础服务
 * @author niuyang
 *
 */
public interface QuestionnaireBaseService {
    
    /**
     * 保存问卷信息
     * @param questionnaireTemplate
     */
    void saveQuestionnaire(QuestionnaireTemplate questionnaireTemplate);
    
    /**
     * 更新问卷信息
     * @param questionnaireTemplate
     */
    void updateQuestionnaire(QuestionnaireTemplate questionnaireTemplate);
    
    /**
     * 根据id删除问卷信息
     * @param id
     */
    void deleteQuestionnaireById(int id);
    
    /**
     * 根据问卷id获取问卷详情
     * @param id
     * @return
     */
    QuestionnaireTemplate getQuestionnaireById(int id);

}

package com.whut.cailiao.api.service.questionnaire;

import com.whut.cailiao.api.model.questionnaire.Questionnaire;

/**
 * 问卷管理模块基础服务
 * @author niuyang
 *
 */
public interface QuestionnaireBaseService {
    
    /**
     * 保存问卷信息
     * @param questionnaire
     */
    void saveQuestionnaire(Questionnaire questionnaire);
    
    /**
     * 更新问卷信息
     * @param Questionnaire questionnaire
     */
    void updateQuestionnaire(Questionnaire questionnaire);
    
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
    Questionnaire getQuestionnaireById(int id);

}

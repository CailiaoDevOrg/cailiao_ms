package com.whut.cailiao.war.dao.questionnaire;

import java.util.Map;

import com.whut.cailiao.api.model.questionnaire.Questionnaire;

/**
 * 问卷DAO
 * @author niuyang
 *
 */
public interface QuestionnaireDao {
    
    /**
     * 根据id获取问卷详细信息
     * @return
     */
    Questionnaire selectQuestionnaireById(int id);
    
    /**
     * 插入新数据
     */
    void insertNewQuestionnaire(Map<String, Object> map);
    
    /**
     * 删除问卷
     * @param id
     */
    void deleteQuestionnaireById(int id);
    
    /**
     * 更新问卷
     * @param map
     */
    void updateQuestionnaireItem(Map<String, Object> map);

}

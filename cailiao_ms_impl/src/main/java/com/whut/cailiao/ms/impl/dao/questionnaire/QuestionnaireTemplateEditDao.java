package com.whut.cailiao.ms.impl.dao.questionnaire;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.whut.cailiao.ms.api.model.questionnaire.QuestionnaireTemplate;

/**
 * 问卷DAO
 * @author niuyang
 * 问卷模板编辑表
 *
 */
public interface QuestionnaireTemplateEditDao {

    /**
     * 获取问卷模板详细内容
     * 编辑表中获取信息
     * @param questionnaireTemplateId
     * @return
     */
    QuestionnaireTemplate getQuestionnaireTemplate(int questionnaireTemplateId);

    /**
     * 插入问卷模板
     * 在编辑表中插入
     * @param questionnaireTemplate
     */
    void insertQuestionnaireTemplate(QuestionnaireTemplate questionnaireTemplate);

    /**
     * 更新问卷模板
     * 更新编辑表
     * @param questionnaireTemplate
     */
    int updateQuestionnaireTemplate(QuestionnaireTemplate questionnaireTemplate);

    /**
     * 删除问卷模板记录
     * 在编辑表中删除
     * @param questionnaireTemplateId
     * @return
     */
    int deleteQuestionnaireTemplate(int questionnaireTemplateId);

    /**
     * 分页获取问卷模板列表
     * 在编辑表中获取数据
     * @param offset
     * @param pageSize
     * @return
     */
    List<QuestionnaireTemplate> getQuestionnaireTemplateList(@Param("offset") int offset, 
            @Param("pageSize") int pageSize);

    /**
     * 获取问卷模板的总条数
     * 在编辑表中获取
     * @return
     */
    int getQuestionnaireTemplateCount();

}

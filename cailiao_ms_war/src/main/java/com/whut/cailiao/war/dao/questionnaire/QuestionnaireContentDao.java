package com.whut.cailiao.war.dao.questionnaire;

import com.whut.cailiao.api.model.questionnaire.QuestionnaireContent;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * Created by niuyang on 16/3/7.
 * 问卷填写详情表操作接口
 *
 */
public interface QuestionnaireContentDao {

    /**
     * 查询某水泥厂填写的某问卷
     * @param questionnaireTemplateId
     * @param cementFactoryId
     * @return
     */
    List<QuestionnaireContent> getQuestionnaireContentListByCementId(@Param("questionnaireTemplateId") int questionnaireTemplateId, 
            @Param("cementFactoryId") String cementFactoryId);

    /**
     * 查看填写的问卷的详情内容
     * @param questionnaireContentId
     * @return
     */
    QuestionnaireContent getQuestionnaireContent(int questionnaireContentId);

    /**
     * 删除填写的问卷
     * @param questionnaireContentId
     * @return
     */
    int deleteQuestionnaireContent(int questionnaireContentId);

    /**
     * 更新填写的问卷
     * @param questionnaireContent
     */
    int updateQuestionnaireContent(QuestionnaireContent questionnaireContent);

    /**
     * 插入新填写的问卷
     * @param questionnaireContent
     */
    void insertQuestionnaireContent(QuestionnaireContent questionnaireContent);

    /**
     * 获取提交的问卷列表,分页显示
     * @param questionnaireTemplateId
     * @param currentPage
     * @param pageSize
     * @return
     */
    List<QuestionnaireContent> getQuestionnaireContentCommitList(@Param("questionnaireTemplateId") int questionnaireTemplateId, 
            @Param("offset") int offset, 
            @Param("pageSize") int pageSize);

}

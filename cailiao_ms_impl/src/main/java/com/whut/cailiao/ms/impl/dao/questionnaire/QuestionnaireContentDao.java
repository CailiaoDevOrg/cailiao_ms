package com.whut.cailiao.ms.impl.dao.questionnaire;

import com.whut.cailiao.ms.api.model.questionnaire.QuestionnaireContent;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by niuyang on 16/3/7.
 * 问卷填写详情表操作接口
 *
 */
public interface QuestionnaireContentDao {

    /**
     * 查询某水泥厂填写的某问卷
     * @param questionnaireTemplateId
     * @param accountId
     * @return
     */
    List<QuestionnaireContent> getQuestionnaireContentListByAccountId(@Param("questionnaireTemplateId") int questionnaireTemplateId,
            @Param("accountId") String accountId);

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

    void updateQuestionnaireContentStatus(QuestionnaireContent questionnaireContent);

    /**
     * 插入新填写的问卷
     * @param questionnaireContent
     */
    void insertQuestionnaireContent(QuestionnaireContent questionnaireContent);

    /**
     * 获取提交的问卷列表,分页显示
     * @param questionnaireTemplateId
     * @return
     */
    List<QuestionnaireContent> getQuestionnaireContentCommitList(int questionnaireTemplateId);

    List<QuestionnaireContent> getQuestionnaireListWithDetailContent();
    
    /**
     * 获取问卷总记录数
     * @param questionnaireTemplateId
     * @return
     */
    int getQuestionnaireContentCount(int questionnaireTemplateId);

}

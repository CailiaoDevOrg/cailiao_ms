package com.whut.cailiao.api.service.questionnaire;

import com.whut.cailiao.api.commons.ApiResponse;
import com.whut.cailiao.api.model.questionnaire.QuestionnaireTemplate;

/**
 * Created by niuyang on 16/3/6.
 */
public interface QuestionnaireTemplateService {

    /**
     * 获取问卷模板对象
     * 从编辑表中
     * @param questionnaireTemplateItemId
     * @return
     */
    ApiResponse getQuestionnaireTemplate(int questionnaireTemplateItemId);

    /**
     * 临时保存问卷模板
     * 保存到编辑表中
     * @param questionnaireTemplate
     * @return
     */
    ApiResponse saveQuestionnaireTemplateTemp(QuestionnaireTemplate questionnaireTemplate);

    /**
     * 发布问卷模板
     * 编辑表中问卷状态修改
     * 正式表中插入模板数据
     * @param questionnaireTemplate
     * @return
     */
    ApiResponse publishQuestionnaireTemplate(QuestionnaireTemplate questionnaireTemplate);

    /**
     * 删除问卷模板
     * 删除编辑表中的记录
     * 删除正式表中的记录
     * 删除问卷的发布状态(这个是属于比较暴力的去除发布方案)
     * @param questionnaireTemplateId
     * @return
     */
    ApiResponse deleteQuestionnaireTemplate(int questionnaireTemplateId);

    /**
     * 分页获取问卷模板
     * 从编辑表中获取数据
     * @param currentPage
     * @param pageSize
     * @return
     */
    ApiResponse getQuestionnaireTemplateList(int currentPage, int pageSize);


}

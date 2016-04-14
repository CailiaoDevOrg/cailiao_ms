package com.whut.cailiao.war.web.questionnaire;

import com.whut.cailiao.api.commons.ApiResponse;
import com.whut.cailiao.api.model.questionnaire.QuestionnaireTemplate;
import com.whut.cailiao.api.service.questionnaire.QuestionnaireTemplateService;
import com.whut.cailiao.war.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by niuyang on 16/3/6.
 * qtms 问卷模板管理
 */
@Controller
@RequestMapping("/qtms")
public class QuestionnaireTemplateController extends BaseController {

    @Autowired
    private QuestionnaireTemplateService questionnaireTemplateService;

    /**
     * finished
     * 临时保存问卷模板
     * @param questionnaireTemplate
     */
    @RequestMapping(value = "/saveQuestionnaireTemplateTemp.html", method = RequestMethod.POST)
    @ResponseBody
    public String saveQuestionnaireTemplateTemp(@RequestBody QuestionnaireTemplate questionnaireTemplate) {
        ApiResponse response = this.questionnaireTemplateService.saveQuestionnaireTemplateTemp(questionnaireTemplate);
        return convertApiResponseToJSONString(response);
    }

    /**
     * finished
     * 获取问卷模板详细内容
     * 不论是否上线都从编辑表中获取数据
     */
    @RequestMapping(value = "/getQuestionnaireTemplate/{questionnaireTemplateId}.html", method = RequestMethod.GET)
    @ResponseBody
    public String getQuestionnaireTemplate(@PathVariable int questionnaireTemplateId) {
        ApiResponse response = this.questionnaireTemplateService.getQuestionnaireTemplate(questionnaireTemplateId);
        return convertApiResponseToJSONString(response);
    }

    /**
     * finished
     * 发布问卷模板
     * @param questionnaireTemplate
     */
    @RequestMapping(value = "/publishQuestionnaireTemplate.html", method = RequestMethod.POST)
    @ResponseBody
    public String publishQuestionnaireTemplate(@RequestBody QuestionnaireTemplate questionnaireTemplate) {
        ApiResponse response = this.questionnaireTemplateService.publishQuestionnaireTemplate(questionnaireTemplate);
        return convertApiResponseToJSONString(response);
    }

    /**
     * finished
     * 删除问卷模板
     * @param questionnaireTemplateId
     */
    @RequestMapping(value = "/deleteQuestionnaireTemplate/{questionnaireTemplateId}.html", method = RequestMethod.GET)
    @ResponseBody
    public String deleteQuestionnaireTemplate(@PathVariable int questionnaireTemplateId) {
        ApiResponse response = this.questionnaireTemplateService.deleteQuestionnaireTemplate(questionnaireTemplateId);
        return convertApiResponseToJSONString(response);
    }

    /**
     * finished
     * 获取问卷模板列表
     * @param currentPage
     * @param pageSize
     */
    @RequestMapping(value = "/getQuestionnaireTemplateList/{currentPage}/{pageSize}.html", method = RequestMethod.GET)
    @ResponseBody
    public String getQuestionnaireTemplateList(@PathVariable int currentPage, @PathVariable int pageSize) {
        ApiResponse response = this.questionnaireTemplateService.getQuestionnaireTemplateList(currentPage, pageSize);
        return convertApiResponseToJSONString(response);
    }

}

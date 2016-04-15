package com.whut.cailiao.impl.web.questionnaire;

import com.whut.cailiao.api.commons.ApiResponse;
import com.whut.cailiao.api.model.questionnaire.QuestionnaireTemplate;
import com.whut.cailiao.api.service.questionnaire.QuestionnaireTemplateService;
import com.whut.cailiao.impl.utils.bean.BeanHelper;
import com.whut.cailiao.impl.web.BaseController;
import org.apache.commons.collections4.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created by niuyang on 16/3/6.
 * qtms 问卷模板管理
 */
@Controller
@RequestMapping("/wjt")
public class QuestionnaireTemplateController extends BaseController {

    @Autowired
    private QuestionnaireTemplateService questionnaireTemplateService;

    @RequestMapping(value = "/create.html", method = RequestMethod.GET)
    public String navigateToCreateNewWJPage() {
        return "wjt/create";
    }

    @RequestMapping(value = "/list.html", method = RequestMethod.GET)
    public String navigateToWJListPage() {
        return "wjt/list";
    }

    /**
     * 已经通过
     * 临时保存问卷模板
     * @param questionnaireTemplate
     */
    @RequestMapping(value = "/saveTemp.html", method = RequestMethod.POST)
    @ResponseBody
    public String saveQuestionnaireTemplateTemp(@RequestBody QuestionnaireTemplate questionnaireTemplate) {
        ApiResponse response = this.questionnaireTemplateService.saveQuestionnaireTemplateTemp(questionnaireTemplate);
        return convertApiResponseToJSONString(response);
    }

    /**
     * 已经通过
     * 获取问卷模板列表
     * @param currentPage
     */
    @RequestMapping(value = "/getWJTList/{currentPage}.html", method = RequestMethod.GET)
    @ResponseBody
    public String getQuestionnaireTemplateList(@PathVariable int currentPage) {
        ApiResponse response = this.questionnaireTemplateService.getQuestionnaireTemplateList(currentPage, 10);
        return convertApiResponseToJSONString(response);
    }

    /**
     * 已经通过
     * 删除问卷模板
     * @param questionnaireTemplateId
     */
    @RequestMapping(value = "/deleteWJT/{questionnaireTemplateId}.html", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteQuestionnaireTemplate(@PathVariable int questionnaireTemplateId) {
        ApiResponse response = this.questionnaireTemplateService.deleteQuestionnaireTemplate(questionnaireTemplateId);
        return convertApiResponseToJSONString(response);
    }

    /**
     * 已经通过
     * 发布问卷模板
     * @param questionnaireTemplateId
     */
    @RequestMapping(value = "/publishWJT/{questionnaireTemplateId}.html", method = RequestMethod.PUT)
    @ResponseBody
    public String publishQuestionnaireTemplate(@PathVariable int questionnaireTemplateId) {
        ApiResponse response = this.questionnaireTemplateService.publishQuestionnaireTemplate(questionnaireTemplateId);
        return convertApiResponseToJSONString(response);
    }

    /**
     * finished
     * 获取问卷模板详细内容
     * 不论是否上线都从编辑表中获取数据
     */
    @RequestMapping(value = "/getWJT/{questionnaireTemplateId}.html", method = RequestMethod.GET)
    public String getQuestionnaireTemplate(@PathVariable int questionnaireTemplateId, Model model) {
        ApiResponse response = this.questionnaireTemplateService.getQuestionnaireTemplate(questionnaireTemplateId);
        if (response.getRetCode() == 200) {
            QuestionnaireTemplate questionnaireTemplate  = (QuestionnaireTemplate) response.getData("questionnaireTemplate");
            Map<String, Object> objMap = BeanHelper.convertObjToMap(questionnaireTemplate);
            if (MapUtils.isEmpty(objMap)) {
                return "wjt/list";
            }
            model.addAllAttributes(objMap);
            return "wjt/edit";
        }
        return "wjt/list";
    }

}

package com.whut.cailiao.impl.web.online;

import com.whut.cailiao.api.commons.ApiResponse;
import com.whut.cailiao.api.commons.ApiResponseCode;
import com.whut.cailiao.api.model.questionnaire.QuestionnaireTemplate;
import com.whut.cailiao.api.service.questionnaire.QuestionnaireTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by gammaniu on 16/4/22.
 */
@Controller
@RequestMapping("/online/wj")
public class OnlineQuestionnaireController {

    @Autowired
    private QuestionnaireTemplateService questionnaireTemplateService;

    @RequestMapping(value = "/{wjtId}.html", method = RequestMethod.GET)
    public String navigateToWJPage(@PathVariable int wjtId) {
        ApiResponse response = this.questionnaireTemplateService.getQuestionnaireTemplate(wjtId);
        if (response.getRetCode() == ApiResponseCode.SUCCESS) {
            QuestionnaireTemplate questionnaireTemplate = (QuestionnaireTemplate) response.getData("questionnaireTemplate");
            if (questionnaireTemplate != null) {
                return questionnaireTemplate.getTemplateUrl();
            }
        }
        return "online/index/index";
    }
}

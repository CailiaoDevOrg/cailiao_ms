package com.whut.cailiao.impl.web.questionnaire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.whut.cailiao.api.commons.ApiResponse;
import com.whut.cailiao.api.service.questionnaire.QuestionnaireService;
import com.whut.cailiao.impl.web.BaseController;

/**
 * 问卷管理
 * @author niuyang
 * 问卷管理缩写qms
 * 功能需求如下:
 * 1. 显示问卷列表,课题组用户查看水泥厂用户提交的问卷记录
 * 2. 课题组用户查看问卷记录中的每条生产线的子记录
 * 3. 课题组用户审核问卷,以生产线子记录为单位
 * 4. 课题组用户创建问卷模板
 * 5. 课题组用户更改模板状态
 * 6. 问卷提交情况统计(提交了多少份,审核通过多少份,未通过多少份)
 * 7. 记录和子记录的删除
 */
@Controller
@RequestMapping("/wj")
public class QuestionnaireController extends BaseController {

    @Autowired
    private QuestionnaireService questionnaireService;

    @RequestMapping(value = "/list/{wjtId}.html", method = RequestMethod.GET)
    public String navigateToWJListPage(@PathVariable int wjtId, Model model) {
        if (wjtId <= 0) {
            return "home/home";
        }
        model.addAttribute("wjtId", wjtId);
        return "wj/list";
    }

    /**
     * 获取某一问卷模板下的问卷提交列表
     * @param questionnaireTemplateId
     */
    @RequestMapping(value = "/getList/{questionnaireTemplateId}.html", method = RequestMethod.GET)
    @ResponseBody
    public String getQuestionnaireContentCommitList(@PathVariable int questionnaireTemplateId) {
        ApiResponse response = this.questionnaireService.getQuestionnaireContentCommitList(questionnaireTemplateId);
        return convertApiResponseToJSONString(response);
    }

    /**
     * 查看提交的问卷详情
     * @param questionnaireContentId
     */
    @RequestMapping(value = "/getCommittedQuestionnaireContent/{questionnaireContentId}.html", method = RequestMethod.GET)
    @ResponseBody
    public String getCommittedQuestionnaireContent(@PathVariable int questionnaireContentId) {
        ApiResponse response = this.questionnaireService.getQuestionnaireContent(questionnaireContentId);
        return convertApiResponseToJSONString(response);
    }

    /**
     * 审核问卷填写情况
     * @param isPass
     * @param questionnaireContentId
     * @param rejectReason
     */
    @RequestMapping(value = "/examineCommittedQuestionnaireContent/{questionnaireContentId}.html", method = RequestMethod.POST)
    @ResponseBody
    public String examineCommittedQuestionnaireContent(@PathVariable int questionnaireContentId,
                                                       @RequestParam boolean isPass,
                                                       @RequestParam(required = false) String  rejectReason) {
        ApiResponse response = this.questionnaireService.examineCommittedQuestionnaireContent(questionnaireContentId, isPass, rejectReason);
        return convertApiResponseToJSONString(response);
    }

}

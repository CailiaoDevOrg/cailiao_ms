package com.whut.cailiao.ms.impl.web.questionnaire;

import com.whut.cailiao.ms.api.model.search.QuestionnaireQueryBean;
import com.whut.cailiao.ms.api.service.questionnaire.QuestionnaireSearchService;
import com.whut.cailiao.ms.impl.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.whut.cailiao.ms.api.commons.ApiResponse;
import com.whut.cailiao.ms.api.service.questionnaire.QuestionnaireService;

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
    private QuestionnaireSearchService questionnaireSearchService;

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
     * 跳转到问卷的搜索页面
     */
    @RequestMapping(value = "/search/{wjtId}.html", method = RequestMethod.GET)
    public String navigateToWJSearchPage(@PathVariable int wjtId, Model model) {
    	if (wjtId <= 0) {
            return "home/home";
        }
        model.addAttribute("wjtId", wjtId);
    	return "wj/search";
    }

    @RequestMapping(value = "/doSearch.html", method = RequestMethod.POST)
    @ResponseBody
    public String doSearch(@RequestBody QuestionnaireQueryBean questionnaireQueryBean) {
        ApiResponse response = this.questionnaireSearchService.search(questionnaireQueryBean);
        return convertApiResponseToJSONString(response);
    }

}

package com.whut.cailiao.war.web.questionnaire;

import com.alibaba.fastjson.JSON;
import com.whut.cailiao.api.commons.ApiResponse;
import com.whut.cailiao.api.model.questionnaire.QuestionnaireTemplate;
import com.whut.cailiao.api.service.questionnaire.QuestionnaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/qms")
public class QuestionnaireController {

    @Autowired
    private QuestionnaireService questionnaireService;

    /********************** 关于问卷查看与审核 ************************/
    /**
     * 获取某一问卷模板下的问卷提交列表
     * @param currentPage
     * @param pageSize
     * @param questionnaireTemplateId
     */
    @RequestMapping(value = "/getQuestionnaireCommitList/{questionnaireTemplateId}/{currentPage}/{pageSize}.html",
            method = RequestMethod.GET)
    public String getQuestionnaireCommitList(@PathVariable int questionnaireTemplateId,
                                             @PathVariable int currentPage,
                                             @PathVariable int pageSize) {
        return null;
    }

    /**
     * 获取某一问卷提交记录下的各生产线问卷详情(不需要分页)
     * @param questionnaireCommitId
     */
    @RequestMapping(value = "/getQuestionnaireFillDetailList/{questionnaireCommitId}.html", method = RequestMethod.GET)
    public String getQuestionnaireDetailList(@PathVariable int questionnaireCommitId) {
        return null;
    }

    /**
     * 查看各个生产线问卷详情
     * @param detailItemId
     */
    @RequestMapping(value = "/getQuestionnaireDetailItem/{detailItemId}.html", method = RequestMethod.GET)
    public String getQuestionnaireDetailItem(@PathVariable int detailItemId) {
        return null;
    }

    /**
     * 审核各个生产线问卷详情(问卷填写情况)
     */
    @RequestMapping(value = "/examineQuestionnaireDetailItem/{detailItemId}.html", method = RequestMethod.PUT)
    public String examineQuestionnaireDetailItem(@PathVariable int detailItemId, @RequestParam boolean isPass,
                                                 @RequestParam(required = false) String reason) {
        return null;
    }

    /************************* 问卷统计 ************************/
    @RequestMapping(value = "/statisticsQuestionnaireCommitInfo.html", method = RequestMethod.GET)
    public String statisticsQuestionnaireCommitInfo() {
        return null;
    }


}

package com.whut.cailiao.ms.impl.web.questionnaire;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by niuyang on 16/3/7.
 */
@Controller
@RequestMapping("/s")
public class StatisticsController {

    /************************* 问卷统计 ************************/
    @RequestMapping(value = "/statisticsQuestionnaireCommitInfo.html", method = RequestMethod.GET)
    public String statisticsQuestionnaireCommitInfo() {
        return null;
    }

}

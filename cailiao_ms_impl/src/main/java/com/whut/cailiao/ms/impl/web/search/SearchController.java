package com.whut.cailiao.ms.impl.web.search;

import com.whut.cailiao.ms.api.commons.ApiResponse;
import com.whut.cailiao.ms.api.model.questionnaire.QuestionnaireContent;
import com.whut.cailiao.ms.api.model.search.QuestionnaireQueryBean;
import com.whut.cailiao.ms.api.service.questionnaire.QuestionnaireService;
import com.whut.cailiao.ms.impl.dao.questionnaire.QuestionnaireContentDao;
import com.whut.cailiao.ms.impl.web.BaseController;
import com.whut.cailiao.search.client.SearchClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.List;

/**
 * Created by gammaniu on 16/4/29.
 */
@Controller
@RequestMapping("search")
public class SearchController extends BaseController {

    @Autowired
    private QuestionnaireService questionnaireService;

    @Autowired
    private QuestionnaireContentDao questionnaireContentDao;

    @RequestMapping(value = "/test.html", method = RequestMethod.GET)
    @ResponseBody
    public String test() {

        SearchClient searchClient = SearchClient.getInstance();

        // index
        List<QuestionnaireContent> questionnaireContentList = this.questionnaireContentDao.getQuestionnaireListWithDetailContent(73);

        searchClient.createIndex(questionnaireContentList);

        // search
        QuestionnaireQueryBean queryBean = new QuestionnaireQueryBean();
        queryBean.setId("47");
        queryBean.setBi_phoneNumber("13469969477");
        // queryBean.setQuestionnaireTemplateId(73);

        ApiResponse response = null;
        try {
            response = searchClient.search(queryBean);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return convertApiResponseToJSONString(response);
    }
}

package com.whut.cailiao.ms.impl.sevice.impl.questionnaire;

import com.whut.cailiao.ms.api.commons.ApiResponse;
import com.whut.cailiao.ms.api.model.questionnaire.QuestionnaireContent;
import com.whut.cailiao.ms.api.model.search.QuestionnaireQueryBean;
import com.whut.cailiao.ms.api.service.questionnaire.QuestionnaireSearchService;
import com.whut.cailiao.ms.impl.dao.questionnaire.QuestionnaireContentDao;
import com.whut.cailiao.search.client.SearchClient;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by gammaniu on 16/5/3.
 */
@Service
public class QuestionnaireSearchServiceImpl implements QuestionnaireSearchService {

    @Autowired
    private QuestionnaireContentDao questionnaireContentDao;

    private static SearchClient searchClient = SearchClient.getInstance();

    @Override
    public ApiResponse search(QuestionnaireQueryBean questionnaireQueryBean) {
        ApiResponse response = ApiResponse.createDefaultApiResponse();
        try {
            response = searchClient.search(questionnaireQueryBean);
        } catch (IOException e) {
            e.printStackTrace();
            response = ApiResponse.createCallErrorApiResponse();
        }
        return response;
    }

    @Override
    public ApiResponse createIndex() {
        ApiResponse response = ApiResponse.createDefaultApiResponse();
        List<QuestionnaireContent> questionnaireContentList = this.questionnaireContentDao.getQuestionnaireListWithDetailContent();
        searchClient.createIndex(questionnaireContentList);
        return response;
    }
}

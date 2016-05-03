package com.whut.cailiao.ms.api.service.questionnaire;

import com.whut.cailiao.ms.api.commons.ApiResponse;
import com.whut.cailiao.ms.api.model.search.QuestionnaireQueryBean;

/**
 * Created by niuyang on 16/3/5.
 */
public interface QuestionnaireSearchService {

    ApiResponse search(QuestionnaireQueryBean questionnaireQueryBean);

    ApiResponse createIndex();

}

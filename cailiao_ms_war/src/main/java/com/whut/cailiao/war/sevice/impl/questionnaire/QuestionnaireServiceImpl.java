package com.whut.cailiao.war.sevice.impl.questionnaire;

import com.whut.cailiao.api.commons.ApiResponse;
import com.whut.cailiao.api.commons.ApiResponseCode;
import com.whut.cailiao.api.model.questionnaire.QuestionnaireTemplate;
import com.whut.cailiao.api.service.questionnaire.QuestionnaireService;
import com.whut.cailiao.war.constant.questionnaire.QuestionnaireConstant;
import com.whut.cailiao.war.dao.questionnaire.QuestionnaireTemplateDao;
import com.whut.cailiao.war.dao.questionnaire.QuestionnaireTemplateEditDao;
import com.whut.cailiao.war.utils.redis.RedisSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

/**
 * Created by niuyang on 16/3/5.
 */
@Service("questionnaireService")
public class QuestionnaireServiceImpl extends RedisSupport implements QuestionnaireService {

    private Logger logger = LoggerFactory.getLogger(QuestionnaireServiceImpl.class);


}

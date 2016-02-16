package com.whut.cailiao.war.sevice.impl.questionnaire;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whut.cailiao.api.model.questionnaire.Questionnaire;
import com.whut.cailiao.api.service.questionnaire.QuestionnaireBaseService;
import com.whut.cailiao.war.dao.questionnaire.QuestionnaireDao;
import com.whut.cailiao.war.utils.redis.RedisSupport;


@Service
public class QuestionnaireBaseServiceImpl extends RedisSupport implements QuestionnaireBaseService {
    
    @Autowired
    private QuestionnaireDao questionnaireDao;

    @Override
    public void saveQuestionnaire(Questionnaire questionnaire) {
        if (questionnaire == null) {
            return;
        }
        Map<String, Object> map = new HashMap<>();
        map.put("name", questionnaire.getName());
        map.put("description", questionnaire.getDescription());
        map.put("createPerson", questionnaire.getCreatePerson());
        map.put("createTime", questionnaire.getCreateTime());
        map.put("modifyTime", questionnaire.getModifyTime());
        map.put("beginTime", questionnaire.getBeginTime());
        map.put("endTime", questionnaire.getEndTime());
        map.put("templateJspUrl", questionnaire.getTemplateJspUrl());
        map.put("status4Time", questionnaire.getStatus4Time());
        map.put("status4Op", questionnaire.getStatus4Op());
        this.questionnaireDao.insertNewQuestionnaire(map);
    }

    @Override
    public void updateQuestionnaire(Questionnaire questionnaire) {
        if (questionnaire == null || questionnaire.getId() <= 0) {
            return;
        }
        Map<String, Object> map = new HashMap<>();
        map.put("id", questionnaire.getId());
        map.put("name", questionnaire.getName());
        this.questionnaireDao.updateQuestionnaireItem(map);
        String key = "questionnaire20160216_" + questionnaire.getId();
        deleteTestData(key);
    }

    @Override
    public void deleteQuestionnaireById(int id) {
        if (id <= 0) {
            return;
        }
        // delete from db
        this.questionnaireDao.deleteQuestionnaireById(id);
        // delete from cache
        String key = "questionnaire20160216_" + id;
        deleteTestData(key);
    }

    @Override
    public Questionnaire getQuestionnaireById(int id) {
        String key = "questionnaire20160216_" + id;
        Questionnaire questionnaire = (Questionnaire) getTestData(key);
        if (questionnaire == null) {
            questionnaire = this.questionnaireDao.selectQuestionnaireById(id);
            setTestData(key, questionnaire);
        }
        return questionnaire;
    }

}

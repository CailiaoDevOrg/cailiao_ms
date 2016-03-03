package com.whut.cailiao.war.web.questionnaire;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.whut.cailiao.api.model.questionnaire.Questionnaire;
import com.whut.cailiao.api.service.questionnaire.QuestionnaireBaseService;

/**
 * 问卷管理
 * @author niuyang
 *
 */
@Controller
@RequestMapping("/questionnaire")
public class QuestionnaireController {
    
    @Autowired
    private QuestionnaireBaseService questionnaireBaseService;
    
    @RequestMapping("/go.html")
    public String go() {
        return "home";
    }
    
    @RequestMapping("/{id}.html")
    @ResponseBody
    public String getQuestionnairebyId(@PathVariable int id) {
        long beginTime = System.currentTimeMillis();
        Questionnaire questionnaire = this.questionnaireBaseService.getQuestionnaireById(id);
        Long endTime = System.currentTimeMillis();
        System.out.println(endTime - beginTime);
        if (questionnaire == null) {
            return null;
        }
        return JSON.toJSONString(questionnaire);
    }
    
    @RequestMapping("/new.html")
    @ResponseBody
    public String insertNewItem() {
        Questionnaire questionnaire = new Questionnaire();
        questionnaire.setName("test");
        questionnaire.setDescription("hello world");
        questionnaire.setCreatePerson("hzniuyang");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        questionnaire.setCreateTime(timestamp);
        questionnaire.setModifyTime(timestamp);
        questionnaire.setBeginTime(timestamp);
        questionnaire.setEndTime(timestamp);
        questionnaire.setStatus4Time(2);
        questionnaire.setStatus4Op(1);
        questionnaire.setTemplateJspUrl("http://jsp");
        this.questionnaireBaseService.saveQuestionnaire(questionnaire);
        return "SUCCESS";
    }
    
    @RequestMapping("/delete/{id}.html")
    @ResponseBody
    public String deleteItem(@PathVariable int id) {
        this.questionnaireBaseService.deleteQuestionnaireById(id);
        return "SUCCESS";
    }
    
    @RequestMapping("/update/{id}.html")
    @ResponseBody
    public String updateItem(@PathVariable int id, @RequestParam String name) {
        Questionnaire questionnaire = new Questionnaire();
        questionnaire.setId(id);
        questionnaire.setName(name);
        this.questionnaireBaseService.updateQuestionnaire(questionnaire);
        return "SUCCESS";
    }

    @RequestMapping("/test.html")
    @ResponseBody
    public String test(@RequestParam String test) {

        System.out.println(test);
        return "SUCCESS";

    }

}

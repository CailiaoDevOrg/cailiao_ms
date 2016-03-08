package com.whut.cailiao.api.model.questionnaire.search;

import java.io.Serializable;

public class QuestionnaireContentQueryBean implements Serializable {
    
    private static final long serialVersionUID = 1L;
    // id, 主键
    private Integer id;
    // 问卷模板id
    private Integer questionnaireTemplateId;
    // 生产线
    private String productionLine;
    // 问卷详细内容
    private String jsonContent;
    // 状态(填写中, 已提交, 审核中, 审核通过)
    private Integer status;
  
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuestionnaireTemplateId() {
        return questionnaireTemplateId;
    }

    public void setQuestionnaireTemplateId(Integer questionnaireTemplateId) {
        this.questionnaireTemplateId = questionnaireTemplateId;
    }

    public String getProductionLine() {
        return productionLine;
    }

    public void setProductionLine(String productionLine) {
        this.productionLine = productionLine;
    }

    public String getJsonContent() {
        return jsonContent;
    }

    public void setJsonContent(String jsonContent) {
        this.jsonContent = jsonContent;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}

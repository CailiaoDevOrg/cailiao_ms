package com.whut.cailiao.api.model.questionnaire;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by niuyang on 16/3/6.
 */
public class QuestionnaireContent implements Serializable {

    private static final long serialVersionUID = 1L;
    // id, 主键
    private Integer id;
    // 问卷模板id
    private int questionnaireTemplateId;
    // 水泥厂id
    private String cementFactoryId;
    // 生产线
    private String productionLine;
    // 修改时间
    private Timestamp modifyTime;
    // 上次修改时间
    private Timestamp lastModifyTime;
    // 问卷详细内容
    private String jsonContent;
    // 状态(填写中, 已提交, 审核中, 审核通过)
    private int status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getQuestionnaireTemplateId() {
        return questionnaireTemplateId;
    }

    public void setQuestionnaireTemplateId(int questionnaireTemplateId) {
        this.questionnaireTemplateId = questionnaireTemplateId;
    }

    public String getCementFactoryId() {
        return cementFactoryId;
    }

    public void setCementFactoryId(String cementFactoryId) {
        this.cementFactoryId = cementFactoryId;
    }

    public String getProductionLine() {
        return productionLine;
    }

    public void setProductionLine(String productionLine) {
        this.productionLine = productionLine;
    }

    public Timestamp getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Timestamp modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Timestamp getLastModifyTime() {
        return lastModifyTime;
    }

    public void setLastModifyTime(Timestamp lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }

    public String getJsonContent() {
        return jsonContent;
    }

    public void setJsonContent(String jsonContent) {
        this.jsonContent = jsonContent;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "QuestionnaireContent [id=" + id + ", questionnaireTemplateId=" + questionnaireTemplateId
                + ", cementFactoryId=" + cementFactoryId + ", productionLine=" + productionLine + ", modifyTime="
                + modifyTime + ", lastModifyTime=" + lastModifyTime + ", jsonContent=" + jsonContent + ", status="
                + status + "]";
    }

}

package com.whut.cailiao.ms.api.model.questionnaire;

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
    // 修改时间
    private Timestamp modifyTime;
    // 上次修改时间
    private Timestamp lastModifyTime;
    // 问卷详细内容
    private String jsonContent;
    // 状态(填写中, 已提交, 审核中, 审核通过)
    private int status;
    // 填写人
    private String accountId;

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

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    @Override
    public String toString() {
        return "QuestionnaireContent{" +
                "id=" + id +
                ", questionnaireTemplateId=" + questionnaireTemplateId +
                ", modifyTime=" + modifyTime +
                ", lastModifyTime=" + lastModifyTime +
                ", jsonContent='" + jsonContent + '\'' +
                ", status=" + status +
                ", accountId='" + accountId + '\'' +
                '}';
    }
}

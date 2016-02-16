package com.whut.cailiao.api.model.questionnaire;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 问卷基本信息
 * @author niuyang
 *
 */
public class Questionnaire implements Serializable {

    private static final long serialVersionUID = 1L;
    /** 问卷id */
    private int id;
    /** 问卷名 */
    private String name;
    /** 问卷描述 */
    private String description;
    /** 问卷创建人 */
    private String createPerson;
    /** 问卷创建时间 */
    private Timestamp createTime;
    /** 问卷最后更改时间 */
    private Timestamp modifyTime;
    /** 问卷生效时间 */
    private Timestamp beginTime;
    /** 问卷失效时间 */
    private Timestamp endTime;
    /** 问卷模板jsp页面 */
    private String templateJspUrl;
    /** 问卷时间状态（仅根据时间判断的状态） */
    private int status4Time;
    /** 问卷控制状态（应对问卷发布之后认为的状态变更） */
    private int status4Op;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreatePerson() {
        return createPerson;
    }

    public void setCreatePerson(String createPerson) {
        this.createPerson = createPerson;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Timestamp modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Timestamp getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Timestamp beginTime) {
        this.beginTime = beginTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public String getTemplateJspUrl() {
        return templateJspUrl;
    }

    public void setTemplateJspUrl(String templateJspUrl) {
        this.templateJspUrl = templateJspUrl;
    }

    public int getStatus4Time() {
        return status4Time;
    }

    public void setStatus4Time(int status4Time) {
        this.status4Time = status4Time;
    }

    public int getStatus4Op() {
        return status4Op;
    }

    public void setStatus4Op(int status4Op) {
        this.status4Op = status4Op;
    }
    
}

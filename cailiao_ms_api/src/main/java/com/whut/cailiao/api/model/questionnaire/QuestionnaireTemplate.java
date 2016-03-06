package com.whut.cailiao.api.model.questionnaire;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 问卷基本信息
 * @author niuyang
 *
 */
public class QuestionnaireTemplate implements Serializable {

    private static final long serialVersionUID = 1L;
    /** 问卷id */
    private Integer id;
    /** 问卷名 */
    private String name;
    /** 问卷描述 */
    private String description;
    /** 问卷创建时间 */
    private Timestamp createTime;
    /** 问卷最后更改时间 */
    private Timestamp modifyTime;
    /** 问卷上次修改时间 */
    private Timestamp lastModifyTime;
    /** 问卷生效时间 */
    private Timestamp beginTime;
    /** 问卷失效时间 */
    private Timestamp endTime;
    /** 问卷模板jsp页面 */
    private String templateJspUrl;
    /**
     * 问卷控制状态
     * 编辑中
     * 已发布
     */
    private int status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Timestamp getLastModifyTime() {
        return lastModifyTime;
    }

    public void setLastModifyTime(Timestamp lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
}

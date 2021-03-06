package com.whut.cailiao.ms.api.model.questionnaire;

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
    /** 问卷最后更改时间 */
    private Timestamp modifyTime;
    /** 问卷上次修改时间 */
    private Timestamp lastModifyTime;
    /** 问卷生效时间 */
    private Timestamp beginTime;
    /** 问卷失效时间 */
    private Timestamp endTime;
    /** 问卷模板jsp页面 */
    private String templateUrl;
    /** 问卷模板发布人 */
    private String publishedPerson;
    
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getTemplateUrl() {
        return templateUrl;
    }

    public void setTemplateUrl(String templateUrl) {
        this.templateUrl = templateUrl;
    }

	public String getPublishedPerson() {
		return publishedPerson;
	}

	public void setPublishedPerson(String publishedPerson) {
		this.publishedPerson = publishedPerson;
	}

	@Override
	public String toString() {
		return "QuestionnaireTemplate [id=" + id + ", name=" + name + ", description=" + description + ", modifyTime="
				+ modifyTime + ", lastModifyTime=" + lastModifyTime + ", beginTime=" + beginTime + ", endTime="
				+ endTime + ", templateUrl=" + templateUrl + ", publishedPerson=" + publishedPerson + ", status="
				+ status + "]";
	}   
    
}

package com.whut.cailiao.ms.api.model.search;

import java.io.Serializable;

/**
 * 目前查询条件只支持字符串,所有内容都要转换成字符串进行设置
 * 赞数支持单个的,表格中的内容不支持查询
 */
public class QuestionnaireQueryBean implements Serializable {
    
    private static final long serialVersionUID = 1L;

    // id, 主键
    private String id;
    // 问卷模板id
    private String questionnaireTemplateId;

    // 基本信息
    private String bi_qyName;
    private String bi_scLineName;
    private String bi_scLineScale;
    private String bi_qyAddress;
    private String bi_linkman;
    private String bi_phoneNumber;
    // 资源消耗
    private String zyxh_slcl;
    private String zyxh_sncl;
    // 能源消耗
    private String nyxh_slfmdh;
    private String nyxh_kbslmh;
    private String nyxh_kbsldh;
    private String nyxh_kbslnh;
    private String nyxh_kbsndh;
    private String nyxh_kbsnnh;
    private String nyxh_dwslfdl;
    // 废气排放
    private String fqpf_pd_sl;
    private String fqpf_pd_ccfs;
    private String fqpf_txgy;
    // 主要设备
    private String zysb_slm_fmfs;
    private String zysb_slm_ggxh;
    private String zysb_slm_sl;
    private String zysb_snm_fmfs;
    private String zysb_snm_ggxh;
    private String zysb_snm_sl;
    private String zysb_y_gg;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQuestionnaireTemplateId() {
        return questionnaireTemplateId;
    }

    public void setQuestionnaireTemplateId(String questionnaireTemplateId) {
        this.questionnaireTemplateId = questionnaireTemplateId;
    }

    public String getBi_qyName() {
        return bi_qyName;
    }

    public void setBi_qyName(String bi_qyName) {
        this.bi_qyName = bi_qyName;
    }

    public String getBi_scLineName() {
        return bi_scLineName;
    }

    public void setBi_scLineName(String bi_scLineName) {
        this.bi_scLineName = bi_scLineName;
    }

    public String getBi_scLineScale() {
        return bi_scLineScale;
    }

    public void setBi_scLineScale(String bi_scLineScale) {
        this.bi_scLineScale = bi_scLineScale;
    }

    public String getBi_qyAddress() {
        return bi_qyAddress;
    }

    public void setBi_qyAddress(String bi_qyAddress) {
        this.bi_qyAddress = bi_qyAddress;
    }

    public String getBi_linkman() {
        return bi_linkman;
    }

    public void setBi_linkman(String bi_linkman) {
        this.bi_linkman = bi_linkman;
    }

    public String getBi_phoneNumber() {
        return bi_phoneNumber;
    }

    public void setBi_phoneNumber(String bi_phoneNumber) {
        this.bi_phoneNumber = bi_phoneNumber;
    }

    public String getZyxh_slcl() {
        return zyxh_slcl;
    }

    public void setZyxh_slcl(String zyxh_slcl) {
        this.zyxh_slcl = zyxh_slcl;
    }

    public String getZyxh_sncl() {
        return zyxh_sncl;
    }

    public void setZyxh_sncl(String zyxh_sncl) {
        this.zyxh_sncl = zyxh_sncl;
    }

    public String getNyxh_slfmdh() {
        return nyxh_slfmdh;
    }

    public void setNyxh_slfmdh(String nyxh_slfmdh) {
        this.nyxh_slfmdh = nyxh_slfmdh;
    }

    public String getNyxh_kbslmh() {
        return nyxh_kbslmh;
    }

    public void setNyxh_kbslmh(String nyxh_kbslmh) {
        this.nyxh_kbslmh = nyxh_kbslmh;
    }

    public String getNyxh_kbsldh() {
        return nyxh_kbsldh;
    }

    public void setNyxh_kbsldh(String nyxh_kbsldh) {
        this.nyxh_kbsldh = nyxh_kbsldh;
    }

    public String getNyxh_kbslnh() {
        return nyxh_kbslnh;
    }

    public void setNyxh_kbslnh(String nyxh_kbslnh) {
        this.nyxh_kbslnh = nyxh_kbslnh;
    }

    public String getNyxh_kbsndh() {
        return nyxh_kbsndh;
    }

    public void setNyxh_kbsndh(String nyxh_kbsndh) {
        this.nyxh_kbsndh = nyxh_kbsndh;
    }

    public String getNyxh_kbsnnh() {
        return nyxh_kbsnnh;
    }

    public void setNyxh_kbsnnh(String nyxh_kbsnnh) {
        this.nyxh_kbsnnh = nyxh_kbsnnh;
    }

    public String getNyxh_dwslfdl() {
        return nyxh_dwslfdl;
    }

    public void setNyxh_dwslfdl(String nyxh_dwslfdl) {
        this.nyxh_dwslfdl = nyxh_dwslfdl;
    }

    public String getFqpf_pd_sl() {
        return fqpf_pd_sl;
    }

    public void setFqpf_pd_sl(String fqpf_pd_sl) {
        this.fqpf_pd_sl = fqpf_pd_sl;
    }

    public String getFqpf_pd_ccfs() {
        return fqpf_pd_ccfs;
    }

    public void setFqpf_pd_ccfs(String fqpf_pd_ccfs) {
        this.fqpf_pd_ccfs = fqpf_pd_ccfs;
    }

    public String getFqpf_txgy() {
        return fqpf_txgy;
    }

    public void setFqpf_txgy(String fqpf_txgy) {
        this.fqpf_txgy = fqpf_txgy;
    }

    public String getZysb_slm_fmfs() {
        return zysb_slm_fmfs;
    }

    public void setZysb_slm_fmfs(String zysb_slm_fmfs) {
        this.zysb_slm_fmfs = zysb_slm_fmfs;
    }

    public String getZysb_slm_ggxh() {
        return zysb_slm_ggxh;
    }

    public void setZysb_slm_ggxh(String zysb_slm_ggxh) {
        this.zysb_slm_ggxh = zysb_slm_ggxh;
    }

    public String getZysb_slm_sl() {
        return zysb_slm_sl;
    }

    public void setZysb_slm_sl(String zysb_slm_sl) {
        this.zysb_slm_sl = zysb_slm_sl;
    }

    public String getZysb_snm_fmfs() {
        return zysb_snm_fmfs;
    }

    public void setZysb_snm_fmfs(String zysb_snm_fmfs) {
        this.zysb_snm_fmfs = zysb_snm_fmfs;
    }

    public String getZysb_snm_ggxh() {
        return zysb_snm_ggxh;
    }

    public void setZysb_snm_ggxh(String zysb_snm_ggxh) {
        this.zysb_snm_ggxh = zysb_snm_ggxh;
    }

    public String getZysb_snm_sl() {
        return zysb_snm_sl;
    }

    public void setZysb_snm_sl(String zysb_snm_sl) {
        this.zysb_snm_sl = zysb_snm_sl;
    }

    public String getZysb_y_gg() {
        return zysb_y_gg;
    }

    public void setZysb_y_gg(String zysb_y_gg) {
        this.zysb_y_gg = zysb_y_gg;
    }
}

package com.whut.cailiao.ms.api.model.search.wjcontent.baseinfo;

/**
 * Created by gammaniu on 16/4/29.
 */
public class BaseInfo {

    private String bi_qyName;
    private String bi_scLineName;
    private String bi_scLineScale;
    private String bi_qyAddress;
    private String bi_linkman;
    private String bi_phoneNumber;

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

    @Override
    public String toString() {
        return "BaseInfo{" +
                "bi_qyName='" + bi_qyName + '\'' +
                ", bi_scLineName='" + bi_scLineName + '\'' +
                ", bi_scLineScale='" + bi_scLineScale + '\'' +
                ", bi_qyAddress='" + bi_qyAddress + '\'' +
                ", bi_linkman='" + bi_linkman + '\'' +
                ", bi_phoneNumber='" + bi_phoneNumber + '\'' +
                '}';
    }
}

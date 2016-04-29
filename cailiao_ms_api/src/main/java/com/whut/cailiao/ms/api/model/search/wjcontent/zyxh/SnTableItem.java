package com.whut.cailiao.ms.api.model.search.wjcontent.zyxh;

/**
 * Created by gammaniu on 16/4/29.
 */
public class SnTableItem {

    private String zyxh_sn_yclName;
    private String zyxh_sn_yclXhqk;

    public String getZyxh_sn_yclName() {
        return zyxh_sn_yclName;
    }

    public void setZyxh_sn_yclName(String zyxh_sn_yclName) {
        this.zyxh_sn_yclName = zyxh_sn_yclName;
    }

    public String getZyxh_sn_yclXhqk() {
        return zyxh_sn_yclXhqk;
    }

    public void setZyxh_sn_yclXhqk(String zyxh_sn_yclXhqk) {
        this.zyxh_sn_yclXhqk = zyxh_sn_yclXhqk;
    }

    @Override
    public String toString() {
        return "SnTableItem{" +
                "zyxh_sn_yclName='" + zyxh_sn_yclName + '\'' +
                ", zyxh_sn_yclXhqk='" + zyxh_sn_yclXhqk + '\'' +
                '}';
    }
}

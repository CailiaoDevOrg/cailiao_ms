package com.whut.cailiao.ms.api.model.search.wjcontent.zyxh;

/**
 * Created by gammaniu on 16/4/29.
 */
public class SlTableItem {

    private String zyxh_sl_yclName;
    private String zyxh_sl_yclXhqk;

    public String getZyxh_sl_yclName() {
        return zyxh_sl_yclName;
    }

    public void setZyxh_sl_yclName(String zyxh_sl_yclName) {
        this.zyxh_sl_yclName = zyxh_sl_yclName;
    }

    public String getZyxh_sl_yclXhqk() {
        return zyxh_sl_yclXhqk;
    }

    public void setZyxh_sl_yclXhqk(String zyxh_sl_yclXhqk) {
        this.zyxh_sl_yclXhqk = zyxh_sl_yclXhqk;
    }

    @Override
    public String toString() {
        return "SlTableItem{" +
                "zyxh_sl_yclName='" + zyxh_sl_yclName + '\'' +
                ", zyxh_sl_yclXhqk='" + zyxh_sl_yclXhqk + '\'' +
                '}';
    }
}

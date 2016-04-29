package com.whut.cailiao.ms.api.model.search.wjcontent.zyxh;

/**
 * Created by gammaniu on 16/4/29.
 */
public class RlTableItem {

    private String zyxh_rl_yclName;
    private String zyxh_rl_yclXhqk;

    public String getZyxh_rl_yclName() {
        return zyxh_rl_yclName;
    }

    public void setZyxh_rl_yclName(String zyxh_rl_yclName) {
        this.zyxh_rl_yclName = zyxh_rl_yclName;
    }

    public String getZyxh_rl_yclXhqk() {
        return zyxh_rl_yclXhqk;
    }

    public void setZyxh_rl_yclXhqk(String zyxh_rl_yclXhqk) {
        this.zyxh_rl_yclXhqk = zyxh_rl_yclXhqk;
    }

    @Override
    public String toString() {
        return "RlTableItem{" +
                "zyxh_rl_yclName='" + zyxh_rl_yclName + '\'' +
                ", zyxh_rl_yclXhqk='" + zyxh_rl_yclXhqk + '\'' +
                '}';
    }
}

package com.whut.cailiao.ms.api.model.search.wjcontent.zyxh;

import java.util.List;

/**
 * Created by gammaniu on 16/4/29.
 */
public class Zyxh {

    private List<SlTableItem> slTable;

    private List<RlTableItem> rlTable;

    private String zyxh_slcl;

    private List<SnTableItem> snTable;

    private String zyxh_sncl;

    public List<SlTableItem> getSlTable() {
        return slTable;
    }

    public void setSlTable(List<SlTableItem> slTable) {
        this.slTable = slTable;
    }

    public List<RlTableItem> getRlTable() {
        return rlTable;
    }

    public void setRlTable(List<RlTableItem> rlTable) {
        this.rlTable = rlTable;
    }

    public String getZyxh_slcl() {
        return zyxh_slcl;
    }

    public void setZyxh_slcl(String zyxh_slcl) {
        this.zyxh_slcl = zyxh_slcl;
    }

    public List<SnTableItem> getSnTable() {
        return snTable;
    }

    public void setSnTable(List<SnTableItem> snTable) {
        this.snTable = snTable;
    }

    public String getZyxh_sncl() {
        return zyxh_sncl;
    }

    public void setZyxh_sncl(String zyxh_sncl) {
        this.zyxh_sncl = zyxh_sncl;
    }

    @Override
    public String toString() {
        return "Zyxh{" +
                "slTable=" + slTable +
                ", rlTable=" + rlTable +
                ", zyxh_slcl='" + zyxh_slcl + '\'' +
                ", snTable=" + snTable +
                ", zyxh_sncl='" + zyxh_sncl + '\'' +
                '}';
    }
}

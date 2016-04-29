package com.whut.cailiao.ms.api.model.search.wjcontent.fqpf;

import java.util.List;

/**
 * Created by gammaniu on 16/4/29.
 */
public class Fqpf {

    private List<KlwTableItem> klwTable;

    private List<FqTableItem> fqTable;

    private String fqpf_pd_sl;

    private String fqpf_pd_ccfs;

    private String fqpf_txgy;

    public List<KlwTableItem> getKlwTable() {
        return klwTable;
    }

    public void setKlwTable(List<KlwTableItem> klwTable) {
        this.klwTable = klwTable;
    }

    public List<FqTableItem> getFqTable() {
        return fqTable;
    }

    public void setFqTable(List<FqTableItem> fqTable) {
        this.fqTable = fqTable;
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

    @Override
    public String toString() {
        return "Fqpf{" +
                "fqpf_txgy='" + fqpf_txgy + '\'' +
                ", fqpf_pd_ccfs='" + fqpf_pd_ccfs + '\'' +
                ", fqpf_pd_sl='" + fqpf_pd_sl + '\'' +
                ", fqTable=" + fqTable +
                ", klwTable=" + klwTable +
                '}';
    }
}

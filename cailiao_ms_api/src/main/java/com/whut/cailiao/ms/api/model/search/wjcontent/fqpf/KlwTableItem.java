package com.whut.cailiao.ms.api.model.search.wjcontent.fqpf;

/**
 * Created by gammaniu on 16/4/29.
 */
public class KlwTableItem {

    private String pos;
    private String fqpf_klw_npfl;
    private String fqpf_klw_pfnd;
    private String fqpf_klw_ccfs;

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public String getFqpf_klw_npfl() {
        return fqpf_klw_npfl;
    }

    public void setFqpf_klw_npfl(String fqpf_klw_npfl) {
        this.fqpf_klw_npfl = fqpf_klw_npfl;
    }

    public String getFqpf_klw_pfnd() {
        return fqpf_klw_pfnd;
    }

    public void setFqpf_klw_pfnd(String fqpf_klw_pfnd) {
        this.fqpf_klw_pfnd = fqpf_klw_pfnd;
    }

    public String getFqpf_klw_ccfs() {
        return fqpf_klw_ccfs;
    }

    public void setFqpf_klw_ccfs(String fqpf_klw_ccfs) {
        this.fqpf_klw_ccfs = fqpf_klw_ccfs;
    }

    @Override
    public String toString() {
        return "KlwTableItem{" +
                "pos='" + pos + '\'' +
                ", fqpf_klw_npfl='" + fqpf_klw_npfl + '\'' +
                ", fqpf_klw_pfnd='" + fqpf_klw_pfnd + '\'' +
                ", fqpf_klw_ccfs='" + fqpf_klw_ccfs + '\'' +
                '}';
    }
}

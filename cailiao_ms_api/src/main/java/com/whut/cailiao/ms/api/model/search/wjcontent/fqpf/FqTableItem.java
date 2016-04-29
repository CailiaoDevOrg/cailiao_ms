package com.whut.cailiao.ms.api.model.search.wjcontent.fqpf;

/**
 * Created by gammaniu on 16/4/29.
 */
public class FqTableItem {

    private String pos;
    private String fqpf_fq_npfl;
    private String fqpf_fq_pfnd;
    private String fqpf_fq_ccfs;

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public String getFqpf_fq_npfl() {
        return fqpf_fq_npfl;
    }

    public void setFqpf_fq_npfl(String fqpf_fq_npfl) {
        this.fqpf_fq_npfl = fqpf_fq_npfl;
    }

    public String getFqpf_fq_pfnd() {
        return fqpf_fq_pfnd;
    }

    public void setFqpf_fq_pfnd(String fqpf_fq_pfnd) {
        this.fqpf_fq_pfnd = fqpf_fq_pfnd;
    }

    public String getFqpf_fq_ccfs() {
        return fqpf_fq_ccfs;
    }

    public void setFqpf_fq_ccfs(String fqpf_fq_ccfs) {
        this.fqpf_fq_ccfs = fqpf_fq_ccfs;
    }

    @Override
    public String toString() {
        return "FqTableItem{" +
                "pos='" + pos + '\'' +
                ", fqpf_fq_npfl='" + fqpf_fq_npfl + '\'' +
                ", fqpf_fq_pfnd='" + fqpf_fq_pfnd + '\'' +
                ", fqpf_fq_ccfs='" + fqpf_fq_ccfs + '\'' +
                '}';
    }
}

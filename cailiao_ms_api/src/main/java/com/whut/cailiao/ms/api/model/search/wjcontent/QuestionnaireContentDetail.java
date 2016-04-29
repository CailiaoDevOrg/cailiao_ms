package com.whut.cailiao.ms.api.model.search.wjcontent;

import com.whut.cailiao.ms.api.model.search.wjcontent.baseinfo.BaseInfo;
import com.whut.cailiao.ms.api.model.search.wjcontent.fqpf.Fqpf;
import com.whut.cailiao.ms.api.model.search.wjcontent.xyxh.Nyxh;
import com.whut.cailiao.ms.api.model.search.wjcontent.zysb.Zysb;
import com.whut.cailiao.ms.api.model.search.wjcontent.zyxh.Zyxh;

/**
 * Created by gammaniu on 16/4/29.
 */
public class QuestionnaireContentDetail {

    private BaseInfo baseinfo;

    private Zyxh zyxh;

    private Nyxh nyxh;

    private Fqpf fqpf;

    private Zysb zysb;

    public BaseInfo getBaseinfo() {
        return baseinfo;
    }

    public void setBaseinfo(BaseInfo baseinfo) {
        this.baseinfo = baseinfo;
    }

    public Zyxh getZyxh() {
        return zyxh;
    }

    public void setZyxh(Zyxh zyxh) {
        this.zyxh = zyxh;
    }

    public Nyxh getNyxh() {
        return nyxh;
    }

    public void setNyxh(Nyxh nyxh) {
        this.nyxh = nyxh;
    }

    public Fqpf getFqpf() {
        return fqpf;
    }

    public void setFqpf(Fqpf fqpf) {
        this.fqpf = fqpf;
    }

    public Zysb getZysb() {
        return zysb;
    }

    public void setZysb(Zysb zysb) {
        this.zysb = zysb;
    }

    @Override
    public String toString() {
        return "QuestionnaireContentDetail{" +
                "zysb=" + zysb +
                ", fqpf=" + fqpf +
                ", nyxh=" + nyxh +
                ", zyxh=" + zyxh +
                ", baseinfo=" + baseinfo +
                '}';
    }
}

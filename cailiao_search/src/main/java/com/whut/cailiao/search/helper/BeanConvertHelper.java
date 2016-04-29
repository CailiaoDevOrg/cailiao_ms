package com.whut.cailiao.search.helper;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.whut.cailiao.ms.api.model.search.wjcontent.QuestionnaireContentDetail;
import com.whut.cailiao.ms.api.model.search.wjcontent.baseinfo.BaseInfo;
import com.whut.cailiao.ms.api.model.search.wjcontent.fqpf.FqTableItem;
import com.whut.cailiao.ms.api.model.search.wjcontent.fqpf.Fqpf;
import com.whut.cailiao.ms.api.model.search.wjcontent.fqpf.KlwTableItem;
import com.whut.cailiao.ms.api.model.search.wjcontent.xyxh.Nyxh;
import com.whut.cailiao.ms.api.model.search.wjcontent.zysb.Zysb;
import com.whut.cailiao.ms.api.model.search.wjcontent.zyxh.RlTableItem;
import com.whut.cailiao.ms.api.model.search.wjcontent.zyxh.SlTableItem;
import com.whut.cailiao.ms.api.model.search.wjcontent.zyxh.SnTableItem;
import com.whut.cailiao.ms.api.model.search.wjcontent.zyxh.Zyxh;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gammaniu on 16/4/29.
 */
public final class BeanConvertHelper {

    public static QuestionnaireContentDetail convertJsonContentToBean(String jsonContent) {
        if (StringUtils.isBlank(jsonContent)) {
            return null;
        }
        QuestionnaireContentDetail questionnaireContentDetail = new QuestionnaireContentDetail();
        JSONObject jsonContentObj = JSON.parseObject(jsonContent);

        // 创建基本信息
        JSONObject baseinfoObj = jsonContentObj.getJSONObject("baseinfo");
        BaseInfo baseInfo = new BaseInfo();
        baseInfo.setBi_qyName(baseinfoObj.getString("bi_qyName"));
        baseInfo.setBi_scLineName(baseinfoObj.getString("bi_scLineName"));
        baseInfo.setBi_scLineScale(baseinfoObj.getString("bi_scLineScale"));
        baseInfo.setBi_qyAddress(baseinfoObj.getString("bi_qyAddress"));
        baseInfo.setBi_linkman(baseinfoObj.getString("bi_linkman"));
        baseInfo.setBi_phoneNumber(baseinfoObj.getString("bi_phoneNumber"));
        questionnaireContentDetail.setBaseinfo(baseInfo);

        // 创建资源消耗
        JSONObject zyxhObj = jsonContentObj.getJSONObject("zyxh");
        Zyxh zyxh = new Zyxh();
        List<RlTableItem> rlTableItemList = new ArrayList<>();
        JSONArray rlTableJSONArr = zyxhObj.getJSONArray("rlTable");
        for (int i = 0; i < rlTableJSONArr.size(); i++) {
            JSONObject rlTableItemObj = rlTableJSONArr.getJSONObject(i);
            RlTableItem rlTableItem = new RlTableItem();
            rlTableItem.setZyxh_rl_yclName(rlTableItemObj.getString("zyxh_rl_yclName"));
            rlTableItem.setZyxh_rl_yclXhqk(rlTableItemObj.getString("zyxh_rl_yclXhqk"));
            rlTableItemList.add(rlTableItem);
        }
        zyxh.setRlTable(rlTableItemList);

        List<SlTableItem> slTableItemList = new ArrayList<>();
        JSONArray slTableJSONArr = zyxhObj.getJSONArray("slTable");
        for (int i = 0; i < slTableJSONArr.size(); i++) {
            JSONObject slTableItemObj = slTableJSONArr.getJSONObject(i);
            SlTableItem slTableItem = new SlTableItem();
            slTableItem.setZyxh_sl_yclName(slTableItemObj.getString("zyxh_sl_yclName"));
            slTableItem.setZyxh_sl_yclXhqk(slTableItemObj.getString("zyxh_sl_yclXhqk"));
            slTableItemList.add(slTableItem);
        }
        zyxh.setSlTable(slTableItemList);

        List<SnTableItem> snTableItemList = new ArrayList<>();
        JSONArray snTableJSONArr = zyxhObj.getJSONArray("snTable");
        for (int i = 0; i < snTableJSONArr.size(); i++) {
            JSONObject snTableItemObj = snTableJSONArr.getJSONObject(i);
            SnTableItem snTableItem = new SnTableItem();
            snTableItem.setZyxh_sn_yclName(snTableItemObj.getString("zyxh_sn_yclName"));
            snTableItem.setZyxh_sn_yclXhqk(snTableItemObj.getString("zyxh_sn_yclXhqk"));
            snTableItemList.add(snTableItem);
        }
        zyxh.setSnTable(snTableItemList);

        zyxh.setZyxh_slcl(zyxhObj.getString("zyxh_slcl"));
        zyxh.setZyxh_sncl(zyxhObj.getString("zyxh_sncl"));
        questionnaireContentDetail.setZyxh(zyxh);

        // 创建能源消耗
        JSONObject nyxhObj = jsonContentObj.getJSONObject("nyxh");
        Nyxh nyxh = new Nyxh();
        nyxh.setNyxh_dwslfdl(nyxhObj.getString("nyxh_dwslfdl"));
        nyxh.setNyxh_kbsldh(nyxhObj.getString("nyxh_kbsldh"));
        nyxh.setNyxh_kbslmh(nyxhObj.getString("nyxh_kbslmh"));
        nyxh.setNyxh_kbslnh(nyxhObj.getString("nyxh_kbslnh"));
        nyxh.setNyxh_kbsndh(nyxhObj.getString("nyxh_kbsndh"));
        nyxh.setNyxh_slfmdh(nyxhObj.getString("nyxh_slfmdh"));
        nyxh.setNyxh_kbsnnh(nyxhObj.getString("nyxh_kbsnnh"));
        questionnaireContentDetail.setNyxh(nyxh);

        // 创建废气排放
        JSONObject fqpfObj = jsonContentObj.getJSONObject("fqpf");
        Fqpf fqpf = new Fqpf();
        fqpf.setFqpf_pd_sl(fqpfObj.getString("fqpf_pd_sl"));
        fqpf.setFqpf_pd_ccfs(fqpfObj.getString("fqpf_pd_ccfs"));
        fqpf.setFqpf_txgy(fqpfObj.getString("fqpf_txgy"));

        List<KlwTableItem> klwTableItemList = new ArrayList<>();
        JSONArray klwTableJSONArr = fqpfObj.getJSONArray("klwTable");
        for (int i = 0; i < klwTableJSONArr.size(); i++) {
            JSONObject klwTableItemObj = klwTableJSONArr.getJSONObject(i);
            KlwTableItem klwTableItem = new KlwTableItem();
            klwTableItem.setFqpf_klw_ccfs(klwTableItemObj.getString("fqpf_klw_ccfs"));
            klwTableItem.setFqpf_klw_npfl(klwTableItemObj.getString("fqpf_klw_npfl"));
            klwTableItem.setFqpf_klw_pfnd(klwTableItemObj.getString("fqpf_klw_pfnd"));
            klwTableItemList.add(klwTableItem);
        }
        fqpf.setKlwTable(klwTableItemList);

        List<FqTableItem> fqTableItemList = new ArrayList<>();
        JSONArray fqTableJSONArr = fqpfObj.getJSONArray("fqTable");
        for (int i = 0; i < fqTableJSONArr.size(); i++) {
            JSONObject fqTableItemObj = fqTableJSONArr.getJSONObject(i);
            FqTableItem fqTableItem = new FqTableItem();
            fqTableItem.setFqpf_fq_ccfs(fqTableItemObj.getString("fqpf_fq_ccfs"));
            fqTableItem.setFqpf_fq_npfl(fqTableItemObj.getString("fqpf_fq_npfl"));
            fqTableItem.setFqpf_fq_pfnd(fqTableItemObj.getString("fqpf_fq_pfnd"));
            fqTableItemList.add(fqTableItem);
        }
        fqpf.setFqTable(fqTableItemList);

        // 创建主要设备
        JSONObject zysbObj = jsonContentObj.getJSONObject("zysb");
        Zysb zysb = new Zysb();
        zysb.setZysb_slm_fmfs(zysbObj.getString("zysb_slm_fmfs"));
        zysb.setZysb_slm_ggxh(zysbObj.getString("zysb_slm_ggxh"));
        zysb.setZysb_slm_sl(zysbObj.getString("zysb_slm_sl"));
        zysb.setZysb_snm_fmfs(zysbObj.getString("zysb_snm_fmfs"));
        zysb.setZysb_snm_ggxh(zysbObj.getString("zysb_snm_ggxh"));
        zysb.setZysb_snm_sl(zysbObj.getString("zysb_snm_sl"));
        zysb.setZysb_y_gg(zysbObj.getString("zysb_y_gg"));
        questionnaireContentDetail.setZysb(zysb);

        return questionnaireContentDetail;
    }

}




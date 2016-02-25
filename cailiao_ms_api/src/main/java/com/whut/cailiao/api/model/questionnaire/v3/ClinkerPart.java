package com.whut.cailiao.api.model.questionnaire.v3;

import java.io.Serializable;
import java.util.List;

/**
 * 熟料信息
 * 
 * @author niuyang
 *
 */
public class ClinkerPart implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private List<ClinkerItem> clinkerItemList;
    
    public List<ClinkerItem> getClinkerItemList() {
        return clinkerItemList;
    }

    public void setClinkerItemList(List<ClinkerItem> clinkerItemList) {
        this.clinkerItemList = clinkerItemList;
    }

    /** 熟料表数据项 */
    public class ClinkerItem implements Serializable {

        private static final long serialVersionUID = 1L;
        /** 熟料名称 */
        private String name;
        /** 万吨每年 */
        private float wtonsPerYear;
        
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public float getWtonsPerYear() {
            return wtonsPerYear;
        }

        public void setWtonsPerYear(float wtonsPerYear) {
            this.wtonsPerYear = wtonsPerYear;
        }
    }

}


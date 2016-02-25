package com.whut.cailiao.api.model.questionnaire.v3;

import java.io.Serializable;
import java.util.List;

/**
 * 水泥原料
 * 
 * @author niuyang
 *
 */
public class CementStonePart implements Serializable {

    private static final long serialVersionUID = 1L;
    
    /** 表中数据 */
    private List<CementStone> cementStoneList;
    /** 熟料产量 */
    private float clinkerProduction;
    /** 水泥产量 */
    private float cementProduction;
    
    public float getClinkerProduction() {
        return clinkerProduction;
    }

    public void setClinkerProduction(float clinkerProduction) {
        this.clinkerProduction = clinkerProduction;
    }

    public float getCementProduction() {
        return cementProduction;
    }

    public void setCementProduction(float cementProduction) {
        this.cementProduction = cementProduction;
    }

    public List<CementStone> getCementStoneList() {
        return cementStoneList;
    }

    public void setCementStoneList(List<CementStone> cementStoneList) {
        this.cementStoneList = cementStoneList;
    }

    public class CementStone implements Serializable {
        
        private static final long serialVersionUID = 1L;
        /** 水泥原料名称 */
        private String name;
        /** 消耗情况，万吨/年 */
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

package com.whut.cailiao.api.model.questionnaire.v3;

import java.io.Serializable;
import java.util.List;

/**
 * 燃料信息 
 * Created by niuyang on 16/2/25.
 */
public class FuelPart implements Serializable {

    private static final long serialVersionUID = 1L;
    
    /** 表中数据 */
    private List<FuelItem> fuelItemList;
    
    public List<FuelItem> getFuelItemList() {
        return fuelItemList;
    }

    public void setFuelItemList(List<FuelItem> fuelItemList) {
        this.fuelItemList = fuelItemList;
    }

    public class FuelItem implements Serializable {
        
        private static final long serialVersionUID = 1L;
        /** 燃料名称 */
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

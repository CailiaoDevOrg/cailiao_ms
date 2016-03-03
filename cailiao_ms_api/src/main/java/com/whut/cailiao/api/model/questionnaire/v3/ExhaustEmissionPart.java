package com.whut.cailiao.api.model.questionnaire.v3;

import java.io.Serializable;
import java.util.List;

/**
 * 废气排放部分
 * 
 * @author niuyang
 *
 */
public class ExhaustEmissionPart implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    
    /** 排放项数据列表 */
    private List<ExhaustEmissionItem> exhaustEmissionItemList;
    /** 喷氨(kg/t熟料) */
    private float ammoniaJetting;
    /** 脱硝工艺 */
    private boolean isSNCR;
    private boolean isFractionalCombustion; // 分级燃烧
    private boolean isOneAndTwo; // 1+2
    private boolean isOther; // 其他

    
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<ExhaustEmissionItem> getExhaustEmissionItemList() {
        return exhaustEmissionItemList;
    }

    public void setExhaustEmissionItemList(List<ExhaustEmissionItem> exhaustEmissionItemList) {
        this.exhaustEmissionItemList = exhaustEmissionItemList;
    }

    public float getAmmoniaJetting() {
        return ammoniaJetting;
    }

    public void setAmmoniaJetting(float ammoniaJetting) {
        this.ammoniaJetting = ammoniaJetting;
    }

    public boolean isSNCR() {
        return isSNCR;
    }

    public void setSNCR(boolean isSNCR) {
        this.isSNCR = isSNCR;
    }

    public boolean isFractionalCombustion() {
        return isFractionalCombustion;
    }

    public void setFractionalCombustion(boolean isFractionalCombustion) {
        this.isFractionalCombustion = isFractionalCombustion;
    }

    public boolean isOneAndTwo() {
        return isOneAndTwo;
    }

    public void setOneAndTwo(boolean isOneAndTwo) {
        this.isOneAndTwo = isOneAndTwo;
    }

    public boolean isOther() {
        return isOther;
    }

    public void setOther(boolean isOther) {
        this.isOther = isOther;
    }

    public class ExhaustEmissionItem implements Serializable {

        private static final long serialVersionUID = 1L;
        /** 项目类型 */
        private int projectType;
        /** 项目子类型 */
        private int projectSubType;
        /** 年排放量(吨/年) */
        private float tonsPerYear;
        /** 排放浓度(mg/m3) */
        private float emissionConcentration;
        /** 除尘方式(电/袋) */
        private String removeDustWay;

        public int getProjectType() {
            return projectType;
        }

        public void setProjectType(int projectType) {
            this.projectType = projectType;
        }

        public int getProjectSubType() {
            return projectSubType;
        }

        public void setProjectSubType(int projectSubType) {
            this.projectSubType = projectSubType;
        }

        public float getTonsPerYear() {
            return tonsPerYear;
        }

        public void setTonsPerYear(float tonsPerYear) {
            this.tonsPerYear = tonsPerYear;
        }

        public float getEmissionConcentration() {
            return emissionConcentration;
        }

        public void setEmissionConcentration(float emissionConcentration) {
            this.emissionConcentration = emissionConcentration;
        }

        public String getRemoveDustWay() {
            return removeDustWay;
        }

        public void setRemoveDustWay(String removeDustWay) {
            this.removeDustWay = removeDustWay;
        }

        public float getAmmoniaJetting() {
            return ammoniaJetting;
        }

    }
}

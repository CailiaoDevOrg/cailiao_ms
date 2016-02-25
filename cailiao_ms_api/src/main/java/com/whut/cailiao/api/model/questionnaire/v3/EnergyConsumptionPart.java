package com.whut.cailiao.api.model.questionnaire.v3;

import java.io.Serializable;

/**
 * 能耗部分
 * 
 * @author niuyang
 *
 */
public class EnergyConsumptionPart implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 生料粉末工段电耗(kWh/t) */
    private float powerConsumptionBySlfm;
    /** 可比熟料综合煤耗(kgce/t) */
    private float coalConsumptionByKbsl;
    /** 可比熟料综合电耗(kWh/t) */
    private float powerConsumptionByKbsl;
    /** 可比熟料综合能耗(kgce/t) */
    private float energyConsumptionByKbsl;
    /** 可比水泥综合电耗(kWh/t) */
    private float powerConsumptionByKbsn;
    /** 可比水泥综合能耗(kgce/t) */
    private float energyConsumptionByKbsn;
    /** 单位熟料余热发电量(kWh/t) */
    private float powerGenerationUnit;

    public float getPowerConsumptionBySlfm() {
        return powerConsumptionBySlfm;
    }

    public void setPowerConsumptionBySlfm(float powerConsumptionBySlfm) {
        this.powerConsumptionBySlfm = powerConsumptionBySlfm;
    }

    public float getCoalConsumptionByKbsl() {
        return coalConsumptionByKbsl;
    }

    public void setCoalConsumptionByKbsl(float coalConsumptionByKbsl) {
        this.coalConsumptionByKbsl = coalConsumptionByKbsl;
    }

    public float getPowerConsumptionByKbsl() {
        return powerConsumptionByKbsl;
    }

    public void setPowerConsumptionByKbsl(float powerConsumptionByKbsl) {
        this.powerConsumptionByKbsl = powerConsumptionByKbsl;
    }

    public float getEnergyConsumptionByKbsl() {
        return energyConsumptionByKbsl;
    }

    public void setEnergyConsumptionByKbsl(float energyConsumptionByKbsl) {
        this.energyConsumptionByKbsl = energyConsumptionByKbsl;
    }

    public float getPowerConsumptionByKbsn() {
        return powerConsumptionByKbsn;
    }

    public void setPowerConsumptionByKbsn(float powerConsumptionByKbsn) {
        this.powerConsumptionByKbsn = powerConsumptionByKbsn;
    }

    public float getEnergyConsumptionByKbsn() {
        return energyConsumptionByKbsn;
    }

    public void setEnergyConsumptionByKbsn(float energyConsumptionByKbsn) {
        this.energyConsumptionByKbsn = energyConsumptionByKbsn;
    }

    public float getPowerGenerationUnit() {
        return powerGenerationUnit;
    }

    public void setPowerGenerationUnit(float powerGenerationUnit) {
        this.powerGenerationUnit = powerGenerationUnit;
    }

}

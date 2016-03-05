package com.whut.cailiao.api.model.questionnaire.v3;

import java.io.Serializable;

/**
 * version3 问卷详细内容表,用于保存文件详细内容
 */
public class QuestionnaireContent implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 记录ID */
    private int id;
    /** 生产线名称**/

    private String productionLine;
    
    /** 水泥厂名称**/
    private String corName;
    public String getProductionLine() {
		return productionLine;
	}

	public void setProductionLine(String productionLine) {
		this.productionLine = productionLine;
	}

	public String getCorName() {
		return corName;
	}

	public void setCorName(String corName) {
		this.corName = corName;
	}

	/** 问卷ID */
    private int questionnaireId;
    /** 年份 */
    private int year;
    /** 吨位 */
    private float tons;
    /** 熟料烧成用原材料（含替代原料）部分 */
    private ClinkerPart clinkerPart;
    /** 燃料（含替代燃料）部分 */
    private FuelPart fuelPart;
    /** 水泥制成用原材料（含替代原料)部分 */
    private CementStonePart cementStonePart;
    /** 能源消耗 */
    private EnergyConsumptionPart energyConsumptionPart;
    /** 废气排放 */
    private ExhaustEmissionPart exhaustEmissionPart;
    /** 主要设备 */
    private MajorEquipmentPart majorEquipmentPart;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuestionnaireId() {
        return questionnaireId;
    }

    public void setQuestionnaireId(int questionnaireId) {
        this.questionnaireId = questionnaireId;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public float getTons() {
        return tons;
    }

    public void setTons(float tons) {
        this.tons = tons;
    }

    public ClinkerPart getClinkerPart() {
        return clinkerPart;
    }

    public void setClinkerPart(ClinkerPart clinkerPart) {
        this.clinkerPart = clinkerPart;
    }

    public FuelPart getFuelPart() {
        return fuelPart;
    }

    public void setFuelPart(FuelPart fuelPart) {
        this.fuelPart = fuelPart;
    }

    public CementStonePart getCementStonePart() {
        return cementStonePart;
    }

    public void setCementStonePart(CementStonePart cementStonePart) {
        this.cementStonePart = cementStonePart;
    }

    public EnergyConsumptionPart getEnergyConsumptionPart() {
        return energyConsumptionPart;
    }

    public void setEnergyConsumptionPart(EnergyConsumptionPart energyConsumptionPart) {
        this.energyConsumptionPart = energyConsumptionPart;
    }

    public ExhaustEmissionPart getExhaustEmissionPart() {
        return exhaustEmissionPart;
    }

    public void setExhaustEmissionPart(ExhaustEmissionPart exhaustEmissionPart) {
        this.exhaustEmissionPart = exhaustEmissionPart;
    }

    public MajorEquipmentPart getMajorEquipmentPart() {
        return majorEquipmentPart;
    }

    public void setMajorEquipmentPart(MajorEquipmentPart majorEquipmentPart) {
        this.majorEquipmentPart = majorEquipmentPart;
    }

}

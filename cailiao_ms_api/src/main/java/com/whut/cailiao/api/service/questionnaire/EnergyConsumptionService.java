package com.whut.cailiao.api.service.questionnaire;

import java.util.Map;

import com.whut.cailiao.api.model.questionnaire.v3.EnergyConsumptionPart;

/**
 * 能源消耗service的接口
 * @author zr
 *
 */
public interface EnergyConsumptionService {
	/**
	 * delete方法
	 * @param id
	 */
	public void detele(int id);
	
	/**
	 * save方法
	 * @param map
	 */
	public void save(EnergyConsumptionPart consumptionPart);
	
	/**
	 * find方法
	 * @param id
	 * @return
	 */
	public EnergyConsumptionPart find(int id);
	
	
	/**
	 * update方法
	 * @param map
	 */
	public void update(EnergyConsumptionPart consumptionPart);
}

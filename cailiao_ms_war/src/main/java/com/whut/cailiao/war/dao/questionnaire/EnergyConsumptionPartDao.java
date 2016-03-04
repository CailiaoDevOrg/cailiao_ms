package com.whut.cailiao.war.dao.questionnaire;

import java.util.Map;

import com.whut.cailiao.api.model.questionnaire.v3.EnergyConsumptionPart;

/**
 * EnergyConsumptionPart接口定义
 * @author zr
 *
 */
public interface EnergyConsumptionPartDao {
	
	/**
	 * 能源消耗增加方法
	 * @param map
	 */
	public void saveEnergyConsumptionPar(Map<String,Object> map);
	
	/**
	 * 能源消耗删除方法
	 * @param id
	 */
	public void deleteEnergyConsumptionPar(int id);
	
	/**
	 * 能源消耗查询方法
	 * @param id
	 * @return
	 */
	public EnergyConsumptionPart findEnergyConsumptionPar(int id);
	
	/**
	 * 能源消耗更新方法
	 * @param map
	 */
	public void updateEnergyConsumptionPar(Map<String,Object> map);
}

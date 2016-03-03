package com.whut.cailiao.war.dao.fuelPart;

import java.util.Map;

import com.whut.cailiao.api.model.questionnaire.v3.FuelPart;

/**
 * 燃料信息dao接口
 * @author zr
 *
 */
public interface FuelPartDao {
	public void deleteFuelPart(int id);
	
	public void updateFuelPart(Map<String,Object> map);
	
	public void saveFuelPart(Map<String,Object> map);
	
	public FuelPart findFuelPart(int id);
}

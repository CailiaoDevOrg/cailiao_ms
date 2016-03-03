package com.whut.cailiao.api.service.fuelPart;

import com.whut.cailiao.api.model.questionnaire.v3.FuelPart;

/**
 * FuelPartService接口
 * @author zr
 *
 */

public interface FuelPartService {
	/**
	 * delete
	 * @param id
	 */
	public void deleteFuel(int id);
	
	/**
	 * save
	 * @param fuelPart
	 */
	public void saveFuelPart(FuelPart fuelPart);
	
	/**
	 * update
	 * @param fuelPart
	 */
	public void updateFuelPart(FuelPart fuelPart);
	
	/**
	 * find
	 * @param id
	 * @return
	 */
	public FuelPart findFuelPart(int id);
}

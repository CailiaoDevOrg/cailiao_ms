package com.whut.cailiao.api.service.exhaustEmission;

import com.whut.cailiao.api.model.questionnaire.v3.ExhaustEmissionPart;

/**
 * ExhaustEmission serive接口
 * @author zr
 *
 */
public interface ExhaustEmissionService {
	/**
	 * save
	 * @param exhaustEmissionpart
	 */
	public void saveExhaustEmission(ExhaustEmissionPart exhaustEmissionpart);
	
	/**
	 * delete
	 * @param id
	 */
	public void deleteExhaustEmission(int id);
	
	/**
	 * update
	 * @param xxhaustEmissionPart
	 */
	public void updateExhaustEmission(ExhaustEmissionPart xxhaustEmissionPart);
	
	/**
	 * find
	 * @param id
	 * @return
	 */
	public ExhaustEmissionPart findExhaustEmission(int id);
}

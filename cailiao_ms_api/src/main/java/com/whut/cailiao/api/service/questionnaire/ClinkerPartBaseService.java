package com.whut.cailiao.api.service.questionnaire;

import com.whut.cailiao.api.model.questionnaire.v3.ClinkerPart;

public interface ClinkerPartBaseService {
	/**
	 * 查询业务接口
	 * @param id
	 */
	public ClinkerPart findClikerPart(int id);
	
	/**
	 * 删除业务接口
	 * @param id
	 */
	public void deleteClinkerPart(int id);
	
	/**
	 * 更改业务接口
	 * @param clinkerPart
	 */
	public void updateClinkerPart(ClinkerPart clinkerPart);
	
	/**
	 * 增加业务接口
	 * @param clinkerPart
	 */
	public void saveClinkerPart(ClinkerPart clinkerPart);
	
	
	
}

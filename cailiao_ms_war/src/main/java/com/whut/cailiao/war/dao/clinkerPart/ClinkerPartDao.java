package com.whut.cailiao.war.dao.clinkerPart;

import java.util.Map;

import com.whut.cailiao.api.model.questionnaire.v3.ClinkerPart;
/**
 * 熟料dao
 * @author zr
 *
 */
public interface ClinkerPartDao {
	/**
	 * 保存ClinkerPart方法
	 * @param map
	 */
	public void saveClinkerPart(Map<String,Object> map);
	
	/**
	 * 删除ClinkerPart
	 * @param id
	 */
	public void deleteClinkerPart(int id);
	
	/**
	 * update方法
	 * @param map
	 */
	public void updateClinkerPart(Map<String,Object> map);
	
	/**
	 * 查询ClinkerPart
	 * @param id
	 * @return
	 */
	public ClinkerPart findClinkerPart(int id);
}

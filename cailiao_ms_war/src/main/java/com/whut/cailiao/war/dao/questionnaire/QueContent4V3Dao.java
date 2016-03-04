package com.whut.cailiao.war.dao.questionnaire;

import java.util.Map;

import com.whut.cailiao.api.model.questionnaire.v3.QueContent4V3;

/**
 * QueContent4V3 dao接口
 * @author zr
 *
 */
public interface QueContent4V3Dao {
	/**
	 * delete
	 * @param id
	 */
	public void deleteQueContent4V3(int id);
	
	/**
	 * save
	 * @param map
	 */
	public void saveQueContent4V3(Map<String,Object> map);
	
	/**
	 * find
	 * @param id
	 * @return
	 */
	public QueContent4V3 findQueContent4V3(int id);
	
	/**
	 * update
	 * @param map
	 */
	public void updateQueContent4V3(Map<String,Object> map);
}

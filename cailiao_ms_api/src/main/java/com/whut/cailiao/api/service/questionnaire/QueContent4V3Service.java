package com.whut.cailiao.api.service.questionnaire;

import com.whut.cailiao.api.model.questionnaire.v3.QueContent4V3;

/**
 * QueContent4V3Service接口
 * @author zr
 *
 */
public interface QueContent4V3Service {
	
	/**
	 * delete
	 * @param id
	 */
	public void deleteQueContent4V3(int id);
	
	/**
	 * save
	 * @param queContent
	 */
	public void saveQueContent4V3(QueContent4V3 queContent);
	
	/**
	 * update
	 * @param queContent
	 */
	public void updateQueContent4V3(QueContent4V3 queContent);
	
	/**
	 * find
	 * @param id
	 * @return
	 */
	public QueContent4V3 findQueContent4V3(int id);
}

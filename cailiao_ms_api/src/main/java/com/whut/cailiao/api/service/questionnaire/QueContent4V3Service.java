package com.whut.cailiao.api.service.questionnaire;

import com.whut.cailiao.api.model.questionnaire.v3.QuestionnaireContent;

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
	public void saveQueContent4V3(QuestionnaireContent queContent);
	
	/**
	 * update
	 * @param queContent
	 */
	public void updateQueContent4V3(QuestionnaireContent queContent);
	
	/**
	 * find
	 * @param id
	 * @return
	 */
	public QuestionnaireContent findQueContent4V3(int id);
}

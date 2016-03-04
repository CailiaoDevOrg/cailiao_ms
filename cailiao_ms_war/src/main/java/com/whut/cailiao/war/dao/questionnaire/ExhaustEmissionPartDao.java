package com.whut.cailiao.war.dao.questionnaire;

import java.util.Map;

import com.whut.cailiao.api.model.questionnaire.v3.ExhaustEmissionPart;

/**
 * 废气排放部分的dao接口
 * @author zr
 *
 */
public interface ExhaustEmissionPartDao {
	/**
	 * 删除
	 * @param id
	 */
	public void deleteExhaustEmissionPart(int id);
	
	/**
	 * 保存
	 * @param exhaustEmissionPart
	 */
	public void saveExhaustEmissionPart(Map<String,Object> map);
	
	/**
	 * 查找   
	 * @param id
	 * @return
	 */
	public ExhaustEmissionPart findExhaustEmissionPart(int id);
	
	/**
	 * 更改
	 * @param exhaustEmissionPart
	 */
	public void updateExhaustEmissionPart(Map<String,Object> map);
}

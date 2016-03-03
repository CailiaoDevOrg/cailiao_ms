package com.whut.cailiao.war.dao.cementStonePart;

import java.util.Map;

import com.whut.cailiao.api.model.questionnaire.Questionnaire;
import com.whut.cailiao.api.model.questionnaire.v3.CementStonePart;

public interface CementStonePartDao {

	/**
	 * 根据id 查询数据
	 * 
	 * @param id
	 * @return
	 */
	CementStonePart selectCementStonePartById(int id);

	/**
	 * 插入新数据
	 */
	void insertNewCementStonePart(Map<String, Object> map);

	/**
	 * 删除问卷
	 * 
	 * @param id
	 */
	void deleteCementStonePartById(int id);

	/**
	 * 更新问卷
	 * 
	 * @param map
	 */
	void updateCementStonePartItem(Map<String, Object> map);
}

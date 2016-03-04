package com.whut.cailiao.api.service.questionnaire;

import com.whut.cailiao.api.model.questionnaire.v3.CementStonePart;

/**
 * 水泥制成原材料
 * @author zr
 *
 */
public interface CementStonePartBaseService {
	
	
	
	/**
	 * 保存水泥原材料信息
	 * @param cementStonePart
	 */
	void saveCementStonePart(CementStonePart cementStonePart);

	/**
	 * 更新水泥原材料信息
	 * @param cementStonePart
	 */
	void updateCementStonePart(CementStonePart cementStonePart);

	/**
	 * 根据id删除水泥原材料信息
	 * @param id
	 */
	void deleteCementStonePartById(int id);

	/**
	 * 根据问卷id获取水泥原材料详情
	 * @param id
	 * @return
	 */
	CementStonePart getCementStonePartById(int id);

}

package com.whut.cailiao.war.sevice.impl.cementStonePart;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whut.cailiao.api.model.questionnaire.v3.CementStonePart;
import com.whut.cailiao.api.service.cementStonePart.CementStonePartBaseService;
import com.whut.cailiao.war.dao.cementStonePart.CementStonePartDao;
import com.whut.cailiao.war.utils.redis.RedisSupport;

@Service("cementStonePartBaseService")
public class CementStonePartBaseServiceImpl extends RedisSupport implements CementStonePartBaseService {
	@Autowired
	private CementStonePartDao cementStonePartDao;
	@Override
	public void saveCementStonePart(CementStonePart cementStonePart) {
		if(cementStonePart==null){
			return ;
		}	
		Map<String,Object> map=new HashMap<>();
		map.put("cementStoneList", cementStonePart.getCementStoneList());
		map.put("cementProduction", cementStonePart.getCementProduction());
		map.put("clinkerProduction", cementStonePart.getClinkerProduction());
		cementStonePartDao.insertNewCementStonePart(map);	
		
	}

	@Override
	public void updateCementStonePart(CementStonePart cementStonePart) {
			if(cementStonePart==null||cementStonePart.getId()<=0){
				return ;
			}
			Map<String,Object> map=new HashMap<>();
			map.put("cementStoneList", cementStonePart.getCementStoneList());
			String key="cementStonePart"+cementStonePart.getId();
			deleteTestData(key);
	}

	@Override
	public void deleteCementStonePartById(int id) {
		if(id<=0){
			return ;
		}
		this.cementStonePartDao.deleteCementStonePartById(id);
		String key="cementStonePart"+id;
		deleteTestData(key);
	}

	@Override
	public CementStonePart getCementStonePartById(int id) {
		String key="cementStonePart"+id;
		CementStonePart cementStonePart=(CementStonePart)getTestData(key);
		if(cementStonePart==null){
			cementStonePart=this.cementStonePartDao.selectCementStonePartById(id);
			setTestData(key,cementStonePart);
		}
		return cementStonePart;
	}

}

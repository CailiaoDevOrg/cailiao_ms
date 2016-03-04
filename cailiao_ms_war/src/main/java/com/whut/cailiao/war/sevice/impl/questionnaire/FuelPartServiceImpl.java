package com.whut.cailiao.war.sevice.impl.questionnaire;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.whut.cailiao.api.model.questionnaire.v3.FuelPart;
import com.whut.cailiao.api.service.fuelPart.FuelPartService;
import com.whut.cailiao.war.dao.questionnaire.FuelPartDao;
import com.whut.cailiao.war.utils.redis.RedisSupport;
/**
 * FuelSerive的实现类
 * @author zr
 *
 */
public class FuelPartServiceImpl extends RedisSupport implements FuelPartService {
	@Autowired
	private FuelPartDao fuelPartDao;
	
	@Override
	public void deleteFuel(int id) {
		String key="FuelService20160303"+id;
		if(id<=0){
			return ;
		}
		this.fuelPartDao.deleteFuelPart(id);
		deleteTestData(key);

	}

	@Override
	public void saveFuelPart(FuelPart fuelPart) {
		if(fuelPart==null||fuelPart.getId()<=0){
			return;
		}
		Map<String,Object> map=new HashMap<>();
		map.put("fuelItemList", fuelPart.getFuelItemList());
		this.fuelPartDao.saveFuelPart(map);

	}

	@Override
	public void updateFuelPart(FuelPart fuelPart) {
		String key="FuelService20160303"+fuelPart.getId();
		if(fuelPart==null||fuelPart.getId()<=0){
			return;
		}
		Map<String,Object> map=new HashMap<>();
		map.put("fuelItemList", fuelPart.getFuelItemList());
		this.fuelPartDao.updateFuelPart(map);
		deleteTestData(key);

	}

	@Override
	public FuelPart findFuelPart(int id) {
		String key="FuelService20160303"+id;
		if(id<=0){
			return null;
		}
		FuelPart fuelPart=(FuelPart) getTestData(key);
		if(fuelPart==null){
			fuelPart=this.fuelPartDao.findFuelPart(id);
			setTestData(key,fuelPart);
		}
		return fuelPart;
	}

}

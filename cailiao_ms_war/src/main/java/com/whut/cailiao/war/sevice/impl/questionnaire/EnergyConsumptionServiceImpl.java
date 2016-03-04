package com.whut.cailiao.war.sevice.impl.questionnaire;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whut.cailiao.api.model.questionnaire.v3.EnergyConsumptionPart;
import com.whut.cailiao.api.service.energyConsumption.EnergyConsumptionService;
import com.whut.cailiao.war.dao.questionnaire.EnergyConsumptionPartDao;
import com.whut.cailiao.war.utils.redis.RedisSupport;

/**
 * 资源消耗service的实现
 * 
 * @author zr
 *
 */
@Service("energyConsumptionService")
public class EnergyConsumptionServiceImpl extends RedisSupport implements EnergyConsumptionService {
	@Autowired
	private EnergyConsumptionPartDao energyConsumptionDao;

	@Override
	public void detele(int id) {
		if (id <= 0) {
			return;
		}
		String key = "EnergyConsumption20160303" + id;
		this.energyConsumptionDao.deleteEnergyConsumptionPar(id);
		deleteTestData(key);

	}

	@Override
	public EnergyConsumptionPart find(int id) {
		if(id<=0){
			return null;
		}
		String key="EnergyConsumption20160303"+id;
		EnergyConsumptionPart consumptionPart=(EnergyConsumptionPart) getTestData(key);
		if(consumptionPart==null){
			consumptionPart=this.energyConsumptionDao.findEnergyConsumptionPar(id);
			setTestData(key,consumptionPart);
		}
		return consumptionPart;
	}

	
	@Override
	public void save(EnergyConsumptionPart consumptionPart) {
		Map<String, Object> map = new HashMap<>();
		map.put("coalConsumptionByKbsl", consumptionPart.getCoalConsumptionByKbsl());
		map.put("energyConsumptionByKbsl", consumptionPart.getEnergyConsumptionByKbsl());
		map.put("energyConsumptionByKbsn", consumptionPart.getEnergyConsumptionByKbsn());
		map.put("powerConsumptionByKbsl", consumptionPart.getPowerConsumptionByKbsl());
		map.put("powerConsumptionByKbsn", consumptionPart.getPowerConsumptionByKbsn());
		map.put("powerConsumptionBySlfm", consumptionPart.getPowerConsumptionBySlfm());
		map.put("powerGenerationUnit", consumptionPart.getPowerGenerationUnit());
		this.energyConsumptionDao.saveEnergyConsumptionPar(map);

	}

	@Override
	public void update(EnergyConsumptionPart consumptionPart) {
		if(consumptionPart==null||consumptionPart.getId()<=0){
			return ;
		}
		Map<String, Object> map = new HashMap<>();
		map.put("coalConsumptionByKbsl", consumptionPart.getCoalConsumptionByKbsl());
		map.put("energyConsumptionByKbsl", consumptionPart.getEnergyConsumptionByKbsl());
		map.put("energyConsumptionByKbsn", consumptionPart.getEnergyConsumptionByKbsn());
		map.put("powerConsumptionByKbsl", consumptionPart.getPowerConsumptionByKbsl());
		map.put("powerConsumptionByKbsn", consumptionPart.getPowerConsumptionByKbsn());
		map.put("powerConsumptionBySlfm", consumptionPart.getPowerConsumptionBySlfm());
		map.put("powerGenerationUnit", consumptionPart.getPowerGenerationUnit());
		this.energyConsumptionDao.updateEnergyConsumptionPar(map);
		String key="EnergyConsumption20160303"+consumptionPart.getId();
		deleteTestData(key);
	}

}

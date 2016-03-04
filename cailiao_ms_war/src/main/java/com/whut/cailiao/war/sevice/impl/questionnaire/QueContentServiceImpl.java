package com.whut.cailiao.war.sevice.impl.questionnaire;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whut.cailiao.api.model.questionnaire.v3.QueContent4V3;
import com.whut.cailiao.api.service.questionnaire.QueContent4V3Service;
import com.whut.cailiao.war.dao.questionnaire.QueContent4V3Dao;
import com.whut.cailiao.war.utils.redis.RedisSupport;
/**
 * QueCOntentService实现类
 * @author zr
 *
 */
@Service("queContentService")
public class QueContentServiceImpl extends RedisSupport implements QueContent4V3Service {
	@Autowired
	private QueContent4V3Dao queContentDao;
	@Override
	public void deleteQueContent4V3(int id) {
		String key="queContent4V320160304"+id;
		if(id<=0){
			return;
		}
		this.queContentDao.deleteQueContent4V3(id);
		deleteTestData(key);
	}

	@Override
	public void saveQueContent4V3(QueContent4V3 queContent) {
		if(queContent==null||queContent.getId()<=0){
			return;
		}
		Map<String,Object> map=new HashMap<>();
		map.put("cementStonePart",queContent.getCementStonePart());
		map.put("clinkerPart", queContent.getClinkerPart());
		map.put("energyConsumptionPart", queContent.getEnergyConsumptionPart());
		map.put("exhaustEmissionPart", queContent.getExhaustEmissionPart());
		map.put("fuelPart", queContent.getFuelPart());
		map.put("majorEquipmentPart", queContent.getMajorEquipmentPart());
		map.put("questionnaireId", queContent.getQuestionnaireId());
		map.put("tons", queContent.getTons());
		map.put("year", queContent.getYear());
		map.put("corName", queContent.getCorName());
		map.put("productionLine", queContent.getProductionLine());
		this.queContentDao.saveQueContent4V3(map);	
		

	}

	@Override
	public void updateQueContent4V3(QueContent4V3 queContent) {
		if(queContent==null||queContent.getId()<=0){
			return;
		}
		Map<String,Object> map=new HashMap<>();
		map.put("cementStonePart",queContent.getCementStonePart());
		map.put("clinkerPart", queContent.getClinkerPart());
		map.put("energyConsumptionPart", queContent.getEnergyConsumptionPart());
		map.put("exhaustEmissionPart", queContent.getExhaustEmissionPart());
		map.put("fuelPart", queContent.getFuelPart());
		map.put("majorEquipmentPart", queContent.getMajorEquipmentPart());
		map.put("questionnaireId", queContent.getQuestionnaireId());
		map.put("tons", queContent.getTons());
		map.put("year", queContent.getYear());
		map.put("corName", queContent.getCorName());
		map.put("productionLine", queContent.getProductionLine());
		
		String key="queContent4V320160304"+queContent.getId();
		deleteTestData(key);

	}

	@Override
	public QueContent4V3 findQueContent4V3(int id) {
		if(id<=0){
			return null;
		}
		String key="queContent4V320160304"+id;
		QueContent4V3 queContent=(QueContent4V3)getTestData(key);
		if(queContent==null){
			queContent=this.findQueContent4V3(id);
			setTestData(key,queContent);
		}
		return queContent;
	}

}

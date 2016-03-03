package com.whut.cailiao.war.sevice.impl.clinkerPart;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whut.cailiao.api.model.questionnaire.v3.ClinkerPart;
import com.whut.cailiao.api.service.clinkerPart.ClinkerPartBaseService;
import com.whut.cailiao.war.dao.clinkerPart.ClinkerPartDao;
import com.whut.cailiao.war.utils.redis.RedisSupport;

/**
 * 熟料service的实现
 * @author zr
 *
 */
@Service("ClinkerPartService")
public class ClinkerPartServiceimpl extends RedisSupport implements ClinkerPartBaseService {
	@Autowired
	private ClinkerPartDao clinkerPartDao;

	@Override
	public ClinkerPart findClikerPart(int id) {
		String key="ClinkerPart20160303"+id;
		ClinkerPart clinkerPart=(ClinkerPart) getTestData(key);
		if(clinkerPart==null){
			clinkerPart=this.clinkerPartDao.findClinkerPart(id);
			setTestData(key,clinkerPart);
		}
		return clinkerPart;
	}

	@Override
	public void deleteClinkerPart(int id) {
		if(id<=0){
			return ;
		}
		this.clinkerPartDao.deleteClinkerPart(id);
		String key="ClinkerPart20160303"+id;
		deleteTestData(key);
	}

	@Override
	public void updateClinkerPart(ClinkerPart clinkerPart) {
		if(clinkerPart==null||clinkerPart.getId()<=0){
			return ;
		}
		Map<String,Object> map=new HashMap<>();
		map.put("clinkerItemList", clinkerPart.getClinkerItemList());
		this.clinkerPartDao.updateClinkerPart(map);
		String key="ClinkerPart20160303"+clinkerPart.getId();
		deleteTestData(key);
		
	}

	@Override
	public void saveClinkerPart(ClinkerPart clinkerPart) {
		if(clinkerPart==null||clinkerPart.getId()<=0){
			return ;
			
		}
		Map<String,Object> map=new HashMap<>();
		map.put("clinkerItemList", clinkerPart.getClinkerItemList());
		this.clinkerPartDao.saveClinkerPart(map);
	}

	
}

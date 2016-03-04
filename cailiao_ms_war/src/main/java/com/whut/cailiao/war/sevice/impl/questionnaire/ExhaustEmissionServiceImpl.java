package com.whut.cailiao.war.sevice.impl.questionnaire;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whut.cailiao.api.model.questionnaire.v3.ExhaustEmissionPart;
import com.whut.cailiao.api.service.exhaustEmission.ExhaustEmissionService;
import com.whut.cailiao.war.dao.questionnaire.ExhaustEmissionPartDao;
import com.whut.cailiao.war.utils.redis.RedisSupport;
/**
 * service的实现类
 * @author zr
 *
 */
@Service("exhaustEmissionService")
public class ExhaustEmissionServiceImpl extends RedisSupport implements ExhaustEmissionService {
	@Autowired
	private ExhaustEmissionPartDao exhaustEmissionPartDao;
	@Override
	public void saveExhaustEmission(ExhaustEmissionPart exhaustEmissionpart) {
		if(exhaustEmissionpart==null||exhaustEmissionpart.getId()<=0){
			return ;
		}
		Map<String,Object> map=new HashMap<>();
		map.put("ammoniaJetting", exhaustEmissionpart.getAmmoniaJetting());
		map.put("exhaustEmissionItemList", exhaustEmissionpart.getExhaustEmissionItemList());
		map.put("isFractionalCombustion", exhaustEmissionpart.getIsFractionalCombustion());
		map.put("isOneAndTwo", exhaustEmissionpart.getIsOneAndTwo());
		map.put("isOther", exhaustEmissionpart.getIsOther());
		map.put("isSNCR", exhaustEmissionpart.getIsSNCR());
		this.exhaustEmissionPartDao.saveExhaustEmissionPart(map);
	}

	@Override
	public void deleteExhaustEmission(int id) {
		String key="ExhaustEmission"+id;
		if(id<=0){
			return;
		}
		this.exhaustEmissionPartDao.deleteExhaustEmissionPart(id);
		deleteTestData(key);
	}

	@Override
	public void updateExhaustEmission(ExhaustEmissionPart exhaustEmissionpart) {
		if(exhaustEmissionpart==null||exhaustEmissionpart.getId()<=0){
			return ;
		}
		Map<String,Object> map=new HashMap<>();
		map.put("ammoniaJetting", exhaustEmissionpart.getAmmoniaJetting());
		map.put("exhaustEmissionItemList", exhaustEmissionpart.getExhaustEmissionItemList());
		map.put("isFractionalCombustion", exhaustEmissionpart.getIsFractionalCombustion());
		map.put("isOneAndTwo", exhaustEmissionpart.getIsOneAndTwo());
		map.put("isOther", exhaustEmissionpart.getIsOther());
		map.put("isSNCR", exhaustEmissionpart.getIsSNCR());
		this.exhaustEmissionPartDao.updateExhaustEmissionPart(map);
		String key="ExhaustEmission"+exhaustEmissionpart.getId();
		deleteTestData(key);

	}

	@Override
	public ExhaustEmissionPart findExhaustEmission(int id) {
		if(id<=0){
			return null;
		}
		String key="ExhaustEmission"+id;
		ExhaustEmissionPart exhaustEmissionPart=(ExhaustEmissionPart) getTestData(key);
		if(exhaustEmissionPart==null){
			exhaustEmissionPart=this.exhaustEmissionPartDao.findExhaustEmissionPart(id);
			setTestData(key,exhaustEmissionPart);
		}
		return exhaustEmissionPart;
	}

}

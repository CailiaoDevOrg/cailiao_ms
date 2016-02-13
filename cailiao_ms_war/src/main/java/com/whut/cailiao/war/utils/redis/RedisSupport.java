package com.whut.cailiao.war.utils.redis;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * Created by niuyang on 16/2/1.
 */
@Component
public class RedisSupport {

    @SuppressWarnings("rawtypes")
	@Autowired
    private RedisTemplate redisTemplate;

    @SuppressWarnings("unchecked")
	public void setTestData(String key, Object obj) {
        if (StringUtils.isNotBlank(key)) {
            this.redisTemplate.opsForHash().put(RedisConstant.KEY_TEST_DATE, key, obj);
        }
    }


    @SuppressWarnings("unchecked")
	public Object getTestData(String key) {
        if (StringUtils.isBlank(key)) {
            return null;
        }
        return this.redisTemplate.opsForHash().get(RedisConstant.KEY_TEST_DATE, key);
    }

}

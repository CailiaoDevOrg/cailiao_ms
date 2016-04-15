package com.whut.cailiao.impl.utils.redis;

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
	public void setCacheData(String key, Object obj) {
        if (StringUtils.isNotBlank(key)) {
            this.redisTemplate.opsForHash().put(RedisConstant.KEY_DATAIL_DATA, key, obj);
        }
    }

    @SuppressWarnings("unchecked")
	public Object getCacheData(String key) {
        if (StringUtils.isBlank(key)) {
            return null;
        }
        return this.redisTemplate.opsForHash().get(RedisConstant.KEY_DATAIL_DATA, key);
    }
    
    @SuppressWarnings("unchecked")
    public void deleteCacheData(String key) {
        if (StringUtils.isNotBlank(key)) {
            this.redisTemplate.opsForHash().delete(RedisConstant.KEY_DATAIL_DATA, key);
        }
    }

}

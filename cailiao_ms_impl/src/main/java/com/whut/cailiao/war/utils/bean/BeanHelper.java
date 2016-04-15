package com.whut.cailiao.war.utils.bean;

import org.apache.commons.lang3.ArrayUtils;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by gammaniu on 16/4/15.
 */
public final class BeanHelper {

    public static Map<String, Object> convertObjToMap(Object obj) {
        if (obj == null) {
            return Collections.emptyMap();
        }
        Map<String, Object> ret = new HashMap<>();
        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();
        if (ArrayUtils.isEmpty(fields)) {
            return Collections.emptyMap();
        }
        for (Field field : fields) {
            if ("serialVersionUID".equals(field.getName())) {
                continue;
            }
            try {
                field.setAccessible(true);
                ret.put(field.getName(), field.get(obj));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                return Collections.emptyMap();
            }
        }
        return ret;
    }
}

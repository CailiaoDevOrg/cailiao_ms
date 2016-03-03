package com.whut.cailiao.api.commons;

import com.alibaba.fastjson.JSON;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by niuyang on 16/3/3.
 * 用于controller的返回
 */
public class WebResponse {

    // 返回码
    private int retCode;
    // 返回描述
    private String retDesc;
    // 返回内容
    private Map<String, Object> body;

    public WebResponse() {
        this.retCode = WebResponseCode.SUCCESS;
        this.retDesc = WebResponseCode.getDesc(retCode);
    }

    public void setRetCode(int retCode) {
        this.retCode = retCode;
    }

    public void setRetDesc(String retDesc) {
        this.retDesc = retDesc;
    }

    public void setBody(String key, Object object) {
        if (StringUtils.isBlank(key) || object == null) {
            return;
        }
        if (MapUtils.isEmpty(body)) {
            body = new HashMap<>();
        }
        body.put(key, object);
    }

    public String toJsonString() {
        return JSON.toJSONString(this);
    }
}

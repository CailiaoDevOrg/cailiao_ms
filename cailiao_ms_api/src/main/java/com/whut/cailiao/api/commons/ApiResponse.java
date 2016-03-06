package com.whut.cailiao.api.commons;

import com.alibaba.fastjson.JSON;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by niuyang on 16/3/3.
 * 用于controller的返回
 */
public class ApiResponse implements Serializable {

    // 返回码
    private int retCode;
    // 返回描述
    private String retDesc;
    // 返回内容
    private Map<String, Object> body;

    private ApiResponse() {

    }

    public void setRetCode(int retCode) {
        this.retCode = retCode;
        this.retDesc = ApiResponseCode.getDesc(retCode);
    }

    public int getRetCode() {
        return retCode;
    }

    public void addBody(String key, Object object) {
        if (StringUtils.isBlank(key) || object == null) {
            return;
        }
        if (MapUtils.isEmpty(body)) {
            body = new HashMap<>();
        }
        body.put(key, object);
    }

    public static ApiResponse createCallErrorApiResponse() {
        ApiResponse response = new ApiResponse();
        response.setRetCode(ApiResponseCode.CALL_ERROR);
        return response;
    }

    public static ApiResponse createDefaultApiResponse() {
        ApiResponse response = new ApiResponse();
        response.setRetCode(ApiResponseCode.SUCCESS);
        return response;
    }

}

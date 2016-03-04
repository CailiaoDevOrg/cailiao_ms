package com.whut.cailiao.api.commons;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by niuyang on 16/3/3.
 */
public class WebResponseCode {

    public static final int UNKNOWN = -1; // 未知的状态
    public static final int SUCCESS = 200; // 处理成功


    private static final Map<Integer, String> CodeMap = new HashMap<>();

    static {
        CodeMap.put(WebResponseCode.SUCCESS, "处理成功");
        CodeMap.put(WebResponseCode.UNKNOWN, "未知状态");
    }

    public static String getDesc(int code) {
        if (CodeMap.containsKey(code)) {
            return CodeMap.get(code);
        }
        return CodeMap.get(WebResponseCode.UNKNOWN);
    }

}

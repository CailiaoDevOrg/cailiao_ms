package com.whut.cailiao.ms.api.commons;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by niuyang on 16/3/3.
 */
public class ApiResponseCode {

    public static final int UNKNOWN = -1; // 未知的状态
    public static final int SUCCESS = 200; // 处理成功
    public static final int PARAM_ERROR = 201; // 参数错误
    public static final int CALL_ERROR = 202; // 调用错误
    public static final int SQL_EXCEPTION = 203; // sql执行异常
    public static final int CONCURRENT_CONFLICT = 204; // 并发执行冲突
    public static final int EDIT_LOCKED = 205; // 编辑状态被锁定
    public static final int IO_EXCEPTION = 206; // io异常
    public static final int CHECKCODE_ERROR = 207; // 验证码输入错误


    private static final Map<Integer, String> CodeMap = new HashMap<>();

    static {
        CodeMap.put(ApiResponseCode.SUCCESS, "处理成功");
        CodeMap.put(ApiResponseCode.UNKNOWN, "未知状态");
        CodeMap.put(ApiResponseCode.PARAM_ERROR, "参数错误");
        CodeMap.put(ApiResponseCode.CALL_ERROR, "调用错误");
        CodeMap.put(ApiResponseCode.SQL_EXCEPTION, "sql执行异常");
        CodeMap.put(ApiResponseCode.CONCURRENT_CONFLICT, "并发冲突");
        CodeMap.put(ApiResponseCode.EDIT_LOCKED, "编辑状态锁定");
        CodeMap.put(ApiResponseCode.IO_EXCEPTION, "IO异常");
        CodeMap.put(ApiResponseCode.CHECKCODE_ERROR, "验证码输入错误");
    }

    public static String getDesc(int code) {
        if (CodeMap.containsKey(code)) {
            return CodeMap.get(code);
        }
        return CodeMap.get(ApiResponseCode.UNKNOWN);
    }

}

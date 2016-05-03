package com.whut.cailiao.ms.impl.web;

import com.alibaba.fastjson.JSON;
import com.whut.cailiao.ms.api.commons.ApiResponse;
import com.whut.cailiao.ms.api.model.user.User;
import com.whut.cailiao.ms.impl.utils.http.HttpUtil;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpSession;

/**
 * Created by niuyang on 16/3/6.
 */
public class BaseController {

    /**
     * 对ApiResponse的返回值序列化,转换成json格式
     * @param response
     * @return
     */
    protected String convertApiResponseToJSONString(ApiResponse response) {
        response = (response == null ? ApiResponse.createCallErrorApiResponse() : response);
        return JSON.toJSONString(response);
    }

    /**
     * 获取当前用户信息
     * 该方法需要修改,要修改成没有参数的形式
     * @return
     */
    protected User getUserInfo() {
        HttpSession session = HttpUtil.getSession();
        if (session == null) {
            return null;
        }
        return (User) session.getAttribute("user");
    }

    /**
     * 获取用户名
     * @return
     */
    protected String getAccountId() {
        User user = getUserInfo();
        if (user == null) {
            return StringUtils.EMPTY;
        }
        return user.getAccountId();
    }

}

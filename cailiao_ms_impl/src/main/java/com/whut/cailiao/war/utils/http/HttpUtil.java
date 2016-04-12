package com.whut.cailiao.war.utils.http;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by niuyang on 16/3/6.
 */
public class HttpUtil {

    private static final ThreadLocal<HttpServletRequest> requestThreadLocal = new ThreadLocal<>();

    public static void addRequest(HttpServletRequest request) {
        if (request != null) {
            requestThreadLocal.set(request);
        }
    }

    public static HttpServletRequest getRequest() {
        return requestThreadLocal.get();
    }

    public static HttpSession getSession() {
        HttpServletRequest request = getRequest();
        HttpSession session = null;
        if (request != null) {
            session = request.getSession();
        }
        return session;
    }
}

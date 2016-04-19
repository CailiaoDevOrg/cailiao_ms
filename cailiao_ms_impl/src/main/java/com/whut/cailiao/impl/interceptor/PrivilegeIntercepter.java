package com.whut.cailiao.impl.interceptor;

import com.whut.cailiao.api.constant.UserConstant;
import com.whut.cailiao.api.model.user.Privilege;
import com.whut.cailiao.api.model.user.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by gammaniu on 16/4/19.
 */
public class PrivilegeIntercepter implements HandlerInterceptor {

    private Map<Privilege, Integer> map = new HashMap<>();

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        HttpSession session = httpServletRequest.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null || user.getStatus() != UserConstant.Status.ACTIVE.value()) {
            return false;
        }

        Privilege privilege = new Privilege();
        privilege.setUrl(httpServletRequest.getRequestURI());
        privilege.setMethod(httpServletRequest.getMethod());

        if (!map.containsKey(privilege) || !user.getPrivilegeIds().contains(map.get(privilege))) {
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}

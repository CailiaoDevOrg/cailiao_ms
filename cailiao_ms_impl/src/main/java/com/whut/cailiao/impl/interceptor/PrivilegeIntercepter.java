package com.whut.cailiao.impl.interceptor;

import com.whut.cailiao.api.constant.UserConstant;
import com.whut.cailiao.api.model.privilege.Privilege;
import com.whut.cailiao.api.model.user.User;
import com.whut.cailiao.impl.helper.PrivilegeHelper;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created by gammaniu on 16/4/19.
 */
public class PrivilegeIntercepter implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        HttpSession session = httpServletRequest.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null || user.getStatus() != UserConstant.Status.ACTIVE.value()) {
            return false;
        }

        Map<Privilege, Integer> map = PrivilegeHelper.getPrivilegeMap();

        Privilege privilege = new Privilege(httpServletRequest.getRequestURI().substring(httpServletRequest.getContextPath().length()), httpServletRequest.getMethod());
        System.out.println("privilege = " + privilege);

        if (CollectionUtils.isEmpty(user.getPrivilegeIds())) {
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/privilege/low.html");
        	return false;
        }

        if (MapUtils.isNotEmpty(map) && map.containsKey(privilege) && !user.getPrivilegeIds().contains(map.get(privilege))) {
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/privilege/low.html");
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

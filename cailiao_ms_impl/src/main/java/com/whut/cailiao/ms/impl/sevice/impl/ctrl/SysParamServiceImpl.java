package com.whut.cailiao.ms.impl.sevice.impl.ctrl;

import com.whut.cailiao.ms.api.commons.ApiResponse;
import com.whut.cailiao.ms.api.service.ctrl.SysParamService;
import com.whut.cailiao.ms.impl.dao.privilege.PrivilegeDao;
import com.whut.cailiao.ms.impl.helper.PrivilegeHelper;
import com.whut.cailiao.ms.impl.utils.http.HttpUtil;
import org.apache.catalina.Context;
import org.apache.catalina.Manager;
import org.apache.catalina.Session;
import org.apache.catalina.connector.Request;
import org.apache.catalina.connector.RequestFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Field;

/**
 * Created by gammaniu on 16/4/22.
 */
@Service("sysParamService")
public class SysParamServiceImpl implements SysParamService {

    @Autowired
    private PrivilegeDao privilegeDao;

    @Override
    public ApiResponse refreshACL() {
        ApiResponse response = ApiResponse.createDefaultApiResponse();
        PrivilegeHelper.setPrivilegeMap(this.privilegeDao.getPrivilegeList());
        return response;
    }

    @Override
    public ApiResponse signOutAll() {
        ApiResponse response = ApiResponse.createDefaultApiResponse();
        HttpServletRequest request = HttpUtil.getRequest();
        HttpSession httpSession = HttpUtil.getSession();
        if (request instanceof RequestFacade) {
            Field requestField = null;
            try {
                requestField = request.getClass().getDeclaredField("request");
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
            if (requestField != null) {
                requestField.setAccessible(true);
                Request req = null;
                try {
                    req = (Request) requestField.get(request);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                if (req != null) {
                    Context context = req.getContext();
                    Manager manager = context.getManager();
                    Session[] sessions = manager.findSessions();
                    if (sessions != null) {
                        for (Session session : sessions) {
                            if (!httpSession.getId().equals(session.getId())) {
                                session.expire();
                            }
                        }
                    }
                }
            }
        }
        return response;
    }
}

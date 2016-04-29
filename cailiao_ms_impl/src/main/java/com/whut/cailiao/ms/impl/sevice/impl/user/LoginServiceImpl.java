package com.whut.cailiao.ms.impl.sevice.impl.user;

import com.whut.cailiao.ms.api.commons.ApiResponse;
import com.whut.cailiao.ms.api.commons.ApiResponseCode;
import com.whut.cailiao.ms.api.constant.UserConstant;
import com.whut.cailiao.ms.api.model.user.User;
import com.whut.cailiao.ms.api.service.user.LoginService;
import com.whut.cailiao.ms.api.service.privilege.RoleService;
import com.whut.cailiao.ms.api.service.user.UserService;
import com.whut.cailiao.ms.impl.dao.privilege.PrivilegeDao;
import com.whut.cailiao.ms.impl.dao.user.UserDao;
import com.whut.cailiao.ms.impl.helper.PrivilegeHelper;
import com.whut.cailiao.ms.impl.utils.http.HttpUtil;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Set;

/**
 * Created by gammaniu on 16/4/18.
 */
@Service("loginService")
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PrivilegeDao privilegeDao;

    @Override
    public ApiResponse login(User user, String checkcode) {
        loadPrivilegeMap();
        ApiResponse response = ApiResponse.createDefaultApiResponse();
        if (user == null || StringUtils.isBlank(user.getAccountId()) || StringUtils.isBlank(user.getPassword()) || StringUtils.isBlank(checkcode)) {
            response.setRetCode(ApiResponseCode.PARAM_ERROR);
            return response;
        }
        HttpSession session = HttpUtil.getSession();
        if (!((String) session.getAttribute("rand")).equalsIgnoreCase(checkcode)) {
            response.setRetCode(ApiResponseCode.CHECKCODE_ERROR);
            return response;
        }
        User userInDB = this.userDao.getUserByAccount(user.getAccountId());
        if (userInDB == null) {
            response.addBody("canLogin", false);
        } else {
            if (userInDB.getStatus() == UserConstant.Status.ACTIVE.value() && user.getPassword().equals(userInDB.getPassword())) {
                response.addBody("canLogin", true);
                loadUserInfo(userInDB, session);
            } else {
                response.addBody("canLogin", false);
            }
        }
        return response;
    }

    private void loadUserInfo(User user, HttpSession session) {
        // 加载用户权限
        ApiResponse response = this.userService.getRoleIdsByAccount(user.getAccountId());
        if (response.getRetCode() == ApiResponseCode.SUCCESS) {
            Set<Integer> roleIds = (Set<Integer>) response.getData("roleIds");
            response = this.roleService.getPrivilegeIdsByRoleId(roleIds);
            if (response.getRetCode() == ApiResponseCode.SUCCESS) {
                Set<Integer> privilegeIds = (Set<Integer>) response.getData("privilegeIds");
                user.setPrivilegeIds(privilegeIds);
            }
        }
        // 保存在session当中
        session.setAttribute("user", user);
    }

    private void loadPrivilegeMap() {
        if (MapUtils.isEmpty(PrivilegeHelper.getPrivilegeMap())) {
            PrivilegeHelper.setPrivilegeMap(this.privilegeDao.getPrivilegeList());
        }
    }

}

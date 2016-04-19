package com.whut.cailiao.impl.sevice.impl.user;

import com.whut.cailiao.api.commons.ApiResponse;
import com.whut.cailiao.api.commons.ApiResponseCode;
import com.whut.cailiao.api.constant.UserConstant;
import com.whut.cailiao.api.model.user.Privilege;
import com.whut.cailiao.api.model.user.Role;
import com.whut.cailiao.api.model.user.User;
import com.whut.cailiao.api.service.user.LoginService;
import com.whut.cailiao.api.service.user.RoleService;
import com.whut.cailiao.api.service.user.UserService;
import com.whut.cailiao.impl.dao.user.UserDao;
import com.whut.cailiao.impl.utils.http.HttpUtil;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Set;
import java.util.stream.Collectors;

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

    @Override
    public ApiResponse login(User user, String checkcode) {
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
        Set<Role> roles = this.userService.getRolesByAccount(user.getAccountId());
        Set<Privilege> privileges = this.roleService.getPrivilegesByRoleId(roles);
        if (CollectionUtils.isNotEmpty(privileges)) {
            Set<Integer> privilegeIds = privileges.stream().map(Privilege::getId).collect(Collectors.toSet());
            user.setPrivilegeIds(privilegeIds);
        }
        // 保存在session当中
        session.setAttribute("user", user);
    }

}

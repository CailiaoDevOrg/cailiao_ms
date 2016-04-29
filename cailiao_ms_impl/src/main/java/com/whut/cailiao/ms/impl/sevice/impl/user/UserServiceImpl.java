package com.whut.cailiao.ms.impl.sevice.impl.user;

import com.whut.cailiao.ms.api.commons.ApiResponse;
import com.whut.cailiao.ms.api.commons.ApiResponseCode;
import com.whut.cailiao.ms.api.constant.UserConstant;
import com.whut.cailiao.ms.api.model.privilege.Role;
import com.whut.cailiao.ms.api.model.privilege.UserEditData;
import com.whut.cailiao.ms.api.model.privilege.UserRole;
import com.whut.cailiao.ms.api.model.user.User;
import com.whut.cailiao.ms.api.service.user.UserService;
import com.whut.cailiao.ms.impl.dao.privilege.RoleDao;
import com.whut.cailiao.ms.impl.dao.privilege.UserRoleDao;
import com.whut.cailiao.ms.impl.dao.user.UserDao;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by gammaniu on 16/4/18.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserRoleDao userRoleDao;

    @Autowired
    private RoleDao roleDao;

    @Override
    public ApiResponse getRoleIdsByAccount(String accountId) {
        ApiResponse response = ApiResponse.createDefaultApiResponse();
        if (StringUtils.isBlank(accountId)) {
            response.setRetCode(ApiResponseCode.PARAM_ERROR);
            return response;
        }
        List<UserRole> userRoleList = this.userRoleDao.getUserRoleMapEntryByAccountId(accountId);
        Set<Integer> roleIds = new HashSet<>();
        if (CollectionUtils.isNotEmpty(userRoleList)) {
            roleIds.addAll(userRoleList.stream().map(UserRole::getRoleId).collect(Collectors.toList()));
        }
        response.addBody("roleIds", roleIds);
        return response;
    }

    @Override
    public ApiResponse getUserList(int factoryId) {
        ApiResponse response = ApiResponse.createDefaultApiResponse();
        if (factoryId < -1) {
            response.setRetCode(ApiResponseCode.PARAM_ERROR);
            return response;
        }
        if (factoryId == -1) {
        	response.addBody("userList", this.userDao.getAllUserList());
        } else {
        	response.addBody("userList", this.userDao.getUserList(factoryId));
        }
        return response;
    }

    @Transactional
    @Override
    public ApiResponse deleteUserByAccountId(String accountId) {
        ApiResponse response = ApiResponse.createDefaultApiResponse();
        if (StringUtils.isBlank(accountId)) {
            response.setRetCode(ApiResponseCode.PARAM_ERROR);
            return response;
        }
        this.userDao.deleteUserByAccountId(accountId);
        this.userRoleDao.deleteEntryByAccountId(accountId);
        return response;
    }

    @Transactional
    @Override
    public ApiResponse createNewUser(User user) {
        ApiResponse response = ApiResponse.createDefaultApiResponse();
        if (validateUserBean(user, true)) {
        	user.setRegisterTime(new Timestamp(System.currentTimeMillis()));
            this.userDao.createNewUser(user);
            buildUserRoleRelation(user);
        } else {
            response.setRetCode(ApiResponseCode.PARAM_ERROR);
        }
        return response;
    }

    private void buildUserRoleRelation(User user) {
        if (validateUserBean(user, false)) {
            Set<Integer> roleIds = user.getRoleIds();
            if (CollectionUtils.isNotEmpty(roleIds)) {
                for (Integer roleId : roleIds) {
                    this.userRoleDao.createUserRoleMapEntry(new UserRole(user.getAccountId(), roleId));
                }
            }
        }
    }

    @Transactional
    @Override
    public ApiResponse updateUser(User user) {
        ApiResponse response = ApiResponse.createDefaultApiResponse();
        if (validateUserBean(user, false)) {
            // 更新用户基本信息
            this.userDao.updateUser(user);
            // 删除用户的角色信息
            this.userRoleDao.deleteEntryByAccountId(user.getAccountId());
            // 添加用户的新的角色信息
            buildUserRoleRelation(user);
        } else {
            response.setRetCode(ApiResponseCode.PARAM_ERROR);
        }
        return response;
    }

    @Override
    public ApiResponse getUserByAccountId(String accountId) {
        ApiResponse response = ApiResponse.createDefaultApiResponse();
        if (StringUtils.isBlank(accountId)) {
            response.setRetCode(ApiResponseCode.PARAM_ERROR);
            return response;
        }
        response.addBody("user", this.userDao.getUserByAccount(accountId));
        return response;
    }

    @Override
    public ApiResponse getUserEditData(String accountId) {
        ApiResponse response = ApiResponse.createDefaultApiResponse();
        if (StringUtils.isBlank(accountId)) {
            response.setRetCode(ApiResponseCode.PARAM_ERROR);
            return response;
        }
        User user = this.userDao.getUserByAccount(accountId);
        user.setPassword("***");
        List<UserRole> userRoleMapEntryList = this.userRoleDao.getUserRoleMapEntryByAccountId(accountId);
        if (CollectionUtils.isNotEmpty(userRoleMapEntryList)) {
            Set<Integer> roleIds = userRoleMapEntryList.stream().map(UserRole::getRoleId).collect(Collectors.toSet());
            user.setRoleIds(roleIds);
        }
        List<Role> roles = this.roleDao.selectAllRole();
        UserEditData userEditData = new UserEditData(user, roles);
        response.addBody("userEditData", userEditData);
        return response;
    }

    private boolean validateUserBean(User user, boolean isCreate) {
        if (user == null
                || StringUtils.isBlank(user.getAccountId())
                || user.getStatus() < UserConstant.Status.ACTIVE.value()
                || user.getStatus() > UserConstant.Status.DISABLED.value()) {
            return false;
        }
        if (isCreate && (user.getFactoryId() == null || user.getFactoryId() < -1
                    || StringUtils.isBlank(user.getEmail())
                    || StringUtils.isBlank(user.getPassword()))) {
                return false;
        }
        return true;

    }

	@Override
	public ApiResponse updateUserStatus(User user) {
		ApiResponse response = ApiResponse.createDefaultApiResponse();
		if (user == null || StringUtils.isBlank(user.getAccountId()) 
				|| user.getStatus() < UserConstant.Status.ACTIVE.value()
				|| user.getStatus() > UserConstant.Status.DISABLED.value()) {
			response.setRetCode(ApiResponseCode.PARAM_ERROR);
            return response;
		}
		this.userDao.updateUserStatus(user);
		return response;
	}
}

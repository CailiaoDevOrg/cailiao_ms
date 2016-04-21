package com.whut.cailiao.impl.sevice.impl.user;

import com.whut.cailiao.api.commons.ApiResponse;
import com.whut.cailiao.api.commons.ApiResponseCode;
import com.whut.cailiao.api.constant.UserConstant;
import com.whut.cailiao.api.model.privilege.Role;
import com.whut.cailiao.api.model.user.User;
import com.whut.cailiao.api.service.user.UserService;
import com.whut.cailiao.impl.dao.user.UserDao;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Set;

/**
 * Created by gammaniu on 16/4/18.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public Set<Role> getRolesByAccount(String accountId) {
        return null;
    }

    @Override
    public ApiResponse getUserList(int factoryId) {
        ApiResponse response = ApiResponse.createDefaultApiResponse();
        if (factoryId < -1) {
            response.setRetCode(ApiResponseCode.PARAM_ERROR);
            return response;
        }
        response.addBody("userList", this.userDao.getUserList(factoryId));
        return response;
    }

    @Override
    public ApiResponse deleteUserByAccountId(String accountId) {
        ApiResponse response = ApiResponse.createDefaultApiResponse();
        if (StringUtils.isBlank(accountId)) {
            response.setRetCode(ApiResponseCode.PARAM_ERROR);
            return response;
        }
        this.userDao.deleteUserByAccountId(accountId);
        return response;
    }

    @Override
    public ApiResponse createNewUser(User user) {
        ApiResponse response = ApiResponse.createDefaultApiResponse();
        if (validateUserBean(user, true)) {
        	user.setRegisterTime(new Timestamp(System.currentTimeMillis()));
            this.userDao.createNewUser(user);
        } else {
            response.setRetCode(ApiResponseCode.PARAM_ERROR);
        }
        return response;
    }

    @Override
    public ApiResponse updateUser(User user) {
        ApiResponse response = ApiResponse.createDefaultApiResponse();
        if (validateUserBean(user, false)) {
            this.userDao.updateUser(user);
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


}

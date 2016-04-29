package com.whut.cailiao.ms.api.service.user;

import com.whut.cailiao.ms.api.commons.ApiResponse;
import com.whut.cailiao.ms.api.model.user.User;

/**
 * Created by gammaniu on 16/4/18.
 */
public interface UserService {

    ApiResponse getRoleIdsByAccount(String accountId);
    
    ApiResponse getUserList(int factoryId);

    ApiResponse deleteUserByAccountId(String accountId);

    ApiResponse createNewUser(User user);

    ApiResponse updateUser(User user);

    ApiResponse getUserByAccountId(String accountId);

    ApiResponse getUserEditData(String accountId);
    
    ApiResponse updateUserStatus(User user);

}

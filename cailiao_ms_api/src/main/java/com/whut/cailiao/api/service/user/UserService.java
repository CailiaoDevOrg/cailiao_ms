package com.whut.cailiao.api.service.user;

import com.whut.cailiao.api.model.user.Role;

import java.util.Set;

/**
 * Created by gammaniu on 16/4/18.
 */
public interface UserService {

    Set<Role> getRolesByAccount(String accountId);
}

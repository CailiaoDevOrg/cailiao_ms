package com.whut.cailiao.impl.sevice.impl.user;

import com.whut.cailiao.api.model.user.Role;
import com.whut.cailiao.api.service.user.UserService;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by gammaniu on 16/4/18.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Override
    public Set<Role> getRolesByAccount(String accountId) {
        return null;
    }
}

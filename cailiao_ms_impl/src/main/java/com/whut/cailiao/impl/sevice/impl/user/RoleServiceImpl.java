package com.whut.cailiao.impl.sevice.impl.user;

import com.whut.cailiao.api.model.user.Privilege;
import com.whut.cailiao.api.model.user.Role;
import com.whut.cailiao.api.service.user.RoleService;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by gammaniu on 16/4/18.
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService {

    @Override
    public Set<Privilege> getPrivilegesByRoleId(Set<Role> roles) {
        return null;
    }
}

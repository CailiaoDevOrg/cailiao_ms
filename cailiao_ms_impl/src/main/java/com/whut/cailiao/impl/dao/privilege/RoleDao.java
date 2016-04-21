package com.whut.cailiao.impl.dao.privilege;

import com.whut.cailiao.api.model.user.Role;

/**
 * Created by gammaniu on 16/4/21.
 */
public interface RoleDao {

    void createNewRole(Role role);

    Role selectRoleByName(String name);

}

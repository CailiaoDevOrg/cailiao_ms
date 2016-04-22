package com.whut.cailiao.impl.dao.privilege;

import com.whut.cailiao.api.model.privilege.Role;

import java.util.List;

/**
 * Created by gammaniu on 16/4/21.
 */
public interface RoleDao {

    void createNewRole(Role role);

    Role selectRoleByName(String name);

    List<Role> selectAllRole();

    void deleteById(int id);

    Role selectRoleById(int id);

    void updateRole(Role role);

}
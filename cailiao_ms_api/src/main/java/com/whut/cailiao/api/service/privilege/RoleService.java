package com.whut.cailiao.api.service.privilege;

import com.whut.cailiao.api.commons.ApiResponse;
import com.whut.cailiao.api.model.privilege.Privilege;
import com.whut.cailiao.api.model.privilege.Role;

import java.util.Set;

/**
 * Created by gammaniu on 16/4/18.
 */
public interface RoleService {

    Set<Privilege> getPrivilegesByRoleId(Set<Role> roles);

    ApiResponse createNewRole(Role role);

    ApiResponse getRoleList();

    ApiResponse deleteRoleById(int id);

    ApiResponse getRoleEditData(int id);

    ApiResponse updateRole(Role role);
}

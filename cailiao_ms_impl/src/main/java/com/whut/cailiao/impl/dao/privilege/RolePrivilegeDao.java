package com.whut.cailiao.impl.dao.privilege;

import com.whut.cailiao.api.model.privilege.RolePrivilege;

import java.util.List;

/**
 * Created by gammaniu on 16/4/21.
 */
public interface RolePrivilegeDao {

    void createNewRolePrivilegeMapEntry(RolePrivilege rolePrivilege);

    void deleteByRoleId(int roleId);

    List<RolePrivilege> getRolePrivilegeMapEntryListByRoleId(int roleId);

}

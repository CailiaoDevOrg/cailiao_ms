package com.whut.cailiao.ms.api.model.privilege;

import java.io.Serializable;
import java.util.List;

/**
 * Created by gammaniu on 16/4/21.
 */
public class RoleEditData implements Serializable {

    private Role role;

    private List<Privilege> privilegeList;

    public RoleEditData() {
    }

    public RoleEditData(Role role, List<Privilege> privilegeList) {
        this.role = role;
        this.privilegeList = privilegeList;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<Privilege> getPrivilegeList() {
        return privilegeList;
    }

    public void setPrivilegeList(List<Privilege> privilegeList) {
        this.privilegeList = privilegeList;
    }
}

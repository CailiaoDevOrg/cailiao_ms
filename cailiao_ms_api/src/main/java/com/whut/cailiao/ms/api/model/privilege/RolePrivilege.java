package com.whut.cailiao.ms.api.model.privilege;

import java.io.Serializable;

/**
 * Created by gammaniu on 16/4/21.
 */
public class RolePrivilege implements Serializable {
	
	private static final long serialVersionUID = 1L;

    private Integer id;

    private int roleId;
    private int privilegeId;

    public RolePrivilege() {
    }

    public RolePrivilege(int roleId, int privilegeId) {
        this.roleId = roleId;
        this.privilegeId = privilegeId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getPrivilegeId() {
        return privilegeId;
    }

    public void setPrivilegeId(int privilegeId) {
        this.privilegeId = privilegeId;
    }
}

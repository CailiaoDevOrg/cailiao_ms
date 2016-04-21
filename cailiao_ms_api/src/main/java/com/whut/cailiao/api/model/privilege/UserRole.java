package com.whut.cailiao.api.model.privilege;

/**
 * Created by gammaniu on 16/4/21.
 */
public class UserRole {

    private Integer id;

    private String accountId;
    private int roleId;

    public UserRole() {
    }

    public UserRole(String accountId, int roleId) {
        this.accountId = accountId;
        this.roleId = roleId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }
}

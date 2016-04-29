package com.whut.cailiao.ms.api.model.privilege;

import com.whut.cailiao.ms.api.model.user.User;

import java.io.Serializable;
import java.util.List;

/**
 * Created by gammaniu on 16/4/22.
 */
public class UserEditData implements Serializable {

    private User user;

    private List<Role> roleList;

    public UserEditData() {
    }

    public UserEditData(User user, List<Role> roleList) {
        this.user = user;
        this.roleList = roleList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }
}

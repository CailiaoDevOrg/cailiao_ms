package com.whut.cailiao.api.model.user;

import java.io.Serializable;
import java.util.Set;

/**
 * Created by gammaniu on 16/4/18.
 */
public class Role implements Serializable {

    private Integer id;

    private String name;
    private String description;

    private Set<Privilege> privileges;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Privilege> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(Set<Privilege> privileges) {
        this.privileges = privileges;
    }

}

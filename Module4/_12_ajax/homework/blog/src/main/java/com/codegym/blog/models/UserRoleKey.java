package com.codegym.blog.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class UserRoleKey implements Serializable {
    @Column(name = "username")
    String username;

    @Column(name = "role_id")
    int roleId;

    public UserRoleKey() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int id) {
        this.roleId = id;
    }
}

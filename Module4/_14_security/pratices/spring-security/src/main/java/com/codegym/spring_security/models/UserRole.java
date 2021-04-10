package com.codegym.spring_security.models;

import javax.persistence.*;

@Entity
public class UserRole {
    @EmbeddedId
    private UserRoleKey id;

    @ManyToOne
    @MapsId("username")
    @JoinColumn(name = "username")
    private AppUser user;

    @ManyToOne
    @MapsId("roleId")
    @JoinColumn(name = "role_id")
    private AppRole role;

    public UserRole() {
    }

    public UserRoleKey getId() {
        return id;
    }

    public void setId(UserRoleKey id) {
        this.id = id;
    }

    public AppUser getUser() {
        return user;
    }

    public void setUser(AppUser user) {
        this.user = user;
    }

    public AppRole getRole() {
        return role;
    }

    public void setRole(AppRole role) {
        this.role = role;
    }
}

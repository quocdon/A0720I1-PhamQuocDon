package com.codegym.furama_resort.models;

import javax.persistence.*;

@Entity
@Table(name = "user_role")
public class UserRole {
    @EmbeddedId
    private UserRoleKey id;

    @ManyToOne
    @MapsId("username")
    @JoinColumn(name = "username")
    private AppUser appUser;

    @ManyToOne
    @MapsId("roleId")
    @JoinColumn(name = "role_id")
    private AppRole appRole;

    public UserRole() {
    }

    public UserRoleKey getId() {
        return id;
    }

    public void setId(UserRoleKey id) {
        this.id = id;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

    public AppRole getAppRole() {
        return appRole;
    }

    public void setAppRole(AppRole appRole) {
        this.appRole = appRole;
    }
}

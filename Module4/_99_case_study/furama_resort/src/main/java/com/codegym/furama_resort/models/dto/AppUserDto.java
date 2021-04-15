package com.codegym.furama_resort.models.dto;

import com.codegym.furama_resort.models.AppRole;
import com.codegym.furama_resort.models.AppUser;

import java.util.Set;

public class AppUserDto {
    private AppUser appUser;
    private Set<AppRole> roles;

    public AppUserDto() {
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

    public Set<AppRole> getRoles() {
        return roles;
    }

    public void setRoles(Set<AppRole> roles) {
        this.roles = roles;
    }
}

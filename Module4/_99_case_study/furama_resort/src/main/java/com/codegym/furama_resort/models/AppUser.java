package com.codegym.furama_resort.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
public class AppUser {
    @Id
    @NotBlank (message = "Không để trống")
    private String username;
    @NotBlank (message = "Không để trống")
    private String password;

    @OneToOne(mappedBy = "appUser")
    private Employee employee;

    @OneToMany(mappedBy = "appUser", cascade = CascadeType.ALL)
    Set<UserRole> userRoles;

    public AppUser() {
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<UserRole> userRoles) {
        this.userRoles = userRoles;
    }

}

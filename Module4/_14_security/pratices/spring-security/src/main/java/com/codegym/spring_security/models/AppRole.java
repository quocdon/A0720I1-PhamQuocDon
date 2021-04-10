package com.codegym.spring_security.models;

import lombok.Data;
import org.apache.catalina.User;

import javax.management.relation.Role;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "role")
public class AppRole {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String roleName;

    @OneToMany(mappedBy = "role")
    private List<UserRole> userRoles;

    public AppRole() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(List<UserRole> userRoles) {
        this.userRoles = userRoles;
    }
}

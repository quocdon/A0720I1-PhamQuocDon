package com.codegym.blog.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class AppRole {
    @Id
    private int id;
    private String name;

    @OneToMany(mappedBy = "appRole")
    private Set<UserRole> userRoles;


    public AppRole() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

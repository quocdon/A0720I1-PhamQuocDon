package com.codegym.spring_security.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class UserRoleKey implements Serializable {
    @Column(name = "username")
    private String username;

    @Column(name = "role_id")
    private int roleId;
}

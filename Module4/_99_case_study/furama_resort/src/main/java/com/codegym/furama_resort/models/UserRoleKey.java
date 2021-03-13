package com.codegym.furama_resort.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class UserRoleKey implements Serializable {
    @Column(name = "user_id")
    int userId;

    @Column(name = "role_id")
    int roleId;
}

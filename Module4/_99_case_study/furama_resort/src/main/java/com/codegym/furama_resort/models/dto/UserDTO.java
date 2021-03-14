package com.codegym.furama_resort.models.dto;

import com.codegym.furama_resort.models.Employee;
import com.codegym.furama_resort.models.Role;
import com.codegym.furama_resort.models.User;

public class UserDTO {
    private User user;
    private Employee employee;
    private Role role;

    public UserDTO() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}

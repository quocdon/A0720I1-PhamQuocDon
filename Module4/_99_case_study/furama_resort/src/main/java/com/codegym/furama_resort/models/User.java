package com.codegym.furama_resort.models;

import com.codegym.furama_resort.services.UserService;
import com.codegym.furama_resort.services.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.persistence.*;
import java.util.Set;

@Entity
public class User implements Validator {
    @Id
    private String username;
    private String password;

    @OneToOne(mappedBy = "user")
    private Employee employee;

    @OneToMany(mappedBy = "user")
    Set<UserRole> userRoles;

    public User() {
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

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserService userService = new UserServiceImpl();
        User user = (User) target;
        String username = user.getUsername();
        ValidationUtils.rejectIfEmpty(errors, "username", "username.Empty");
        if (userService.findByUsername(username) != null){
            errors.rejectValue("username", "username.Exist");
        }
    }
}

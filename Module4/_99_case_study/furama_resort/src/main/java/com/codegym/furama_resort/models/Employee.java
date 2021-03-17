package com.codegym.furama_resort.models;

import com.codegym.furama_resort.services.EmployeeService;
import com.codegym.furama_resort.services.UserService;
import com.codegym.furama_resort.services.impl.EmployeeServiceImpl;
import com.codegym.furama_resort.services.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Entity
public class Employee implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "Không để trống")
    private String name;
    @NotNull(message = "Không để trống")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate birthday;
    @Pattern(regexp = "^(\\d{9})|(\\d{12})$", message = "CMND gồm 9 hoặc 12 số")
    private String idCard;
    @Min(value = 0, message = "Tối thiểu 0")
    private double salary;
    @Pattern(regexp = "^09[0-1][0-9]{7}|\\(84\\)\\+9[0-1][0-9]{7}$", message = "Phải đúng định dạng 090xxxxxxx hoặc 091xxxxxxx hoặc (84)+90xxxxxxx hoặc (84)+91xxxxxxx")
    private String phone;
    @Pattern(regexp = "^[a-z][a-z0-9_\\.]{5,32}@[a-z0-9]{2,}(\\.[a-z0-9]{2,4}){1,2}$", message = "Phải đúng định dạng abc@xyz.com")
    private String email;
    @NotBlank(message = "Không để trống")
    private String address;

    @ManyToOne
    @JoinColumn(name = "position_id", nullable = false)
    private Position position;

    @ManyToOne
    @JoinColumn(name = "education_degree_id", nullable = false)
    private EducationDegree educationDegree;

    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "username", referencedColumnName = "username")
    private User user;

    public Employee() {
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

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Employee.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserService userService = new UserServiceImpl();
        Employee employee = (Employee) target;
        String username = employee.getUser().getUsername();
        ValidationUtils.rejectIfEmpty(errors, "user.username", "user.username.Empty");
        if (userService.findByUsername(username) != null){
            errors.rejectValue("user.username", "user.username.Exist");
        }
    }
}

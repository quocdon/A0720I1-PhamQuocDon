package com.codegym.furama_resort.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

public class EmployeeDTO {
    @NotBlank
    private String username;
    private String password;
    @NotBlank(message = "Không để trống")
    private String name;
    @NotBlank(message = "Không để trống")
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
    @NotNull
    private Position position;
    @NotNull
    private EducationDegree educationDegree;
    @NotNull
    private Department department;
}

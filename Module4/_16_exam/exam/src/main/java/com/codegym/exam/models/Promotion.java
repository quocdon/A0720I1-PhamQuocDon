package com.codegym.exam.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
public class Promotion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotBlank(message = "Không để trống")
    private String name;
    @Pattern(regexp = "^[0-9]{2}\\/[0-9]{2}\\/[0-9]{4}$", message = "Ngày đúng định dạng dd/MM/yyyy")
    private String startDate;
    @Pattern(regexp = "^[0-9]{2}\\/[0-9]{2}\\/[0-9]{4}$", message = "Ngày đúng định dạng dd/MM/yyyy")
    private String endDate;
    @Min(value = 10000, message = "Tối thiểu 10.000 VND")
    private long discount;
    @NotBlank(message = "Không để trống")
    private String detail;

    public Promotion() {
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

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public long getDiscount() {
        return discount;
    }

    public void setDiscount(long discount) {
        this.discount = discount;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}

package com.codegym.furama_resort.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
public class Customer {
    @Id
    private String id;

    @ManyToOne
    @JoinColumn(name = "customer_type_id", nullable = false)
    private CustomerType customerType;

    private String name;
    private Date birthday;
    private String gender;
    private String idCard;
    private String phone;
    private String email;
    private String address;

    public Customer() {
    }


}

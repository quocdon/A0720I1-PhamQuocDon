package com.codegym.furama_resort.models;

import org.springframework.stereotype.Controller;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Service {
    @Id
    private String id;
    private String name;
    private int area;
    private double cost;
    private int maxPeople;
    @ManyToOne
    @JoinColumn(name = "rent_type_id", nullable = false)
    private RentType rentType;

    @ManyToOne
    @JoinColumn(name = "service_type_id", nullable = false)
    private ServiceType serviceType;

    @OneToMany(mappedBy = "service")
    private Set<Contract> contracts;

    public Service() {
    }


}

package com.codegym.furama_resort.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "service_type")
public class ServiceType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @OneToMany(mappedBy = "serviceType")
    private Set<ResortService> resortServices;

    public ServiceType() {
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

    public Set<ResortService> getResortServices() {
        return resortServices;
    }

    public void setResortServices(Set<ResortService> resortServices) {
        this.resortServices = resortServices;
    }
}

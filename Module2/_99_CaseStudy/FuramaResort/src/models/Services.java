package models;

import java.io.Serializable;

public abstract class Services implements Serializable {
    private String id;
    private String serviceName;
    private double area;
    private double rate;
    private int maxCapacity;
    private String rentType;

    protected Services(){
    };

    protected Services(String id, String serviceName, double area, double rate, int maxCapacity, String rentType) {
        this.id = id;
        this.serviceName = serviceName;
        this.area = area;
        this.rate = rate;
        this.maxCapacity = maxCapacity;
        this.rentType = rentType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public String getRentType() {
        return rentType;
    }

    public void setRentType(String rentType) {
        this.rentType = rentType;
    }

    public abstract String showInfo();
}

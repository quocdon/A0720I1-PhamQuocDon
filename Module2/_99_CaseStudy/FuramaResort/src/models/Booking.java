package models;

public class Booking {
    private Customer customer;
    private Services service;

    public Booking() {
    }

    public Booking(Customer customer, Services service) {
        this.customer = customer;
        this.service = service;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Services getService() {
        return service;
    }

    public void setService(Services service) {
        this.service = service;
    }

    public String getHeader(){
        return this.customer.getHeader() + ",Service Id";
    }

    public String showInfo() {
        return "Booking{" +
                "customer=" + customer.showInfo() +
                ", service=" + service.showInfo() +
                '}';
    }

    public String writeToCSV(){
        return customer.writeToCSV() + "," + service.getId();
    }
}

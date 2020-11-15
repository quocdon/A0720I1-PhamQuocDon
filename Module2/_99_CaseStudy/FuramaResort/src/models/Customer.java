package models;

import java.time.LocalDate;

public class Customer {
    private String name;
    private String birthday;
    private String gender;
    private String id;
    private String phoneNumber;
    private String email;
    private String customerClass;
    private String address;
    private Services bookedService;

    public Customer() {
    }

    public Customer(String name, String birthday, String gender, String id, String phoneNumber, String email, String customerClass, String address, Services bookedService) {
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.customerClass = customerClass;
        this.address = address;
        this.bookedService = bookedService;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCustomerClass() {
        return customerClass;
    }

    public void setCustomerClass(String customerClass) {
        this.customerClass = customerClass;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Services getBookedService() {
        return bookedService;
    }

    public void setBookedService(Services bookedService) {
        this.bookedService = bookedService;
    }

    public String getFirstName() {
        String[] fullname = this.name.split(" ");
        return fullname[fullname.length - 1];
    }

    public LocalDate getBirthdayToDate(){
        String[] birthdayArr = this.birthday.split("/");
        LocalDate date = LocalDate.of(Integer.parseInt(birthdayArr[2]), Integer.parseInt(birthdayArr[1]), Integer.parseInt(birthdayArr[0]));
        return date;
    }

    public String showInfo() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", birthday='" + birthday + '\'' +
                ", gender='" + gender + '\'' +
                ", id='" + id + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", customerClass='" + customerClass + '\'' +
                ", address='" + address + '\'' +
                ", bookedService='" + (bookedService == null? "null": bookedService.showInfo()) + '\'' +
                '}';
    }

    public String getHeader() {
        return "Name,Birthday,Gender,Id,Phone Number,Email,Customer Class,Address,Booked Service";
    }

    public String writeToCSV() {
        return name +
                "," + birthday +
                "," + gender +
                "," + id +
                "," + phoneNumber +
                "," + email +
                "," + customerClass +
                "," + address +
                "," + (bookedService == null? null: bookedService.getId());

    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", birthday='" + birthday + '\'' +
                ", gender='" + gender + '\'' +
                ", id='" + id + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", customerClass='" + customerClass + '\'' +
                ", address='" + address + '\'' +
                ", bookedService=" + (bookedService == null? "null": bookedService.showInfo()) +
                '}';
    }
}

package models;

public class Customer {
    private String name;
    private String birthday;
    private String gender;
    private String id;
    private String phoneNumber;
    private String email;
    private String customerClass;
    private String address;

    public Customer(){}

    public Customer(String name, String birthday, String gender, String id, String phoneNumber, String email, String customerClass, String address) {
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.customerClass = customerClass;
        this.address = address;
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
                '}';
    }

    public String getHeader(){
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
                "," + address;
    }

}

package model;

public class Room {
    private int id;
    private String renterName;
    private String phone;
    private String rentDate;
    private String paymentMethod;
    private String remark;

    public Room() {
    }

    public Room(String renterName, String phone, String rentDate, String paymentMethod, String remark) {
        this.renterName = renterName;
        this.phone = phone;
        this.rentDate = rentDate;
        this.paymentMethod = paymentMethod;
        this.remark = remark;
    }

    public Room(int id, String renterName, String phone, String rentDate, String paymentMethod, String remark) {
        this.id = id;
        this.renterName = renterName;
        this.phone = phone;
        this.rentDate = rentDate;
        this.paymentMethod = paymentMethod;
        this.remark = remark;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRenterName() {
        return renterName;
    }

    public void setRenterName(String renterName) {
        this.renterName = renterName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRentDate() {
        return rentDate;
    }

    public void setRentDate(String rentDate) {
        this.rentDate = rentDate;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}

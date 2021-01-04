package models;

public class Customer {
    public String username;
    public String password;
    public String name;
    public String birthday;
    public String address;
    public String image;

    public Customer() {
    }

    public Customer(String username, String password, String name, String birthday, String address, String image) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.birthday = birthday;
        this.address = address;
        this.image = image;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}

package models;

public class Villa extends Services {
    private String roomType;
    private String amenities;
    private double poolArea;
    private int floor;

    public Villa() {
    }

    public Villa(String id, String serviceName, double area, double rate, int maxCapacity, String rentType, String roomType, String amenities, double poolArea, int floor) {
        super(id, serviceName, area, rate, maxCapacity, rentType);
        this.roomType = roomType;
        this.amenities = amenities;
        this.poolArea = poolArea;
        this.floor = floor;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getAmenities() {
        return amenities;
    }

    public void setAmenities(String amenities) {
        this.amenities = amenities;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    @Override
    public String showInfo() {
        return "Villa{" +
                "id='" + getId() + '\'' +
                ", serviceName='" + getServiceName() + '\'' +
                ", area=" + getArea() +
                ", rate=" + getRate() +
                ", maxCapacity=" + getMaxCapacity() +
                ", rentType='" + getRentType() + '\'' +
                ", roomType='" + roomType + '\'' +
                ", amenities='" + amenities + '\'' +
                ", poolArea=" + poolArea + '\'' +
                ", floor=" + floor +
                '}';

    }

    @Override
    public String toString() {
        return getId() +
                "," + getServiceName() +
                "," + getArea() +
                "," + getRate() +
                "," + getMaxCapacity() +
                "," + getRentType() +
                "," + roomType +
                "," + amenities +
                "," + poolArea +
                "," + floor;
    }
}

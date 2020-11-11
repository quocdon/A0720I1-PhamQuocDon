package models;

public class House extends Services {
    private String roomType;
    private String amenities;
    private int floor;

    public House() {
    }

    ;

    public House(String roomType, String amenities, int floor) {
        this.roomType = roomType;
        this.amenities = amenities;
        this.floor = floor;
    }

    public House(String id, String serviceName, double area, double rate, int maxCapacity, String rentType, String roomType, String amenities, int floor) {
        super(id, serviceName, area, rate, maxCapacity, rentType);
        this.roomType = roomType;
        this.amenities = amenities;
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

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    @Override
    public String showInfo() {
        return "House{" +
                "id='" + getId() + '\'' +
                ", serviceName='" + getServiceName() + '\'' +
                ", area=" + getArea() +
                ", rate=" + getRate() +
                ", maxCapacity=" + getMaxCapacity() +
                ", rentType='" + getRentType() + '\'' +
                ", roomType='" + roomType + '\'' +
                ", amenities='" + amenities + '\'' +
                ", floor=" + floor +
                '}';
    }

    public String writeToCSV() {
        return getId() +
                "," + getServiceName() +
                "," + getArea() +
                "," + getRate() +
                "," + getMaxCapacity() +
                "," + getRentType() +
                "," + roomType +
                "," + amenities +
                "," + floor;
    }

    public String getHeader() {
        return "House Id,Service Name,Area,Rate,Max Capacity,Rent Type,Room Type,Amenities,floor";
    }
}

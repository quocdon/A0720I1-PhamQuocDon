package models;

public class Villa extends Services {
    private String roomType;
    private String compService;
    private double poolArea;
    private int floor;

    public Villa() {
    }

    public Villa(String id, String serviceName, double area, double rate, int maxCapacity, String rentType, String roomType, String compService, double poolArea, int floor) {
        super(id, serviceName, area, rate, maxCapacity, rentType);
        this.roomType = roomType;
        this.compService = compService;
        this.poolArea = poolArea;
        this.floor = floor;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getCompService() {
        return compService;
    }

    public void setCompService(String compService) {
        this.compService = compService;
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
                ", compService='" + compService + '\'' +
                ", poolArea=" + poolArea +
                ", floor=" + floor +
                '}';
    }

    @Override
    public String writeToCSV() {
        return getId() +
                "," + getServiceName() +
                "," + getArea() +
                "," + getRate() +
                "," + getMaxCapacity() +
                "," + getRentType() +
                "," + roomType +
                "," + compService +
                "," + poolArea +
                "," + floor;
    }


    public String getHeader() {
        return "Villa Id,Service Name,Area,Rate,Max Capacity,Rent Type,Room Type,Comp Service,Pool Area,floor";
    }

    @Override
    public String toString() {
        return "Villa{" +
                "id='" + getId() + '\'' +
                ", serviceName='" + getServiceName() + '\'' +
                ", area=" + getArea() +
                ", rate=" + getRate() +
                ", maxCapacity=" + getMaxCapacity() +
                ", rentType='" + getRentType() + '\'' +
                ", roomType='" + roomType + '\'' +
                ", compService='" + compService + '\'' +
                ", poolArea=" + poolArea +
                ", floor=" + floor +
                '}';
    }
}

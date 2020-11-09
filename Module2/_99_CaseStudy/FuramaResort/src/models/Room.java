package models;

public class Room extends Services {
    private String compServices;

    public Room() {
    }

    public Room(String compServices) {
        this.compServices = compServices;
    }

    public Room(String id, String serviceName, double area, double rate, int maxCapacity, String rentType, String compServices) {
        super(id, serviceName, area, rate, maxCapacity, rentType);
        this.compServices = compServices;
    }

    public String getCompServices() {
        return compServices;
    }

    public void setCompServices(String compServices) {
        this.compServices = compServices;
    }

    @Override
    public String showInfo() {
        return  "Room{" +
                "id='" + getId() + '\'' +
                ", serviceName='" + getServiceName() + '\'' +
                ", area=" + getArea() +
                ", rate=" + getRate() +
                ", maxCapacity=" + getMaxCapacity() +
                ", rentType='" + getRentType() + '\''+
                ", compServices='" + compServices + '\''+
                '}';
    }



    public String toString() {
        return getId() +
                "," + getServiceName() +
                "," + getArea() +
                "," + getRate() +
                "," + getMaxCapacity() +
                "," + getRentType() +
                "," + compServices;
    }

    public String getHeader() {
        return "Room Id,Service Name,Area,Rate,Max Capacity,Rent Type,Comp Services";
    }
}

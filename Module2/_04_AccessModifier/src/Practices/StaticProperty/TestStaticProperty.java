package Practices.StaticProperty;

public class TestStaticProperty {
    public static void main(String[] args) {
        Car car1 = new Car("Mazda 3", "Skyactiv 3");
        System.out.println(car1.numOfCars);
        Car car2 = new Car("Mazda 6", "Skyactiv 6");
        System.out.println(Car.numOfCars);
        Car car3 = new Car("Mazda 7", "Skyactiv 7");
        System.out.println(car3.numOfCars);
    }
}

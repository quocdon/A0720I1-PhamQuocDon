package Practices.StaticProperty;

public class Car {
    private String name;
    private String engine;
    public static int numOfCars;

    public Car(String name, String engine) {
        this.name = name;
        this.engine = engine;
        numOfCars++;
    }
}

package Exercise.Fan;

public class FanProgram {
    public static void main(String[] args) {
        Fan fan1 = new Fan();
        Fan fan2 = new Fan();
        fan1.setSpeed(3);
        fan1.setRadius(10);
        fan1.setColor("yellow");
        fan1.setOn(true);
        fan2.setSpeed(2);
        System.out.println(fan1.toString());
        System.out.println(fan2.toString());
    }

}

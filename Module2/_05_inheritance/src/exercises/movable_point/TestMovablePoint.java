package exercises.movable_point;

public class TestMovablePoint {
    public static void main(String[] args) {
        MovablePoint point = new MovablePoint(5,2,3,1);
        point.move();
        System.out.println(point.toString());
    }
}

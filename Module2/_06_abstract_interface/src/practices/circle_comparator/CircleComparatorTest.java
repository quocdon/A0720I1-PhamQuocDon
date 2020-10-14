package practices.circle_comparator;

import practices.Circle;
import practices.comparable_circle.ComparableCircle;

import java.util.Arrays;
import java.util.Comparator;

public class CircleComparatorTest {
    public static void main(String[] args) {
        Circle[] circles = new Circle[3];
        circles[0] = new Circle(3.6);
        circles[1] = new Circle();
        circles[2] = new Circle("indigo", true, 3.5);
        System.out.println("Pre-sorted");
        for (Circle circle : circles) {
            System.out.println(circle);
        }
        Comparator circlesComparator = new CircleComparator();
        Arrays.sort(circles, circlesComparator);
        System.out.println("After-sorted");
        for (Circle circle : circles) {
            System.out.println(circle);
        }
    }
}

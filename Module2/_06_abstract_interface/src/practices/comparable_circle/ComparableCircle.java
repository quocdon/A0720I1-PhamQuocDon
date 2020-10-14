package practices.comparable_circle;

import practices.Circle;

public class ComparableCircle extends Circle implements Comparable<ComparableCircle> {
    public ComparableCircle() {
    }

    public ComparableCircle(double radius){
        super(radius);
    }

    public ComparableCircle(String color, boolean filled, double radius) {
        super(color, filled, radius);
    }

    @Override
    public int compareTo(ComparableCircle comCircle) {
        if (getRadius() > comCircle.getRadius()){
            return 1;
        } else if (getRadius() < comCircle.getRadius()){
            return -1;
        } else return 0;
    }
}

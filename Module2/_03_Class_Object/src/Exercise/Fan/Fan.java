package Exercise.Fan;

public class Fan {
    final private int SLOW = 1;
    final private int MEDIUM = 2;
    final private int FAST = 3;
    private int speed;
    private boolean on;
    private double radius;
    private String color;
    public int getSpeed(){
        return this.speed;
    }
    public boolean getOn(){
        return this.on;
    }
    public double getRadius(){
        return this.radius;
    }
    public String getColor(){
        return this.color;
    }
    public void setSpeed(int speed){
        this.speed = speed;
    }
    public void setOn(boolean status){
        this.on = status;
    }
    public void setRadius(double radius){
        this.radius = radius;
    }
    public void setColor(String color){
        this.color = color;
    }
    public Fan(){
        this.setSpeed(SLOW);
        this.setOn(false);
        this.setRadius(5);
        this.setColor("blue");
    }
    public String toString(){
        if (this.getOn())
            return this.getSpeed()+ " - " + this.getColor()+ " - " + this.getRadius() + " - fan is on";
        else return this.getColor() + " - " + this.getRadius() + " - fan is off";
    }
}

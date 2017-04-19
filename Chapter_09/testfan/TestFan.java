package testfan;

public class TestFan {

    public static void main(String[] args) {
        Fan fan1 = new Fan();
        Fan fan2 = new Fan();
        fan1.setSpeed(3);
        fan1.setRadius(10);
        fan1.setColor("yellow");
        fan1.setOn(true);
        fan2.setSpeed(2);
        System.out.print(fan1.toString());
        System.out.print(fan2.toString());
    }
    
}

class Fan{
    final static int SLOW = 1;
    final static int MEDIUM = 2;
    final static int FAST = 3;
    
    private int speed;
    private boolean on;
    private double radius;
    private String color;
    
    Fan(){
        speed = SLOW;
        on = false;
        radius = 5;
        color = "blue";
    }
    
    public String getSpeed(){
        String sp = "";
        switch(speed){
            case 1: sp += "SLOW"; break;
            case 2: sp += "MEDIUM"; break;
            case 3: sp += "FAST";
        }
        return sp;
    }
    public boolean getOn(){
        return on;
    }
    public double getRadius(){
        return radius;
    }
    public String getColor(){
        return color;
    }
    public void setSpeed(int speed){
        this.speed = speed;
    }
    public void setOn(boolean on){
        this.on = on;
    }
    public void setRadius(double radius){
        this.radius = radius;
    }
    public void setColor(String color){
        this.color = color;
    }
    @Override
    public String toString(){
        if(on){
            return "\nFan speed: " + this.getSpeed() + ", color: " + this.getColor() + 
                               " radius: " + this.getRadius() + "\n";
        }
        else{
            return "\nFan color: " + this.getColor() + ", radius: " + this.getRadius() + "\nThe fan is off\n";
        }
    }
}
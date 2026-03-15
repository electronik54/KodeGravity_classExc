package mar14;

public class Circle {
    private double radius;
    private static double pie = 3.14;

    public Circle(double radius){
        this.radius = radius;
    }

    double getRadius(){
        return radius;
    }
    double getArea(){
        return Utils.roundNumber(pie*radius, 2);
    }
}

package mar14;

public class Square extends Shape {
    private double side;

    public Square(double side) {
        this.side = side;
    }

    double getSide(){
        return side;
    }

    double getArea(){
        return Utils.roundNumber(side*side, 2);
    }
}

package mar14;

public class Rectangle {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    double[] getSides(){
        return new double[]{length, width};
    }
    double getArea(){
        return Utils.roundNumber(length*width, 2);
    }

//    boolean setSides(double[] sides){
//        if(sides.length != 2) return  false;
//
//        this.length = sides[0];
//        this.width = sides[1];
//
//        return true;
//    }
}

public class Operators {
    public  static void main(String[] args){
        int x =10;
        int y = 20;
        int a= 15;
        int b= 25;

        System.out.print(x==y);
        System.out.print(x<y);
        System.out.print(x>=y);
        System.out.print(y>=b);
        System.out.print(x<=b);
        System.out.println(a>=b);
        System.out.println("-----------");

        System.out.println((x == y) && (x<5));
        System.out.println((x < y) || (y>a));
        System.out.println((x >= y) && (a==5));
        System.out.println((y >= b) || (y==20));
        System.out.println(!(x <= b));

    }
}
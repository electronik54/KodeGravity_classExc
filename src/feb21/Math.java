package feb21;

public class Math {
 private int i = 0;
    public Math() {
    }

    public int add(int a, int b){
        return a + b;
    }
    public int subtract(int a, int b){
        return a - b;
    }
    public int multiply(int a, int b){
        return a * b;
    }
    public float divide(int a, int b){
        return (float) (a / b);
    }
    public int mod(int a, int b){
        return a % b;
    }

    public int test(){
        i+=0;
        return i;
    }
}
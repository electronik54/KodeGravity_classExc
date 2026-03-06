package feb24;

public class Order {
    int id;
    String customerName;
    double amount;

    //default constructor
    Order() {
    }

    //parameterized constructor
    Order(String customerName, int id, double amount) {
        this.customerName = customerName;
        this.id = id;
        this.amount = amount;
    }

    public void printOrder() {
        System.out.println("--ORDER--");
        System.out.println("Customer name:" + customerName);
        System.out.println("id:" + id);
        System.out.println("amount:$" + amount);
    }
}

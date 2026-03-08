package mar07;

import java.math.BigDecimal;
import java.util.Date;

public class Order {
    static int orderCount;
    String orderId;
    Date orderDate;
    String item;
    int quantity;
    double price;

    {
        orderId = "OR:" + ++orderCount;
        this.orderDate = new Date();
    }
    public Order(String item, int quantity, double price) {
        this.item = item;
        this.quantity = quantity;
        this.price = price;
    }

    public String getOrder() {
        return ("ORDER-ID:" + orderId + " | DATE:" + orderDate + "\n"
                + "ITEM:" + item + "---QUANTITY:" + quantity + "---PRICE:$" + price+"\n"
                + "-----------------------\n"
                + "TOTAL+TAX:$"+getTotalAndTax());
    }
    public double getTotalAndTax() {
        return  BigDecimal.valueOf((price * quantity) * 1.13).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }
}

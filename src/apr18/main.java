package apr18;

/*
 * HOMEWORK: use <Gradle>
 * <Comparator> interface: SINCE <Comparable> INTERFACE BREAKS SOLID PRINCIPLE WHERE THE CLASS HA STO BE MODIFIED FOR EVERY NEW FIELD THAT CAN BE COMPARED
 * <Maven>:
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class main {
    public static void main(String[] args) {

        List<Product> list = new ArrayList<>();
        list.add(new Product("1012", "Iphone", 1500.50, 10));
        list.add(new Product("1012", "Macbook", 1800, 11));
        list.add(new Product("1012", "Airtag", 30.50, 0));
        list.add(new Product("1012", "Speaker", 250.10, 3));
        list.add(new Product("1012", "Airpods", 400, 1));

        Collections.sort(list, new PriceComparator());
        System.out.println("PRICE SORT: " + list);

        Collections.sort(list, new NameComparator());
        System.out.println("NAME SORT: " + list);

        Collections.sort(list, new QuantityComparator());
        System.out.println("QUANTITY SORT: " + list);

    }
}

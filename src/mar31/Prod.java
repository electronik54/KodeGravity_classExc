package mar31;

import Utils.Err.Err;

import java.util.ArrayList;


public class Prod {

    public static void main(String[] args) {

        ArrayList<Product> listProducts = new ArrayList<>();
        listProducts.add(new Product("product1", 1231234));
        listProducts.add(new Product("product2", 99.9912));
        listProducts.add(new Product("product3", 0.9911223123));
        listProducts.add(new Product("product4", 0));

        Product[] products = new Product[listProducts.size()];
        Product[] arr2 = listProducts.toArray(products);

        for(Product prod :  arr2){
            System.out.println(prod);
        }
    }

}

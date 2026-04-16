package mar31;

import Utils.Err.Err;
import Utils.Utils;

public class Product implements Comparable<Product> {
    private String productName;
    private double productPrice;
    private final String productSku;
    static int productCount;
    private final String productId;

    {
        productCount++;
        productId = productCount + "-43" + productCount + "23-1" + productCount;
        productSku = "sku1" + productId;
    }

    public Product(String productName, double productPrice) throws Err {
        setProductName(productName);
        setProductPrice(productPrice);
        System.out.println("-PRODUCT ADDED-");
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) throws Err {
        String name = Utils.isStringNullOrEmpty(productName);
        if (name.isEmpty())
            throw new Err("!! PRODUCT NAME CANNOT BE NULL !!");

        this.productName = name;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) throws Err {
        if (Utils.isStringNullOrEmpty(String.valueOf(productPrice)).isEmpty())
            throw new Err("!! PRODUCT PRICE CANNOT BE EMPTY !!");

        this.productPrice = Utils.roundNumber(productPrice, 2);
    }

    public String getProductSku() {
        return productSku;
    }

    public String toString() {
        return "[" + productSku + "]:" + productName + "|$" + productPrice;
    }

    @Override
    public int compareTo(Product prodToCompare) {
        return (int) (productPrice - prodToCompare.getProductPrice());
    }

}
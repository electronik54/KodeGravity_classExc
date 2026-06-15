package com.kodegravity.inclass_exr.rules.model;

import java.util.ArrayList;
import java.util.List;

public class OrderPricingRequest {

    private CustomerTier customerTier = CustomerTier.STANDARD;
    private double totalAmount;
    private int loyaltyYears;
    private int discountPercentage;
    private double shippingFee;
    private final List<String> appliedRules = new ArrayList<>();

    public CustomerTier getCustomerTier() {
        return customerTier;
    }

    public void setCustomerTier(CustomerTier customerTier) {
        this.customerTier = customerTier;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public int getLoyaltyYears() {
        return loyaltyYears;
    }

    public void setLoyaltyYears(int loyaltyYears) {
        this.loyaltyYears = loyaltyYears;
    }

    public int getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(int discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public double getShippingFee() {
        return shippingFee;
    }

    public void setShippingFee(double shippingFee) {
        this.shippingFee = shippingFee;
    }

    public List<String> getAppliedRules() {
        return appliedRules;
    }
}

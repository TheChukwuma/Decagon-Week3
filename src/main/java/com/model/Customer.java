package com.model;

import java.util.HashMap;

public class Customer extends Person {
    private Double customerMoney;
    private HashMap<String, Long> customerProduct;
    public Customer(String name, Double customerMoney) {
        super(name);
        this.customerMoney = customerMoney;
        this.customerProduct = new HashMap<>();
    }

    public void setBalance(double newAmount){
        this.customerMoney = newAmount;
    }

    public double getCustomerMoney() {
        return this.customerMoney;
    }

    public void pickProduct(String productName, long productQuantity){
        customerProduct.put(productName, productQuantity);
    }
    public HashMap<String, Long> productInCart() {
        return customerProduct;
    }

    public void buyProduct(){
        if (customerProduct.isEmpty()){
            System.out.println("You have picked no product. Please pick some product or leave the store.");
        }
    }


}

package com.model;

import enums.ProductStatus;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data

public class Product {
    private String productCategory;
    private String productName;
    private long productQuantity;
    private double productCost;
    private ProductStatus productStatus;

    public Product(String productCategory, String productName, long productQuantity, double productCost) {
        this.productCategory = productCategory;
        this.productName = productName;
        this.productQuantity = productQuantity;
        this.productCost = productCost;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productCategory='" + productCategory + '\'' +
                ", productName='" + productName + '\'' +
                ", productQuantity=" + productQuantity +
                ", productCost=" + productCost +
                '}';
    }
}

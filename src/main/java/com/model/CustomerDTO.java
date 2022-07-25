package com.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Comparator;
@Data
@AllArgsConstructor
@EqualsAndHashCode
public class CustomerDTO{
    private String customerName;
    private String productName;
    private long productQuantity;

    @Override
    public String toString() {
        return  customerName + " ->" +
                " [productName='" + productName + '\'' +
                ", productQuantity=" + productQuantity +"]"
                ;
    }

}

package com.model;

import java.util.Comparator;

public class CustomerDTOCompare implements Comparator<CustomerDTO> {

    @Override
    public int compare(CustomerDTO o1, CustomerDTO o2) {

         return o1.getProductQuantity() < o2.getProductQuantity() ? 1: -1;
         //return 0;
    }
}

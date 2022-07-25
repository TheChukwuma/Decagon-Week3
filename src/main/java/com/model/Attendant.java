package com.model;

import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Attendant {
    String name;

    public Attendant(String name){
        this.name = name;
    }

    public void attendToCustomers(CashierImp ci){
        Queue<Customer> customerQueue = ci.getCustomerQueue();
        for (Customer customer : customerQueue){
            Map<String, Long> customerCart = customer.productInCart();
            for (String productName : customerCart.keySet()){
                sellProductByPriority(ci, productName);
                System.out.println();
            }
        }
    }

    private void sellProductByPriority(CashierImp ci, String productName) {
        Map<String, PriorityQueue<CustomerDTO>> proQueueMap = ci.getProductQueue();
        PriorityQueue<CustomerDTO> customerDTOPriorityQueue = proQueueMap.get(productName);
        while (!customerDTOPriorityQueue.isEmpty()){
            CustomerDTO customerDTO = customerDTOPriorityQueue.peek();
            System.out.println("Sold " + customerDTO.getProductQuantity() + " " + customerDTO.getProductName() + " to " + customerDTO.getCustomerName());
            customerDTOPriorityQueue.poll();
        }
    }
}

package com.model;

import java.util.*;

public class CashierImp {
    private Queue<Customer> customerQueue;
    private Map<String, PriorityQueue<CustomerDTO>> productQueue;

    public CashierImp(){
        customerQueue = new LinkedList<>();
        productQueue = new HashMap<>();
    }

    public void addToQueue(Customer customer){
        this.customerQueue.add(customer);
        System.out.println(customer.getName() + " has been added to the queue");
        //check his cart and distribute to product queues
        CustomerDTOCompare cmp = new CustomerDTOCompare();
        for (Map.Entry<String, Long> entry : customer.productInCart().entrySet()){
            String productName = entry.getKey();
            long productQuantity = entry.getValue();
            CustomerDTO customerDTO = new CustomerDTO(customer.getName(), productName, productQuantity);
            if (productQueue.containsKey(productName)){
                productQueue.get(productName).add(customerDTO);}
            else {
                PriorityQueue<CustomerDTO> pqCustomerDTO = new PriorityQueue<>(cmp);
                pqCustomerDTO.add(customerDTO);
                productQueue.put(productName, pqCustomerDTO);
                }
            }
        }

    public Queue<Customer> getCustomerQueue() {
        return customerQueue;
    }

    public Map<String, PriorityQueue<CustomerDTO>> getProductQueue() {
        return productQueue;
    }
}

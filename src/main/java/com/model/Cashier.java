package com.model;

import enums.CashierQualification;
import enums.CashierStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.IOException;
import java.util.*;

@Data
@EqualsAndHashCode
/**
 * Cashier Class
 * <p>
 *     This class is represents the cashier objects.
 *     It encompasses all the properties of a cashier.
 * </p>
 * The methods of this class includes
 * <ul>
 *     <li>sellByPriority</li>
 *     <li>setAllProductsInTheirRespectiveQueue</li>
 *     <li>Getters and setters</li>
 * </ul>
 */
public class Cashier extends Person{
    private int age;
    private final CashierQualification qualification;
    private CashierStatus status;

    private CustomerDTOCompare cmp = new CustomerDTOCompare();
    private Queue<CustomerDTO> carrotQueue = new PriorityQueue<>(cmp);
    private Queue<CustomerDTO> pretzelsQueue = new PriorityQueue<>(cmp);
    private Queue<CustomerDTO> chocolatechipQueue = new PriorityQueue<>(cmp);
    private Queue<CustomerDTO> wholewheatQueue = new PriorityQueue<>(cmp);
    private Queue<CustomerDTO> arrowrootQueue = new PriorityQueue<>(cmp);
    private Queue<CustomerDTO> potatochipsQueue = new PriorityQueue<>(cmp);
    private Queue<CustomerDTO> oatmealraisinQueue = new PriorityQueue<>(cmp);
    private Queue<CustomerDTO> branQueue = new PriorityQueue<>(cmp);
    private Queue<CustomerDTO> bananaQueue = new PriorityQueue<>(cmp);

    private List<Queue<CustomerDTO>> allProductQueue = new ArrayList<>();


    public Cashier(String name, int age, CashierQualification qualification) {
        super(name);
        this.age = age;
        this.qualification = qualification;
    }

    public String sellByPriority(Queue<CustomerDTO> productQueue){
        String strPolledProduct = "";
            while (!productQueue.isEmpty()) {
                CustomerDTO productPolled = productQueue.poll();
                strPolledProduct += productPolled.toString() + "\n";
                //System.out.println(productPolled);
            }
            return strPolledProduct;
    }

    public String setAllProductsInTheirRespectiveQueue(Customer customer) { //setAllProductsInTheirRespectiveQueue
        String output = null;
            for (Map.Entry<String, Long> productInCart : customer.productInCart().entrySet()) {
                if (productInCart.getKey().equalsIgnoreCase("Carrot")) {
                    carrotQueue.add(new CustomerDTO(customer.getName(), productInCart.getKey(), productInCart.getValue()));
                    output = "carrotAdded";
                } else if (productInCart.getKey().equalsIgnoreCase("Pretzels")) {
                    pretzelsQueue.add(new CustomerDTO(customer.getName(), productInCart.getKey(), productInCart.getValue()));
                    output = "pretzelsAdded";
                } else if (productInCart.getKey().equalsIgnoreCase("Chocolate Chips")) {
                    chocolatechipQueue.add(new CustomerDTO(customer.getName(), productInCart.getKey(), productInCart.getValue()));
                    output = "chocolatechipAdded";
                } else if (productInCart.getKey().equalsIgnoreCase("Whole Wheat")) {
                    wholewheatQueue.add(new CustomerDTO(customer.getName(), productInCart.getKey(), productInCart.getValue()));
                    output = "wholewheatAdded";
                }else if (productInCart.getKey().equalsIgnoreCase("Arrowroot")) {
                    arrowrootQueue.add(new CustomerDTO(customer.getName(), productInCart.getKey(), productInCart.getValue()));
                    output = "arrowrootAdded";
                } else if (productInCart.getKey().equalsIgnoreCase("Potato Chips")) {
                    potatochipsQueue.add(new CustomerDTO(customer.getName(), productInCart.getKey(), productInCart.getValue()));
                    output = "potatochipsAdded";
                } else if (productInCart.getKey().equalsIgnoreCase("Oatmeal Raisin")) {
                    oatmealraisinQueue.add(new CustomerDTO(customer.getName(), productInCart.getKey(), productInCart.getValue()));
                    output = "oatmealraisinAdded";
                } else if (productInCart.getKey().equalsIgnoreCase("Bran")) {
                    branQueue.add(new CustomerDTO(customer.getName(), productInCart.getKey(), productInCart.getValue()));
                    output = "branAdded";
                }else if (productInCart.getKey().equalsIgnoreCase("Banana")) {
                    bananaQueue.add(new CustomerDTO(customer.getName(), productInCart.getKey(), productInCart.getValue()));
                    output = "bananaAdded";
                }
            }
        return output;
    }

    public int getAge() {
        return age;
    }

    public CashierQualification getQualification() {
        return qualification;
    }

    public CashierStatus getStatus() {return status;}

    public void setStatus(CashierStatus status) {
        this.status = status;
    }

    public String sellProduct(Customer customer) throws IOException {
        String sellProduct = "";
        String filePath = "src/main/resources/FoodSalesNoHeader.csv";
        MyStore myStore = new MyStore();
        myStore.readFile(filePath);
        if(customer.productInCart().isEmpty()){
            sellProduct = "You have no product in your cart.";
        }
        else{
            for ( Map.Entry<String, Long> entry : customer.productInCart().entrySet()){
                String key = entry.getKey();
                Long value = entry.getValue();
                if (value < myStore.getProductInStore().get(key).getProductQuantity()){
                    sellProduct += customer.getName() +" made a successful purchase of " + key + '\n';
                }
                else {
                    sellProduct = "Dear " + customer.getName() + ", " +  key + " is out of stock";
                }
            }
        } return sellProduct;
    }
}

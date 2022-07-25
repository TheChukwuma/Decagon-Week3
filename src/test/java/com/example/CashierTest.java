package com.example;

import com.model.Cashier;
import com.model.Customer;
import com.model.MyStore;
import enums.CashierQualification;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class CashierTest {

    Cashier cashier = new Cashier("sabinus", 24, CashierQualification.HND);
    Customer customer = new Customer("sade" , 787.0 );
    String filePath = "src/main/resources/FoodSalesNoHeader.csv";
    MyStore myStore = new MyStore();


    public CashierTest() throws IOException {
    }


    @Test  //test if carrot was added to its all the queue.
    public void setAllProductsInTheirRespectiveQueue_Check_If_Carrot_Was_Added() {
        //Given
        customer.pickProduct("Carrot" , 24);
        var expected = "carrotAdded";
        var actual = cashier.setAllProductsInTheirRespectiveQueue(customer);
        assertEquals(expected , actual);
    }

    @Test //test if pretzels was added to its all the queue.
    public void setAllProductsInTheirRespectiveQueue_Check_If_Pretzels_Was_Added() {
        customer.pickProduct("Pretzels", 245);
        var expected = "pretzelsAdded";
        var actual = cashier.setAllProductsInTheirRespectiveQueue(customer);
        assertEquals(expected, actual);
    }

    @Test //test if chocolate chips was added to its all the queue.
    public void setAllProductsInTheirRespectiveQueue_Check_If_ChocolateChips_Was_Added() {
        customer.pickProduct("Chocolate Chips", 45);
        var expected = "chocolatechipAdded";
        var actual = cashier.setAllProductsInTheirRespectiveQueue(customer);
        assertEquals(expected, actual);
    }

    @Test //test if whole wheat was added to its all the queue.
    public void setAllProductsInTheirRespectiveQueue_Check_If_WholeWheat_Was_Added() {
        customer.pickProduct("Whole Wheat", 45);
        var expected = "wholewheatAdded";
        var actual = cashier.setAllProductsInTheirRespectiveQueue(customer);
        assertEquals(expected, actual);
    }

    @Test //test if arrowroot was added to its all the queue.
    public void setAllProductsInTheirRespectiveQueue_Check_If_Arrowroot_Was_Added() {
        customer.pickProduct("Arrowroot", 45);
        var expected = "arrowrootAdded";
        var actual = cashier.setAllProductsInTheirRespectiveQueue(customer);
        assertEquals(expected, actual);
    }

    @Test //test if potato chips was added to its all the queue.
    public void setAllProductsInTheirRespectiveQueue_Check_If_PotatoChips_Was_Added() {
        customer.pickProduct("Potato Chips", 90);
        var expected = "potatochipsAdded";
        var actual = cashier.setAllProductsInTheirRespectiveQueue(customer);
        assertEquals(expected, actual);
    }

    @Test //test if oatmeal raisin was added to its all the queue.
    public void setAllProductsInTheirRespectiveQueue_Check_If_OatmealRaisin_Was_Added() {
        customer.pickProduct("Oatmeal Raisin", 30);
        var expected = "oatmealraisinAdded";
        var actual = cashier.setAllProductsInTheirRespectiveQueue(customer);
        assertEquals(expected, actual);
    }

    @Test //test if Bran was added to its all the queue.
    public void setAllProductsInTheirRespectiveQueue_Check_If_Bran_Was_Added() {
        customer.pickProduct("Bran", 30);
        var expected = "branAdded";
        var actual = cashier.setAllProductsInTheirRespectiveQueue(customer);
        assertEquals(expected, actual);
    }

    @Test //test if banana was added to its queue.
    public void setAllProductsInTheirRespectiveQueue_Check_If_Banana_Was_Added() {
        customer.pickProduct("Banana", 30);
        var expected = "bananaAdded";
        var actual = cashier.setAllProductsInTheirRespectiveQueue(customer);
        assertEquals(expected, actual);
    }

    @Test //test if nothing was added to its all the queue.
    public void setAllProductsInTheirRespectiveQueue_Check_If_Nothing_Was_Added_To_No_Queue() {
        //Given
        //Customer customer = new Customer("sade" , 787.0 );
        //customer.pickProduct("Carrot" , 24);
        //ccustomer.productInCart();
        //var expected = null;
        var actual = cashier.setAllProductsInTheirRespectiveQueue(customer);
        assertNull( actual);
    }

     @Test  //test if the sellProduct returns a string if the customer's cart is empty.
    public void sellProductTest_If_The_Customer_Cart_Is_Empty(){
        var actual = customer.productInCart().isEmpty();
         assertEquals("You have no product in your cart.", true, actual);
     }

     @Test //test if cart not empty and product is in stock
    public void sellProductTest_If_Cart_Not_Empty_And_Product_Is_In_Stock(){

     }

}

package com.model;

import enums.CashierQualification;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        Cashier richard = new Cashier("Richard Roe", 23, CashierQualification.BACHELORS);
//        Cashier jamiu = new Cashier("Jamiu Musa", 17, CashierQualification.BACHELORS);
//        Cashier mary = new Cashier("Mary Odiase", 24, CashierQualification.SSCE);
//        Cashier fabian = new Cashier("Fabian Haruna", 31, CashierQualification.MASTERS);
//        Cashier matthew = new Cashier("Matthew Babatunde", 17, CashierQualification.NONE);
//        Manager sizwe = new Manager("Sizwe Bansi");
//
//        sizwe.hireACashier(richard);
//        sizwe.hireACashier(jamiu);
//        sizwe.hireACashier(mary);
//        sizwe.hireACashier(fabian);
//        sizwe.hireACashier(matthew);
//
//        System.out.println(richard.getStatus()); //only Richard was employed.

        /*customers*/
        Customer jane = new Customer("Jane", 3000.00);
        Customer mark = new Customer("Mark", 5000.0);
        Customer sinzu = new Customer("Sinzu", 3200.00);
        Customer jide = new Customer("Jide", 40000.00);
        Customer sade = new Customer("Sade", 2300.00);
        //Jane is purchasing some product
        jane.pickProduct("Oatmeal Raisin", 500);
        jane.pickProduct("Carrot", 32);
        jane.pickProduct("Banana", 10);
        jane.pickProduct("Arrowroot", 500);
        jane.pickProduct("Potato Chips", 300);
        //mark is purchasing some product
        mark.pickProduct("Oatmeal Raisin", 700);
        mark.pickProduct("Carrot", 20);
        mark.pickProduct("Potato Chips", 300);
        mark.pickProduct("Banana", 60);
        //sinzu is purchasing some product
        sinzu.pickProduct("Oatmeal Raisin", 200);
        sinzu.pickProduct("Carrot", 20);
        sinzu.pickProduct("Banana", 5);
        sinzu.pickProduct("Bran", 200);
        sinzu.pickProduct("Pretzels", 120);
        //jide is purchasing some product
        jide.pickProduct("Oatmeal Raisin", 200);
        jide.pickProduct("Carrot", 20);
        jide.pickProduct("Bran", 700);
        jide.pickProduct("Arrowroot", 400);
        jide.pickProduct("Chocolate Chip", 1000);
        //sade is purchasing product
        sade.pickProduct("Bran", 100);
        sade.pickProduct("Chocolate Chip", 450);
        sade.pickProduct("Whole Wheat", 400);
        sade.pickProduct("Potato Chips", 300);
        sade.pickProduct("Pretzels", 100);
        sade.pickProduct("Arrowroot", 670);

        //List of customers buying from the cashier.
        richard.setAllProductsInTheirRespectiveQueue(sinzu);
        richard.setAllProductsInTheirRespectiveQueue(mark);
        richard.setAllProductsInTheirRespectiveQueue(sade);
        richard.setAllProductsInTheirRespectiveQueue(jide);
        richard.setAllProductsInTheirRespectiveQueue(jane);

        //Selling products by priority
        System.out.println(richard.sellByPriority(richard.getBananaQueue()));
        System.out.println(richard.sellByPriority(richard.getCarrotQueue()));
        System.out.println(richard.sellByPriority(richard.getArrowrootQueue()));
        System.out.println(richard.sellByPriority(richard.getBranQueue()));
        System.out.println(richard.sellByPriority(richard.getPretzelsQueue()));
        System.out.println(richard.sellByPriority(richard.getPotatochipsQueue()));
        System.out.println(richard.sellByPriority(richard.getOatmealraisinQueue()));
        System.out.println(richard.sellByPriority(richard.getWholewheatQueue()));



//        //customers filling their cart with their purchases - Week 2 sha.
//        System.out.println("Customers filling their cart with their purchases");
//        System.out.println(jane.getName() + "  " + jane.productInCart());
//        System.out.println(mark.getName() + "  " + mark.productInCart());
//        System.out.println(sinzu.getName() + "  " + sinzu.productInCart());
//        System.out.println(jide.getName() + "  " + jide.productInCart());

//        System.out.println(richard.sellProduct(jide));
//        System.out.println(richard.sellProduct(sade));
//        System.out.println(richard.sellProduct(sade));


//        our store
//        implementing my buy method in week2
//        String filePath = "src/main/resources/FoodSalesNoHeader.csv";
//        MyStore myStore = new MyStore();
//        myStore.readFile(filePath);
//
//        System.out.println(myStore.getProductInStore());
//        System.out.println();
//        richard.sellProduct(jane);
//        System.out.println();
//        richard.sellProduct(jide);
//        System.out.println();
//        richard.sellProduct(sinzu);
//        System.out.println();
//        richard.sellProduct(mark);
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        //instantiating an attendant - a little like a cashier
        Attendant jamiu = new Attendant("Jamiu");

        CashierImp cashierImp = new CashierImp();

        cashierImp.addToQueue(jide);
        cashierImp.addToQueue(jane);
        cashierImp.addToQueue(sade);
        cashierImp.addToQueue(sinzu);
        cashierImp.addToQueue(mark);

     //   jamiu.attendToCustomers(cashierImp);





    }

}

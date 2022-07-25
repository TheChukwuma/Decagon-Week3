package com.model;

import enums.CashierQualification;
import enums.CashierStatus;

public class Manager extends Person{
    Manager(String name) {
        super(name);
    }

    public void hireACashier(Cashier cashier){
        if (cashier.getAge() > 17){
            if (cashier.getQualification().equals(CashierQualification.BACHELORS) ||  cashier.getQualification().equals(CashierQualification.HND)){
                cashier.setStatus(CashierStatus.EMPLOYED);
                System.out.println("Dear "+ cashier.getName() +", you are hired.");
            } else if (cashier.getQualification().equals(CashierQualification.MASTERS)){
                cashier.setStatus(CashierStatus.NOTEMPLOYED);
                System.out.println("Dear "+ cashier.getName() +", you are overqualified, we cannot employ you.");
            } else {
                cashier.setStatus(CashierStatus.NOTEMPLOYED);
                System.out.println("Dear "+ cashier.getName() +", you are not qualified, we cannot employ you.");
            }
        }
        else {
            cashier.setStatus(CashierStatus.NOTEMPLOYED);
            System.out.println("Dear "+ cashier.getName() +", you are do not meet the age requirement");
        }

    }
}

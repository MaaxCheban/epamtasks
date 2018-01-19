package com.PayPackage;

import java.util.Scanner;

/**
 * Created by MAX on 19.01.2018.
 */
public class CreditCard implements Payable {
    private int pincode;
    private double availableMoney;
    public CreditCard(int pincode, int availableMoney){
        this.pincode = pincode;
        this.availableMoney = availableMoney;
    }
    public boolean pay(double moneyToPay){
        System.out.println("Enter pincode: ");
        Scanner scan = new Scanner(System.in);
        int enteredPincode = scan.nextInt();
        if(pincode != enteredPincode) return false;
        if(availableMoney < moneyToPay) return false;

        availableMoney -= moneyToPay;
        return true;
    }
}

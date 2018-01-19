package com.PayPackage;

/**
 * Created by MAX on 19.01.2018.
 */
public class Cash implements Payable {
    private double availableMoney;
    public Cash(double availableMoney){
        this.availableMoney = availableMoney;
    }

    public boolean pay(double moneyToPay){
        if(availableMoney < moneyToPay) return false;
        availableMoney -= moneyToPay;
        return true;
    }
}

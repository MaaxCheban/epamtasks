package com.PayPackage;

/**
 * Created by MAX on 19.01.2018.
 */
public class Bonuses implements Payable{
    private final double BONUS_WEIGHT = 0.1;
    private double availableMoney;
    public Bonuses(int bonusCount){
        availableMoney = bonusCount * BONUS_WEIGHT;

    }
    public boolean pay(double moneyToPay){
        if(availableMoney < moneyToPay){
            return false;
        }
        availableMoney -= moneyToPay;

        return true;
    }
}

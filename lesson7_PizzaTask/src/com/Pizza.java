package com;

/**
 * Created by MAX on 22.01.2018.
 */
abstract public class Pizza extends Product {
    public Pizza(){
        //addPizzaBase();
    }

    public void addPizzaBase(){
        System.out.println("Creating base for pizza");
        _price += 15.0;
    }


    abstract public void productDescribtion();
}

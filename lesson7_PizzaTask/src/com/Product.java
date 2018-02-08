package com;

/**
 * Created by MAX on 22.01.2018.
 */
abstract public class Product {
    protected double _price = 0;


    abstract public void productDescribtion();
    public double getPrice(){
        return _price;
    }

    public void setPrice(double price){
        _price = price;
    }
}

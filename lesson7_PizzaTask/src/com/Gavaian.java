package com;

/**
 * Created by MAX on 22.01.2018.
 */
public class Gavaian extends Pizza {
    public Gavaian(){
        //addBecon();
        //addTomatoes();
        //addPineapple();
    }

    private void addBecon(){
        System.out.println("Adding bacon");
        _price += 35.0;
    }

    private void addTomatoes(){
        System.out.println("Adding tomatoes");
        _price += 15.0;
    }

    private void addPineapple(){
        System.out.println("Adding pineapple");
        _price += 20.0;
    }

    public void productDescribtion(){
        System.out.println("Its a pineapple pizza, price ");
    }
}

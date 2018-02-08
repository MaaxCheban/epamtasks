package com;

/**
 * Created by MAX on 22.01.2018.
 */
public class Margarita extends Pizza{
    public Margarita(){
        //addBecon();
        //addTomatoes();
    }


    private void addBecon(){
        System.out.println("Adding bacon");
        _price += 25.0;
    }

    private void addTomatoes(){
        System.out.println("Adding tomatoes");
        _price += 15.0;
    }

    public void productDescribtion(){
        System.out.println("Its a margarita pizza, price ");
    }
}

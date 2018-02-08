package com;

import java.util.ArrayList;

/**
 * Created by MAX on 22.01.2018.
 */
public class PizzaOrderer {
    private ArrayList<Product> cart;
    PizzaOrderer(){
        cart = new ArrayList<Product>();
    }

    public PizzaOrderer addProduct(Product product){
        cart.add(product);
        return this;
    }

    public double getTotalCharge(){
        double result = 0;
        for(int i = 0; i < cart.size(); i ++){
            result += cart.get(i).getPrice();
        }
        return result;
    }
}

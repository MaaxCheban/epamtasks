package com;

import com.CoffeePointPackage.CoffeePoint;
import com.CoffeePointPackage.ProductsVariety.Product;
import com.PayPackage.Payable;

/**
 * Created by MAX on 18.01.2018.
 */
public class Customer {
    private String name;
    private Payable paymethod;
    private CoffeePoint coffeePoint;//Association type of composition
    Customer(String name, Payable paymethod){
        this.name = name;
        this.paymethod = paymethod;
    }

    public void initCoffeePoint(CoffeePoint coffeePoint){
        this.coffeePoint = coffeePoint;
    }
    public void chooseProduct(Product product){
        if(coffeePoint == null) return;
        coffeePoint.getProduct(product);
    }

    public void buyProducts(){
        if(coffeePoint == null) return;
        coffeePoint.buyProducts(paymethod);
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public Payable getPaymethod(){
        return paymethod;
    }

    public void setPaymethod(Payable paymethod){
        this.paymethod = paymethod;
    }

}

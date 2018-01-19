package com;

import com.CoffeePointPackage.CoffeePoint;
import com.PayPackage.Payable;
import com.ProductsVariety.*;

/**
 * Created by MAX on 18.01.2018.
 */
public class Customer {
    Payable paymethod;
    CoffeePoint coffeePoint;//Association type of composition
    Customer(Payable paymethod){
        this.paymethod = paymethod;
    }

    public void initCoffeePoint(CoffeePoint coffeePoint){
        this.coffeePoint = coffeePoint;
    }
    public void chooseProduct(Product product){
        coffeePoint.getProduct(product);
    }
    public void buyProducts(){
        coffeePoint.buyProducts(paymethod);
    }

}

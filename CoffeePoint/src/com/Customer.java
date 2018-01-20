package com;

import com.CoffeePointPackage.CoffeePoint;
import com.CoffeePointPackage.ProductsVariety.Product;
import com.PayPackage.Payable;

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
        if(coffeePoint == null) return;
        coffeePoint.getProduct(product);
    }
    public void buyProducts(){
        if(coffeePoint == null) return;
        coffeePoint.buyProducts(paymethod);
    }

}

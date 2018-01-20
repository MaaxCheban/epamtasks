package com.CoffeePointPackage.ProductsVariety;

/**
 * Created by MAX on 19.01.2018.
 */
public class CoffeeWithCream extends Product implements Coffee, Cream {

    public void createProduct(){
        addCoffee();
        addCream();
    }

    public void addCoffee(){
        System.out.println("Fill 0.8 of glass with coffee");
    }
    public void addCream(){
        System.out.println("Fill 0.2 of glass with cream");
    }

    public void productDescribtion() {
        System.out.println("Its a Coffee with cream");
    }

    @Override
    public int hashCode(){
        return 100002;
    }
}

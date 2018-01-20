package com.CoffeePointPackage.ProductsVariety;

/**
 * Created by MAX on 19.01.2018.
 */
public class PureCoffee extends Product implements Coffee{

    public void createProduct(){
        addCoffee();
    }

    public void addCoffee(){
        System.out.println("Fill whole glass of coffee");
    }

    public void productDescribtion() {
        System.out.println("Its a Coffee");
    }

    @Override
    public int hashCode(){
        return 100001;
    }
}

package com.CoffeePointPackage.ProductsVariety;

/**
 * Created by MAX on 19.01.2018.
 */
public class CoffeeWithChocolateAndCream extends Product implements Coffee, Chocolate, Cream {

    public void createProduct(){
        addCoffee();
        addCream();
        addChocolate();
    }

    public void addCoffee(){
        System.out.println("Fill 0.6 of glass with Coffee");
    }
    public void addChocolate(){
        System.out.println("Fill 0.3 of glass with Chocolate");
    }
    public void addCream(){
        System.out.println("Fill 0.1 of glass with Cream");
    }

    public void productDescribtion() {
        System.out.println("Its a Coffee with chocolate and cream");
    }

    @Override
    public int hashCode(){
        return 100003;
    }
}

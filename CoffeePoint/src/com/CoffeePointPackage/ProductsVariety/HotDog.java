package com.CoffeePointPackage.ProductsVariety;

/**
 * Created by MAX on 19.01.2018.
 */
public class HotDog extends Product{

    public void createProduct(){
        System.out.println("Creating HotDog");
    }

    public void productDescribtion() {
        System.out.println("Its a Hot Dog");
    }

    @Override
    public int hashCode(){
        return 100004;
    }
}

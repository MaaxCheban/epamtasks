package com.ProductsVariety;

/**
 * Created by MAX on 18.01.2018.
 */


abstract public class Product {
    abstract public void productDescribtion();
    abstract public void createProduct();
    @Override
    abstract public int hashCode();
    @Override
    public boolean equals(Object ob){
        if(this.hashCode() == ob.hashCode()){
            return true;
        }
        return false;
    }
}





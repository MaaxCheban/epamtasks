package com.CoffeePointPackage;

import com.ProductsVariety.Product;

import java.util.ArrayList;

/**
 * Created by MAX on 18.01.2018.
 */
public class ShoppingCart {

    public ArrayList<Product> selectedProducts = new ArrayList<Product>();

    public ArrayList<Product> getProducts(){
        return selectedProducts;
    }

    public void addProduct(Product product){
        selectedProducts.add(product);
    }
}

package com.CoffeePointPackage;

import com.ProductsVariety.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by MAX on 18.01.2018.
 */
public class ProductsSystem {

    public Map<Product, Double> priceProductsMap = new HashMap<Product, Double>();
    public Map<Product, Integer> countProductsMap = new HashMap<Product, Integer>();
    ProductsSystem(){

        priceProductsMap.put(new PureCoffee(), 12.0);
        countProductsMap.put(new PureCoffee(), 1500);

        priceProductsMap.put(new CoffeeWithCream(), 15.0);
        countProductsMap.put(new CoffeeWithCream(), 1500);

        priceProductsMap.put(new CoffeeWithChocolateAndCream(), 18.0);
        countProductsMap.put(new CoffeeWithChocolateAndCream(), 1500);

        priceProductsMap.put(new HotDog(), 30.0);
        countProductsMap.put(new HotDog(), 150);

    }

    public void addProduct(Product product, int count, double price){
        priceProductsMap.put(product, price);
        countProductsMap.put(product, count);
    }

    public boolean isProductAvailable(Product product){
        int productCount = countProductsMap.get(product);
        if(productCount == 0 ){
            System.out.println("Product u have selected currently is not available");
            return false;
        }
        countProductsMap.put(product, productCount - 1);
        return true;
    }

    public double getProductPrice(Product product){
        return priceProductsMap.get(product);
    }
}

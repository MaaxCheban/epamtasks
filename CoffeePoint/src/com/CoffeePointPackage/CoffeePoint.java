package com.CoffeePointPackage;


import com.PayPackage.Payable;
import com.ProductsVariety.Product;

/**
 * Created by MAX on 18.01.2018.
 */
public class CoffeePoint {
    private ShoppingCart cart;
    private ProductsSystem productsSystem;
    //private static double earnedMoney;
    public CoffeePoint(){
        cart = new ShoppingCart();
        productsSystem = new ProductsSystem();
    }
    public double getTotalCharge(){
        double totalCharge = 0;
        for (Product product : cart.getProducts()) {
            totalCharge += productsSystem.getProductPrice(product);
        }
        return totalCharge;
    }

    public void addProduct(Product product, int count, double price){
        productsSystem.addProduct(product, count, price);
    }

    public void getProduct(Product product){
        if(!productsSystem.isProductAvailable(product)) return;
        cart.addProduct(product);
    }

    public void buyProducts(Payable payMethod){
        if(!payMethod.pay(getTotalCharge())){
            System.out.println("Not enough money");
            cart = null;
            return;
        }
        try {
            for(Product pr : cart.getProducts()){
                pr.createProduct();
            }
        }catch(NullPointerException e){
            e.printStackTrace();
        }

        cart = null;

    }

}

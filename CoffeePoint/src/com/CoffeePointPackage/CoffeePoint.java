package com.CoffeePointPackage;


import com.CoffeePointPackage.ProductsVariety.Product;
import com.PayPackage.Payable;

/**
 * Created by MAX on 18.01.2018.
 */
public class CoffeePoint {
    private ShoppingCart cart;
    private ProductsSystem productsSystem;
    private static double earnedMoney;
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
        if(cart.getProducts().isEmpty()) return;

        if(!payMethod.pay(getTotalCharge())){
            System.out.println("Not enough money");
            cart =  new ShoppingCart();
            return;
        }
        try {
            for(Product pr : cart.getProducts()){
                pr.createProduct();
            }
        }catch(NullPointerException e){
            e.printStackTrace();
        }

        earnedMoney += getTotalCharge();
        cart = new ShoppingCart();
    }

    public static double getEarnedMoney(){
        return earnedMoney;
    }

    public static void setEarnedMoney(double money){
        earnedMoney = money;
    }

    public ShoppingCart getShoppingCart(){
        return cart;
    }

    public void setShoppingCart(ShoppingCart cart){
        this.cart = cart;
    }

}

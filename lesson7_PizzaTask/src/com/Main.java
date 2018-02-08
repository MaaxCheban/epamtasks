package com;

public class Main {

    public static void main(String[] args) {
	// write your code here
        PizzaOrderer po = new PizzaOrderer();
        po.addProduct(new Gavaian())
            .addProduct(new GoldFeather(new Margarita()));

        Product pizza = new Gavaian();
        pizza.productDescribtion();

        pizza = new GoldFeather(new Margarita());

        pizza.productDescribtion();

        //System.out.println(po.getTotalCharge());
        //Gavaian pizza = new Gavaian();
        //pizza.productBuilder();
    }
}

package com;


import com.CoffeePointPackage.CoffeePoint;
import com.PayPackage.*;
import com.ProductsVariety.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        CoffeePoint coffeePoint = new CoffeePoint();

        Customer customer = new Customer(new Cash(450));

        customer.initCoffeePoint(coffeePoint);
        customer.chooseProduct(new PureCoffee());
        customer.chooseProduct(new CoffeeWithChocolateAndCream());
        customer.chooseProduct(new HotDog());
        customer.buyProducts();


        Customer customer2 = new Customer(new Bonuses(5000));

        customer.chooseProduct(new CoffeeWithCream());
        customer.chooseProduct(new HotDog());

        customer.buyProducts();

        System.out.println(coffeePoint.getEarnedMoney());
    }
}

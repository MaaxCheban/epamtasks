package com;


import com.CoffeePointPackage.*;
import com.CoffeePointPackage.ProductsVariety.*;
import com.PayPackage.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        CoffeePoint coffeePoint = new CoffeePoint();

        Customer customer = new Customer("Zurab", new Cash(415));

        customer.initCoffeePoint(coffeePoint);
        customer.chooseProduct(new PureCoffee());
        customer.chooseProduct(new CoffeeWithChocolateAndCream());
        customer.chooseProduct(new HotDog());
        customer.buyProducts();
        customer.buyProducts();

        Customer customer2 = new Customer("Joshua", new Bonuses(900));
        customer2.initCoffeePoint(coffeePoint);
        customer2.chooseProduct(new CoffeeWithCream());
        customer2.chooseProduct(new HotDog());

        customer2.buyProducts();

        System.out.println(coffeePoint.getEarnedMoney());
    }
}

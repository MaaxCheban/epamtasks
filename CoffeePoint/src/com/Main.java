package com;


import com.CoffeePointPackage.CoffeePoint;
import com.PayPackage.Cash;
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

    }
}

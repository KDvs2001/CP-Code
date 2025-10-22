package org.example;

import java.util.Random;

public class Customer implements Runnable{
    private CoffeeShop coffeeShop;
    private Random randomNum = new Random();

    public Customer(CoffeeShop coffeeShop) {
        this.coffeeShop = coffeeShop;
    }

    @Override
    public void run(){
        int randomNumber = randomNum.nextInt();
        coffeeShop.placeOrder("Order " + randomNumber);
        System.out.println("Order "+ randomNumber + " placed successfully");
    }
}

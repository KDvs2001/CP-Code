package org.example;

public class Baristas implements Runnable{
    private CoffeeShop coffeeShop;

    public Baristas(CoffeeShop coffeeShop) {
        this.coffeeShop = coffeeShop;
    }
    @Override
    public void run(){
        while(true){
            String order = coffeeShop.processOrder();
            if(order == null){
                break;
            }
            System.out.println("Order: " + order + " completed..");
        }

    }
}

package org.example;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        CoffeeShop coffeeShop = new CoffeeShop(5);
        Runnable customer = new Customer(coffeeShop);
        Runnable baristas = new Baristas(coffeeShop);
        Thread [] customerThreads = new Thread[5];
        Thread [] baristaThreads = new Thread [2];


       for (int i=0;i< customerThreads.length;i++){
           customerThreads[i] = new Thread(customer, "Customer");
       }

        for (int i=0;i< baristaThreads.length;i++){
            baristaThreads[i] = new Thread(baristas, "Baristas");
        }

        for(Thread t: customerThreads){
            t.start();
        }

        for(Thread t: baristaThreads){
            t.start();
        }

        for(Thread t: customerThreads){
            t.join(); // Telling the main thread to wait until all the Customers (Producers) are done.

        }


        for(Thread t : customerThreads){
            System.out.println(t.getName()+ "State of Customer Thread : " +t.getState());
        }

        coffeeShop.done();

        for(Thread t: baristaThreads){
            t.join();
        }
        for(Thread t : baristaThreads){
            System.out.println(t.getName()+ "State of Baristas Thread : " +t.getState());
        }

        System.out.println("======== Customers and Baristas are done ================");




    }
}
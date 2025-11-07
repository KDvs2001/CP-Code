package PizzaOrderingExample;

import java.util.concurrent.Callable;

public class PizzaOrdering implements Callable<String> {
    private Pizza pizza;

    public PizzaOrdering(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public String call() throws Exception {
        System.out.println("Chef has started preparing "+
                this.pizza.getName() + this.pizza.getSize());
        Thread.sleep(this.pizza.getMakingTime()*1000);
        System.out.println("Chef has finished preparing the pizza" + this.pizza.getName());
        return this.pizza.getName() + " is ready";
    }
}

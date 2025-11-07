package PizzaOrderingExample;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class PizzaSimulator {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Pizza> pizzasList = new ArrayList<>(5);
        Pizza pizza1 = new Pizza("Pizza 1", (long) 10.202, 12);
        Pizza pizza2 = new Pizza("Pizza 2", (long) 23.352, 22);
        Pizza pizza3 = new Pizza("Pizza 3", (long) 10.125, 11);
        Pizza pizza4 = new Pizza("Pizza 4", (long) 10.564, 13);
        Pizza pizza5 = new Pizza("Pizza 5", (long) 15.324, 16);

        pizzasList.add(pizza1);
        pizzasList.add(pizza2);
        pizzasList.add(pizza3);
        pizzasList.add(pizza4);
        pizzasList.add(pizza5);

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        List<Future> futureList = new ArrayList<>();

        for(Pizza p: pizzasList){
            Future<String> future = executorService.submit(new PizzaOrdering(p));
            futureList.add(future);
        }
        for(Future f: futureList){
            System.out.println(f.get());
        }
        executorService.shutdown();


    }
}

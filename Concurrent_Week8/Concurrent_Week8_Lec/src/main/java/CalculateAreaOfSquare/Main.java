package CalculateAreaOfSquare;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Square square1 = new Square(5);
        Square square2 = new Square(15);
        Square square3 = new Square(12);
        Square square4 = new Square(1);
        Square square5 = new Square(9);

        List<Square> squareList = new ArrayList<>(5);
        squareList.add(square1);
        squareList.add(square2);
        squareList.add(square3);
        squareList.add(square4);
        squareList.add(square5);

        ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor();
        for(Square s: squareList){
            Future<Integer> future = executorService.submit(new CalculateArea(s));
            System.out.println("Area of the " + s + " is " + future.get());
        }
        executorService.shutdown();

    }
}

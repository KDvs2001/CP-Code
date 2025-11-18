package CalculateAreaOfSquare;

import java.util.concurrent.Callable;

public class CalculateArea implements Callable<Integer> {
    private Square square;

    public CalculateArea(Square square) {
        this.square = square;
    }

    @Override
    public Integer call() throws Exception {
        int area = this.square.getLength() * this.square.getLength();
        //System.out.println(Thread.currentThread().getName() + "Area is : " + area);
        return area;
    }
}

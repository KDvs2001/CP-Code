package ThreadCreationWays;

import java.util.concurrent.Callable;

public class CallableImp implements Callable<Integer> {
    @Override
    public Integer call() throws InterruptedException {
        int value =0;
        for(int i=0;i<10;i++){
            System.out.println(Thread.currentThread().getName() + i);
            value+=1;
        }
        return value;
    }
}

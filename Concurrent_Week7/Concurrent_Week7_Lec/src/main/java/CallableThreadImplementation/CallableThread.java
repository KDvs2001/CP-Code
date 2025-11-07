package CallableThreadImplementation;

import java.util.concurrent.Callable;

public class CallableThread implements Callable<Integer> {
    private int total;
    @Override
    public Integer call() throws Exception {
        for(int i=1;i<=10;i++){
            total+=i;
        }
        return this.total;
    }
}

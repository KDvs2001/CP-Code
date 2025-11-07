package CustomThreadandRejectionPolicyCreation;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {

        ThreadPoolExecutor threadPoolExecutor =
                new ThreadPoolExecutor(3, 5, 3,
                        TimeUnit.SECONDS, new ArrayBlockingQueue(5),
                        new CustomThreadFactory(),new CustomRejectionPolicy()) ;

        threadPoolExecutor.allowCoreThreadTimeOut(true);

        for(int i=0;i<15;i++){
            threadPoolExecutor.submit(new BaseThread());

        }

        threadPoolExecutor.shutdown();

    }
}

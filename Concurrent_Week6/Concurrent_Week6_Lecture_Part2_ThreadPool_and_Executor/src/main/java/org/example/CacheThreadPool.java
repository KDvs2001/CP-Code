package org.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CacheThreadPool {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for(int i=0;i<100000000;i++){
            Runnable workerThread = new WorkerThread("Task"+ (i+1));
            executorService.submit(workerThread);
        }
        executorService.shutdown(); // No new Tasks will be executed after signaling shutdown.
    }
}

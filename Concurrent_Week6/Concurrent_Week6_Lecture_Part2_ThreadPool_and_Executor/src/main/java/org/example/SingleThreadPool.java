package org.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadPool {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for(int i=0;i<10;i++){
            Runnable workerThread = new WorkerThread("Task"+ (i+1));
            executorService.submit(workerThread);
        }
        executorService.shutdown();
    }
}

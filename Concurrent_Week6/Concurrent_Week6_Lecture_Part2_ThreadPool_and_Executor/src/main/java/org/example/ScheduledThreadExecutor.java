package org.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadExecutor {
    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);
        Runnable workerThread = new WorkerThread("Task");
        executorService.scheduleAtFixedRate(workerThread,3,5, TimeUnit.SECONDS);
        //executorService.scheduleWithFixedDelay(workerThread,3,5,TimeUnit.SECONDS);

    }
}

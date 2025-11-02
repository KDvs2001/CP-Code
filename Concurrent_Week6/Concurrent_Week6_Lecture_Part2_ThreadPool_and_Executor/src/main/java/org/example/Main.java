package org.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
//        Thread[] workerThreads = new Thread[100000000];
//        for(int i=0;i<workerThreads.length;i++){
//            workerThreads[i] = new Thread(new WorkerThread(), "Worker Thread " + i);
//        }
//        for(Thread t:workerThreads){
//            t.start();
//        }

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for(int i=0;i<100;i++){
            Runnable threadWorker = new WorkerThread("Task"+(i+1));
            executorService.submit(threadWorker);
        }
        executorService.shutdown(); // This method is to stop accepting new tasks.
        while(executorService.isTerminated()){ // The purpose of this while loop is to check if there are any tasks being performed.

        }
        System.out.println("All Tasks are done");
    }
}
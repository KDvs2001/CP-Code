package VirtualThreads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException {

        Thread.ofVirtual().name("VT01").start(()->{
            System.out.println(Thread.currentThread().getName()+ " Virtual Thread ");
        });

        Thread thread = Thread.ofVirtual().name("VT02").unstarted(new RunnableThread());
        thread.start();
        thread.join();


        ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor();
        executorService.submit(new RunnableThread());
        executorService.shutdown();

        Thread.Builder builder = Thread.ofVirtual().name("TV03");
        Thread threadBuilder = builder.unstarted(() -> {
            System.out.println(Thread.currentThread().getName() + "Runnable Thread");
        });
        threadBuilder.start();
        threadBuilder.join();

        System.out.println("All threads are completed ");


        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
    }
}
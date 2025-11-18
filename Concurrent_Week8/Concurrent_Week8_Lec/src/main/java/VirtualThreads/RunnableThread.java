package VirtualThreads;

public class RunnableThread implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+ "Runnable Thread");
    }
}

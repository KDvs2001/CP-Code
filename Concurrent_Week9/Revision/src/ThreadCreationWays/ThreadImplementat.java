package ThreadCreationWays;

public class ThreadImplementat extends Thread {

    public ThreadImplementat(String threadName) {
        super(threadName);
    }
    @Override
    public void run()
    {
        for(int i=0;i<10;i++){
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
}

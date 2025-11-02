package Question1;

public class WorkerThread extends Thread{
    public WorkerThread(String name){
        super(name);
    }

    @Override
    public void run(){
        synchronized (WorkerThread.class){
            System.out.println(Thread.currentThread().getName() + " Thread is in BLOCKED state");
        }

        synchronized (WorkerThread.class){
            try{
                WorkerThread.class.wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

        try{
            System.out.println(Thread.currentThread().getName()+ " is in TIMED_WAITING state");
            Thread.sleep(2000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}

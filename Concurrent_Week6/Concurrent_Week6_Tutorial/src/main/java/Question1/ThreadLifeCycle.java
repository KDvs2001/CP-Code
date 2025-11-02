package Question1;

public class ThreadLifeCycle {
    public static void main(String[] args) throws InterruptedException{
        Thread workerThread1 = new WorkerThread("Thread 01");
        System.out.println(workerThread1.getName() + " Thread is in "+ workerThread1.getState() + " state");

        workerThread1.start();

        System.out.println(workerThread1.getName() + " Thread is in "+ Thread.currentThread().getState());

        synchronized (WorkerThread.class){
            System.out.println("Main thread acquiring the lock");
            System.out.println(workerThread1.getName() + " Thread is in WAITING state");


        }

        for (int i = 0; i <= 5; i++) {
            System.out.println("Main thread executing... " + i);
            try {
                Thread.sleep(1000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        synchronized (WorkerThread.class){
            System.out.println("Main thread notifying the waiting worker thread");
            WorkerThread.class.notifyAll();
        }

        workerThread1.join();

        System.out.println(workerThread1.getName() + " is in "+ workerThread1.getState());
        System.out.println("Main Thread is in Terminated state");

    }
}

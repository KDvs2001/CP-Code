package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        Thread t1 = new MyThread("Thread1"); // t1 enters the state called NEW
        //t1.run(); // the run executes on main method
        // This is a sequential program that doesn't run in a separate program
        // If you want to run it in a separate way, you should call the start()
        t1.start(); // The thread (t1) enters the RUNNABLE state

        Runnable t2 = new RunnableClass();
        Thread thread2 = new Thread(t2, "Thread 2");
        thread2.start();


        Thread t3 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + " : " + i);
            }

        }, "Thread 3");

        t3.start();

        Thread t4 = new Thread(new Runnable() {
            @Override
            public void run()
            {
                for(int i=0;i<10;i++)
                {
                    System.out.println(Thread.currentThread().getName() + " : " + i);
                }
            }

        }, "Thread 4");




    }
}


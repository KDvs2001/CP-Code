package Question1;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread counterA = new CounterA("Counter A");
        Runnable cB = new CounterB();
        Thread counterB = new Thread(cB, "Counter B");
        Thread counterC = new Thread(() -> {
            try{
                for(int i=1;i<=5;i++){

                    System.out.println(Thread.currentThread().getName() + " Count is: " + i);
                    Thread.sleep(3000);
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }

        }, "Counter C");

        Thread counterD = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<5;i++){
                    try{
                        System.out.println(Thread.currentThread().getName() + " Count is: "+i);
                        Thread.sleep(1000);
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        },"Counter D");

        counterA.start();
        counterB.start();
        counterC.start();
        counterD.start();

        counterA.join();
        counterB.join();
        counterC.join();
        counterD.join();

        System.out.println("All Threads are executed successfully");

    }
}

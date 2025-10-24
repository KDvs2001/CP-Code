package Question2;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Mailbox mailbox = new Mailbox();
        Thread producer = new Thread (() -> {
            for(int i=1;i<=10;i++){
                mailbox.put(i);
                try{
                    Thread.sleep(500);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        }, "Producer");

        Thread customer = new Thread (() -> {
            for(int i=1;i<=10;i++){
                mailbox.get();
                try{
                    Thread.sleep(500);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        }, "Customer");

        producer.start();
        customer.start();

        producer.join(); // Main thread is waiting this thread to dies out.
        customer.join();

        System.out.println("==================================All Done!==================================");



    }
}

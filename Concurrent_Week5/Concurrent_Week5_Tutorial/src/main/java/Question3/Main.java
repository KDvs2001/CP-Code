package Question3;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Inventory inv = new Inventory();
        Thread manager = new Thread(()->{
            System.out.println(Thread.currentThread().getName() + " Current State is: "+ Thread.currentThread().getState());
            for(int i=0;i<10;i++){
                inv.updateStock("Manager", (i % 2 == 0 ? +10 : -5) );
            }
        },"Writer-Manager");


        for (int i = 1; i <= 3; i++) {
            final int id = i; // Not adding this line results in the following error in the lambda function
            // Error Message: Variable used in lambda expression should be final or effectively final
            // Error Occurred Line of Code :  inv.readStock("Customer-" + i + " checking stock : "+ inv.getStock());
            // i in readStock should declare as final
            new Thread(() -> {
                for (int j = 0; j < 10; j++)
                    inv.readStock("Customer-" + id);
            }).start();
        }

        manager.start();
    }
}
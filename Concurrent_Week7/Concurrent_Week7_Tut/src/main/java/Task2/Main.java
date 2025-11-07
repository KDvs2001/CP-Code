package Task2;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Cafe cafe = new Cafe();
        Thread customerThread = new Thread(new Customer(cafe), "Customer");
        Thread baristaThread = new Thread(new Barista(cafe), "Barista");
        customerThread.start();
        baristaThread.start();
        customerThread.join();
        baristaThread.join();
        System.out.println("==================================All Done!==================================");

    }
}
package Question3;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        SharedResource sharedResource = new SharedResource();
        Thread [] userThreads = new Thread[2];
        for(int i=0;i<userThreads.length;i++){
            userThreads[i] = new Thread(new User(sharedResource), "User " + (i+1) + " Thread");
        }
        for(Thread t: userThreads){
            t.start();
        }

        for(int i=0;i<5;i++){
            int value = sharedResource.incrementCounter();
            System.out.println(Thread.currentThread().getName() + " - Counter Incremented: " + value);
            Thread.sleep(1000);
        }

    }
}

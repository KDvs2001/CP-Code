package Question3;

import Question2.SharedBuffer;

public class User implements Runnable{
    private final SharedResource sharedResource;
    public User(SharedResource sharedResource){
        this.sharedResource = sharedResource;
    }
    @Override
    public void run(){
        sharedResource.waitForCondition(5);
        System.out.println(Thread.currentThread().getName()+ " Condition Met!");
    }
}

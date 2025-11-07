package CustomThreadandRejectionPolicyCreation;

public class BaseThread implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Executing Task.......");
    }
}

package CustomThreadandRejectionPolicyCreation;

import java.util.concurrent.ThreadFactory;

public class CustomThreadFactory implements ThreadFactory {

    @Override
    public Thread newThread(Runnable r) {
        Thread t1 = new Thread(r);
        t1.setPriority(Thread.NORM_PRIORITY);
        t1.setDaemon(false);
        return t1;
    }
}

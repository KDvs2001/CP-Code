package Question3;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Inventory {
    private int stock = 50;
    private final ReadWriteLock rw = new ReentrantReadWriteLock(true);

    public void readStock(String name){
        rw.readLock().lock();
        try{
            System.out.println(name+ " checking stock: "+stock);
            Thread.sleep(2000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }finally{
            rw.readLock().unlock();
        }
    }

    public void updateStock(String name, int change){
        rw.writeLock().lock();
        try{
            int old = stock;
            stock+= change;
            System.out.println(name+ " updated stock: "+ old+ " -> "+ stock);
            Thread.sleep(3000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }finally {
            rw.writeLock().unlock();
        }
    }

    public int getStock(){
        return this.stock;
    }

}

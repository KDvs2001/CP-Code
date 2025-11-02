package Question2;

import java.util.LinkedList;
import java.util.Queue;

public class SharedBuffer {

    private final Queue<Integer> buffer;
    private final int maxSize;

    public SharedBuffer(int maxSize){
        this.buffer = new LinkedList<>();
        this.maxSize = maxSize;

    }

    public synchronized  void produce(int item){
        while(buffer.size() == maxSize){
            try{
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        buffer.add(item);
        notifyAll();
    }

    public synchronized  int consume(){
        while (buffer.isEmpty()){
            try{
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        int item = buffer.poll();
        notifyAll();
        return item;

    }

}

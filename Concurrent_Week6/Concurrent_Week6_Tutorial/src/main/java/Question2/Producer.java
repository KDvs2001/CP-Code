package Question2;

public class Producer implements Runnable{
    private final SharedBuffer buffer;

    public Producer(SharedBuffer buffer){
        this.buffer = buffer;
    }

    @Override
    public void run(){
        for(int i=1;i<=5;i++){
            buffer.produce(i);
            System.out.println("Producer Produced: "+ i);
        }
    }
}

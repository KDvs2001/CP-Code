package Question2;

public class Consumer implements Runnable{
    private final SharedBuffer buffer;

    public Consumer(SharedBuffer buffer){
        this.buffer = buffer;
    }

    @Override
    public void run(){
        for(int i=1;i<=5;i++){
            int item = buffer.consume();
            System.out.println("Consumer Consumed :"+ item);
        }

    }
}

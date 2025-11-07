package Task3;
import java.util.Random;
public class Machine implements Runnable {
    private final ConveyorBelt belt;
    private final String name;
    public Machine(ConveyorBelt belt, String name) {
        this.belt = belt;
        this.name = name;
    }
    @Override
    public void run() {
        Random random = new Random();
        int value = random.nextInt(1,20);
        belt.produce(name , value);
        try{
            Thread.sleep(300);
         }catch (InterruptedException e){
                e.printStackTrace();
        }
    }
}

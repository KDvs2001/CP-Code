package Task3;

public class Packer implements Runnable {
    private final ConveyorBelt belt;
    private final String name;
    public Packer(ConveyorBelt belt, String name) {
        this.belt = belt;
        this.name = name;
    }
    @Override
    public void run() {
        try{
           belt.consume(name);
           Thread.sleep(300);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        }
    }


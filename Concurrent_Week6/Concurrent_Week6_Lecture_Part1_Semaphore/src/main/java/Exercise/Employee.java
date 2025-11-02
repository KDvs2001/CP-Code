package Exercise;

import java.util.Random;

public class Employee implements Runnable{
    private BathroomStall bathroomStall;
    private int slotNumber;
    public Employee(BathroomStall bathroomStall, int slotNumber){
        this.bathroomStall = bathroomStall;
        this.slotNumber = slotNumber;
    }
    @Override
    public void run(){
        String empID = bathroomStall.enterBathroom();
        Random random = new Random();
        int randomNumTime = random.nextInt(100);

        try{
            Thread.sleep(randomNumTime); // Simulating the use of the washroom
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        bathroomStall.exitBathroom(empID);


    }

}

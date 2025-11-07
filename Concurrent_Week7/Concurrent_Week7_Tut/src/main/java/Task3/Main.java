package Task3;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ConveyorBelt belt = new ConveyorBelt(10);
        Thread[] machineThreads = new Thread[5];
        Thread[] packerThreads = new Thread[5];
        for(int i=0;i<machineThreads.length;i++){
            machineThreads[i] = new Thread(new Machine(belt, "Machine"+i), "Machine Thread");
        }
        for(int i=0;i<packerThreads.length;i++){
            packerThreads[i] = new Thread(new Packer(belt, "Packer"+i), "Packer Thread");
        }
        for(Thread t: machineThreads){
            t.start();
        }
        for(Thread t: packerThreads){
            t.start();
        }
        for(Thread t: machineThreads){
            t.join();
        }
        for(Thread t: packerThreads){
            t.join();
        }
        System.out.println("========All done=========================");
    }
}

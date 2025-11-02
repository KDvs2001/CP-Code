package Exercise;

public class Simulation {
    public static void main(String[] args) throws InterruptedException{
        BathroomStall bathroomStall = new BathroomStall(6);

        Thread [] employeesThread = new Thread[100];
        for(int i=0;i<employeesThread.length;i++){
            employeesThread[i] = new Thread(new Employee(bathroomStall,i) , "Employee");
        }

        for(Thread t: employeesThread){
            t.start();
        }
        for(Thread t: employeesThread){
            t.join();
        }
        System.out.println("===========================Done==================================");
    }
}

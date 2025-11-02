package Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Semaphore;
public class BathroomStall {
    private int capacity;
    private List<String> occupiedSlot = new ArrayList<>();
    private Semaphore emptySlot;
    private Semaphore fullSlot;
    private Semaphore mutex;
    public BathroomStall(int capacity){
        this.capacity = capacity;
        this.emptySlot = new Semaphore(capacity, true);
        this.fullSlot = new Semaphore(0,true);
        this.mutex = new Semaphore(1);
    }
    public String enterBathroom(){
        String employeeID = null;
        try{
            emptySlot.acquire();
            mutex.acquire();
            Random randomNumber = new Random();
            do {
                employeeID = String.valueOf(randomNumber.nextInt()); // Generating a number to uniquely identify a person who is entering the bathroom stall.

            }while (occupiedSlot.contains(employeeID)); // To ensure no more than one employee should having the same number
            occupiedSlot.add(employeeID); // Adding the number to the bathroom stall to represent the employee.
            System.out.println("The employee with the employee id: "+ employeeID+ " enters the washroom stall ");
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        finally {
            mutex.release();
            fullSlot.release();
            System.out.println("Number of available Slots: "+ fullSlot.availablePermits());
        }
        return employeeID;
    }

    public void exitBathroom(String employeeID){
        try{
            fullSlot.acquire();
            mutex.acquire();
            occupiedSlot.remove(employeeID);
            System.out.println("Employee with the employee id: "+employeeID + " existing the washroom : ");
        }catch(InterruptedException e){
            e.printStackTrace();
        }finally {
            mutex.release();
            emptySlot.release();
            System.out.println("Number of available Slots: "+ fullSlot.availablePermits());
        }
    }

}

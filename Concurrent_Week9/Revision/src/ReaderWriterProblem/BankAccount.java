package ReaderWriterProblem;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class BankAccount {
    private String bankAcctNum;
    private double balance;

    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private Lock readLock = readWriteLock.readLock();
    private Lock writeLock = readWriteLock.writeLock();

    public BankAccount(String bankAcctNum, double balance) {
        this.bankAcctNum = bankAcctNum;
        this.balance = balance;
    }

    public double getBalance (){
        readLock.lock();
        try{
            return balance;
        }finally {
            readLock.unlock();
        }
    }

    public void deposit(double amount) {
        writeLock.lock();
        try{
            if(amount > 0){
                this.balance += amount;
            }
        }finally {
            writeLock.unlock();
        }
    }

    public void withdraw(double amount) {
        writeLock.lock();
        try{
            if(amount < balance && amount > 0) {
                this.balance -= amount;
            }else{
                System.out.println("Insufficient Balance");
            }
        }finally {
            writeLock.unlock();
        }
    }
}

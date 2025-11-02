package org.example;

import java.math.BigDecimal;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class BankAccount {
    private BigDecimal balance;
    private String accountNum;
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final Lock readLock = lock.readLock();
    private final Lock writeLock = lock.writeLock();
    public BankAccount(BigDecimal balance, String accountNum){
        this.balance = balance;
        this.accountNum = accountNum;
    }

    public BigDecimal getBalance(){
        try{
            readLock.lock();
            return this.balance;
        }finally {
            readLock.unlock();
        }
    }

    public void deposit(BigDecimal amount){
        try{
            writeLock.lock();
            if(amount.doubleValue() > 0){
                this.balance.add(amount);
                System.out.println(Thread.currentThread().getName() + " deposits " +amount + " successfully");
            }else{
                throw new IllegalArgumentException("Amount cannot be a negative value");
            }
        }finally {
            writeLock.unlock();
        }
    }
    public void withdraw(BigDecimal amount){
        try{
            writeLock.lock();
            if(amount.doubleValue() > 0){
                if(amount.compareTo(balance) < 0){
                    this.balance.subtract(amount);
                    System.out.println(Thread.currentThread().getName() + " withdraws " +amount + " successfully");
                }else{
                    throw new IllegalArgumentException("Amount cannot be greater than the balance");
                }
            }else{
                throw new IllegalArgumentException("Amount cannot be a negative value");
            }
        }finally {
            writeLock.unlock();
        }

    }
}

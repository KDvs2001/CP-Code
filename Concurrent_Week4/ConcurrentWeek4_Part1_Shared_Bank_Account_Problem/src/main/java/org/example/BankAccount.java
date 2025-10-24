package org.example;

import java.math.BigDecimal;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class BankAccount {
    private BigDecimal balance;  // This is the shared variable.
    private String acctNumber;
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final Lock readLock = lock.readLock();
    private final Lock writeLock = lock.writeLock();

    public BankAccount(BigDecimal balance, String acctName) {
        this.balance = balance;
        this.acctNumber = acctName;
    }

    public BigDecimal getBalance() { // This is a read method
        try{
            readLock.lock();
            return this.balance;
        }finally {
            readLock.unlock();
        }

    }

    public String getAcctNumber() {
        return acctNumber;
    }

    public void deposit(BigDecimal amount){
        try{
            writeLock.lock();
            if(amount.doubleValue() > 0){
                this.balance = this.balance.add(amount);
            }else{
                throw new IllegalArgumentException("amount is not valid");
            }
        }finally {
            writeLock.unlock();
        }
    }

    public void withdraw(BigDecimal amount){
        try{
            writeLock.lock();
            if(amount.doubleValue() > 0 && amount.compareTo(this.balance) < 0){
                this.balance = this.balance.subtract(amount);
            }else{
                throw new IllegalArgumentException("Invalid Balance");
            }
        }finally {
            writeLock.unlock();
        }
    }

}

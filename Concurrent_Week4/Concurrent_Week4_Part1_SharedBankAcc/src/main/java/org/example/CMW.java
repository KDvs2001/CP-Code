package org.example;

import java.math.BigDecimal;

public class CMW implements Runnable{
    private BankAccount bankAccount;

    public CMW(BankAccount bankAccount){
        this.bankAccount = bankAccount;
    }
    @Override
    public void run(){
        bankAccount.deposit(BigDecimal.valueOf(25000.00));
    }
}

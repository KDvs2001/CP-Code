package org.example;

import java.math.BigDecimal;

public class HBH implements Runnable{
    private BankAccount bankAccount;

    public HBH(BankAccount bankAccount){
        this.bankAccount = bankAccount;
    }
    @Override
    public void run(){
        bankAccount.withdraw(BigDecimal.valueOf(20000));
    }
}

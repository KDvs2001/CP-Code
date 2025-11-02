package org.example;

import java.math.BigDecimal;

public class BankAccount {

    private String AcctName;
    private BigDecimal balance;

    public BankAccount(String acc , BigDecimal bal)
    {
        this.AcctName = acc;
        this.balance = bal;

    }

    public String getAcctName()
    {
        return this.AcctName;
    }

    public synchronized BigDecimal getBalance()
    {
        return this.balance;
    }

    public void setAcctName(String acc)
    {
        this.AcctName = acc;
    }

    public synchronized void withDraw(BigDecimal amount)
    {
        if(amount.doubleValue() < 0)
        {
            System.out.println("Amount should be in positives");
        }
        else if(balance.compareTo(amount) < 0)
        {
            System.out.println("Not sufficient Amount");
        }  else
        {
           this.balance.subtract(amount);
           System.out.println(Thread.currentThread().getName() + "  Withdraws " + getBalance());

        }

    }


    public synchronized void deposit(BigDecimal amount)
    {
        if(amount.doubleValue() > 0)
        {
            this.balance.add(amount);
            System.out.println(Thread.currentThread().getName() + " Deposits " + getBalance());
        }
    }


}

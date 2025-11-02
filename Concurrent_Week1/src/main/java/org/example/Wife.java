package org.example;

import java.math.BigDecimal;

public class Wife implements  Runnable{

    private BankAccount account;

    public Wife(BankAccount b1)
    {
        this.account = b1;
    }

    @Override
    public void run()
    {

        for(int i=0;i<10;i++)
        {
            account.deposit(new BigDecimal(25000.00));

            try
            {
                Thread.sleep(300);
            }catch (Exception e)
            {
                e.printStackTrace();
            }

        }
    }
}

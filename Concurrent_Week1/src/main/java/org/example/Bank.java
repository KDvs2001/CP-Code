package org.example;

import java.math.BigDecimal;

public class Bank {

    public static  void main(String[] args)
    {
        BankAccount b1 = new BankAccount("ACC-001", new BigDecimal(25000.00)); // b1 is a shared resource

        Runnable r1 = new Wife(b1);
        Runnable r2 = new Husband(b1);

        Thread wifeThread = new Thread(r1, "Wife");
        Thread husThread = new Thread(r2, "Husband");

        wifeThread.start();
        husThread.start();


    }
}

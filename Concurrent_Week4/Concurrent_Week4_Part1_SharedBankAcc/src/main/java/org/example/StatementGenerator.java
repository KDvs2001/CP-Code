package org.example;

public class StatementGenerator implements Runnable{
    private BankAccount bankAccount;

    public StatementGenerator(BankAccount bankAccount){
        this.bankAccount = bankAccount;
    }
    @Override
    public void run(){
        System.out.println( " Balance of "+ bankAccount.getAcctNumber()+" Account is "+ bankAccount.getBalance());
    }
}

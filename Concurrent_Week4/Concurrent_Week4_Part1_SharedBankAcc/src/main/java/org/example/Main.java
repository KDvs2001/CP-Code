package org.example;
import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) throws InterruptedException  {
        BankAccount bankAccount = new BankAccount(BigDecimal.valueOf(25000), "ACC-01");
        Runnable statementGenerate = new StatementGenerator(bankAccount);
        Thread statementGenerateThread = new Thread(statementGenerate , "Statement Thread");
        statementGenerateThread.start();
        // The thread which calls the join() goes into WAITING state until
        // thread on which join() called completes the execution. (Otherwise the thread has to died out)
        // Q: - Which thread calls the join() ?
        // A: - main thread
        // main thread calls the join() as a result main thread will go into the WAITING state.
        // until the statementGenerateThread completes the execution.
        statementGenerateThread.join();

        Thread cmw = new Thread(new CMW(bankAccount), "Career Minded Wife Thread");
        System.out.println("The career minded wife is alive " + cmw.isAlive());
        // cmw thread enters the NEW state.
        System.out.println("The current state of the Career Minded wife is " + cmw.getState());
        cmw.start();
        System.out.println("The career minded wife is alive after calling start() " + cmw.isAlive());
        System.out.println("The current state of the Career Minded wife after calling the start() " + cmw.getState());
        cmw.join(); // The main thread goes into the WAITING state until cmw thread is running.
        System.out.println("The current state of the Career Minded wife after calling the join() " + cmw.getState());
        System.out.println("The career minded wife is alive after calling join() " + cmw.isAlive());

        Thread statementGenerateThread2 = new Thread(statementGenerate , "Statement Thread 2");
        statementGenerateThread2.start();
        statementGenerateThread2.join();

        Thread hbh = new Thread(new HBH(bankAccount), "House Based Husband Thread");
        hbh.start();
        hbh.join();

        Thread statementGenerateThread3 = new Thread(statementGenerate , "Statement Thread 3");
        statementGenerateThread3.start();
        statementGenerateThread3.join();

    }
}
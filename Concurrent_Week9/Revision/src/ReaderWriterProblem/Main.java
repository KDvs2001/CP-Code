package ReaderWriterProblem;

public class Main {
    static void main() throws InterruptedException {
        BankAccount bankAccount = new BankAccount("Acct1", 5000);
        Thread readerThread = new Thread(new Reader(bankAccount), "Reader Thread");
        Thread depositWriterThread = new Thread(new DepositWriter(bankAccount), "Deposit Writer Thread");
        Thread withdrawWriterThread = new Thread(new WithdrawWriter(bankAccount), "Withdraw Writer Thread");

        readerThread.start();
        depositWriterThread.start();
        withdrawWriterThread.start();




    }
}

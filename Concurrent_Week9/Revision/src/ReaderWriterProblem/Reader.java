package ReaderWriterProblem;

public class Reader implements Runnable {
    private BankAccount bankAccount;

    public Reader(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Override
    public void run() {
        System.out.println("Balance is " + this.bankAccount.getBalance());
    }
}

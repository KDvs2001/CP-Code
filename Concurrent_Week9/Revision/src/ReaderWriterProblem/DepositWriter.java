package ReaderWriterProblem;

public class DepositWriter implements Runnable{
    private BankAccount bankAccount;
    public DepositWriter(BankAccount bankAccount){
        this.bankAccount = bankAccount;
    }
    @Override
    public void run(){
        this.bankAccount.deposit(1000);
        System.out.println("Deposited 1000. New Balance is: " + this.bankAccount.getBalance());
    }
}

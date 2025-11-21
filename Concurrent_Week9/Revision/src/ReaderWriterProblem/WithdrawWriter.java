package ReaderWriterProblem;

public class WithdrawWriter implements Runnable{
    private BankAccount bankAccount;
    public WithdrawWriter(BankAccount bankAccount){
        this.bankAccount = bankAccount;
    }
    @Override
    public void run(){
        this.bankAccount.withdraw(500);
        System.out.println("Withdraw 500. New Balance is: " + this.bankAccount.getBalance());

    }
}
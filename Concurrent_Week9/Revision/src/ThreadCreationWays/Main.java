import ThreadCreationWays.RunnableImplementation;
import ThreadCreationWays.ThreadImplementat;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public static void main(String[] args) throws InterruptedException {
    //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
    // to see how IntelliJ IDEA suggests fixing it.
    Thread t1 = new ThreadImplementat("Thread 01"); // NEW state
    t1.start(); // RUNNABLE state

    Runnable r1 = new RunnableImplementation();
    Thread t2 = new Thread(r1 , "Runnable Thread - "); // NEW state
    t2.start(); // RUNNABLE state

    t1.join(); // The MAIN thread calls the join() method on t1 .
    // Main will goes into WAITING state until the t1 completes the execution.

}

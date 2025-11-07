package Task2;

public class Barista implements Runnable {
    private final Cafe cafe;

    public Barista(Cafe cafe) {
        this.cafe = cafe;
    }

    @Override
    public void run() {
        for(int i=0;i<10;i++){
            cafe.make();
            System.out.println(Thread.currentThread().getName() + " produced an item and total count is "+ cafe.getCurrentStock());
            try{
                Thread.sleep(200);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

    }
}

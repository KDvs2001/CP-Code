package Task2;

public class Customer implements Runnable {
    private final Cafe cafe;

    public Customer(Cafe cafe) {
        this.cafe = cafe;
    }

    @Override
    public void run() {
        for(int i=0;i<5;i++){
            if(cafe.getCurrentStock() !=0){
                cafe.sell();
                System.out.println(Thread.currentThread().getName() + " consumed an item and the total count is "+ cafe.getCurrentStock());
            }
            try{
                Thread.sleep(200);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }


    }
}

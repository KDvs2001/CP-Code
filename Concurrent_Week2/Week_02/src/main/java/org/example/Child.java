package org.example;

public class Child implements  Runnable{
    private Plate plate;

    public Child(Plate plate)
    {
        this.plate = plate;
    }

    @Override
    public void run()
    {
        for(int i=0;i<10;i++)
        {
            String food = this.plate.getFood();
            System.out.println(Thread.currentThread().getName() + " Gets food" + food);
        }
    }
}

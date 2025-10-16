package org.example;
public class Singleton {
    private volatile static Singleton singleton;
    private Singleton() {

    }
    public  static Singleton getSingleton() {
        if(singleton == null){
            synchronized (Singleton.class){
                if(singleton == null) {
                    singleton = new Singleton();
                }
            }
        }


        return singleton;
    }

    public void doSomething(){
        System.out.println("Something");
    }
}

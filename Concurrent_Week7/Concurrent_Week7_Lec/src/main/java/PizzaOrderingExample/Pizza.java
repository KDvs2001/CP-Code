package PizzaOrderingExample;

public class Pizza {
    private String name;
    private long size;
    private long makingTime;

    public Pizza(String name, long size, long makingTime) {
        this.name = name;
        this.size = size;
        this.makingTime = makingTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public long getMakingTime() {
        return makingTime;
    }

    public void setMakingTime(long makingTime) {
        this.makingTime = makingTime;
    }
}

package CalculateAverageofStudents;

public class Student {
    private String studID;
    private String name;
    private int mark1;
    private int mark2;
    private int mark3;
    private int[] marks = new int[3];

    public Student(String studID, String name, int mark1,int mark2,int mark3) {
        this.studID = studID;
        this.name = name;
        this.mark1 = mark1;
        this.mark2 = mark2;
        this.mark3 = mark3;
        marks[0] = mark1;
        marks[1] = mark2;
        marks[2] = mark3;

    }

    public String getStudID() {
        return studID;
    }

    public void setStudID(String studID) {
        this.studID = studID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int[] getMarks() {
        return marks;
    }



}

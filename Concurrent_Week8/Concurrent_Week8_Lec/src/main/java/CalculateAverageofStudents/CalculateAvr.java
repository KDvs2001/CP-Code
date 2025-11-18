package CalculateAverageofStudents;

import java.util.concurrent.Callable;

public class CalculateAvr implements Callable<Double> {
    private Student student;

    public CalculateAvr(Student student) {
        this.student = student;
    }

    @Override
    public Double call() throws Exception {
        int totalMarks=0;
        double avrMark;
        int[] marks = student.getMarks();
        for(int i: marks){
            totalMarks+=i;
        }
        avrMark = totalMarks/marks.length;
        System.out.println("Average "+ avrMark+ " of "+ Thread.currentThread().getName());
        return avrMark;

    }
}

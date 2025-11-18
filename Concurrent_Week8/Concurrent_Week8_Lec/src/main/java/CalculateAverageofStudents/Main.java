package CalculateAverageofStudents;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {


    public static void main(String[] args) throws Exception{
        Student student1 = new Student("ST1","Student1",25,60,54 );
        Student student2 = new Student("ST2","Student2", 56, 40, 67);
        Student student3 = new Student("ST3","Student3", 43,70,34);
        Student student4 = new Student("ST4","Student4", 56,59,34);
        Student student5 = new Student("ST5","Student5",45,56,23);
        List<Student> studentList = new ArrayList<>();

        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
        studentList.add(student4);
        studentList.add(student5);

        List<Callable<Double>> callableList = new ArrayList<>(5);

        for(Student student : studentList){
            callableList.add(new CalculateAvr(student));
        }


        ExecutorService executorService = Executors.newFixedThreadPool(3);
        // Future<Double> average= executorService.submit(new CalculateAvr(student));
        // List<Future<Double>> future = executorService.invokeAll(callableList);
         //List<Future<Double>> future = executorService.invokeAny(callableList);



//      System.out.println("Student: "+ student.getName() + " average is "+ average.get());

        executorService.shutdown();
    }






}

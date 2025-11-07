package TotalSalaryCalculation;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NewFixedThreadPool {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        List<Employee> employeeList = new ArrayList<>();

        Employee employee1 = new Employee("Employee A", "ID-001", 3000, 20);
        Employee employee2 = new Employee("Employee B", "ID-002", 2000, 15);
        Employee employee3 = new Employee("Employee C", "ID-003", 2500, 5);
        Employee employee4 = new Employee("Employee D", "ID-004", 1500, 10);
        Employee employee5 = new Employee("Employee E", "ID-005", 1000, 25);

        employeeList.add(employee1);
        employeeList.add(employee2);
        employeeList.add(employee3);
        employeeList.add(employee4);
        employeeList.add(employee5);

        for(Employee e: employeeList){
            executorService.submit(new CalculateSalary(e));
        }

        executorService.shutdown();





    }
}

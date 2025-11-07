package TotalSalaryCalculation;

public class CalculateSalary implements Runnable{
    private Employee employee;
    private int totalSalary ;

    public CalculateSalary(Employee employee) {
        this.employee = employee;
    }

    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName() + " calculates salary of Employee " + employee.getEmployeeName());
        calculateSalary(employee);
    }

    public void calculateSalary(Employee employee){
        this.totalSalary += employee.getBaseSalary() * employee.getNumOfDays();
    }

}

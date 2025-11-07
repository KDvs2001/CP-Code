package TotalSalaryCalculation;

public class Employee {
    private String employeeName;
    private String employeeID;
    private int baseSalary;
    private int numOfDays;

    public Employee(String employeeName, String employeeID, int baseSalary, int numOfDays) {
        this.employeeName = employeeName;
        this.employeeID = employeeID;
        this.baseSalary = baseSalary;
        this.numOfDays = numOfDays;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public int getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(int baseSalary) {
        this.baseSalary = baseSalary;
    }

    public int getNumOfDays() {
        return numOfDays;
    }

    public void setNumOfDays(int numOfDays) {
        this.numOfDays = numOfDays;
    }
}

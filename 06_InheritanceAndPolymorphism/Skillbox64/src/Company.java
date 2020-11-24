import java.util.*;
public class Company {

    String rub = "\u0584";
    long totalIncome = 0;

    Employee employee;
    Company company;

    public List<Employee> employeeList = new ArrayList<>();

    public void hire(Employee employee) {
        employee.setCompany(this);
        employeeList.add(employee);
    }

    public void hireAll(List<Employee> employees) {
        employeeList.addAll(employees);
    }

    public void fire(int percentOfEmployees) {
        for (int a = 0; a <= employeeList.size() - 1; a++) {
            employeeList.remove(employeeList.size() * (percentOfEmployees / 100));
        }
        System.out.println("Столько % сотрудников было уволено : " + percentOfEmployees + "%");
    }

    public void getIncome() {
        for (int a = 0; a <= employeeList.size() - 1; a++) {
            totalIncome += employeeList.get(a).getIncome();
        }
        System.out.println("Общий доход компании " + totalIncome + rub);
    }

    public void setTotalIncome(long totalIncome) {
        this.totalIncome = totalIncome;
    }

    long getTotalIncome() {
        return totalIncome;
    }

    public ArrayList<Employee> getTopSalaryStaff(int count) {
        Collections.sort(employeeList);
        ArrayList<Employee> salaryList = new ArrayList<>();
        for (int a = 0 ; a <= count ; a ++){
            employeeList.addAll(salaryList);
        }
        for (Employee employee : employeeList){
            System.out.println(salaryList);
        }

        return salaryList;
    }

    public ArrayList<Employee> getLowestSalaryStaff(int count) {
        return null;
    }

    @Override
    public String toString() {
        return "Company{" +
                //"Manager=" + Manager +
                "EmployeeList=" + employeeList +
                //"companyIncome=" + income +
                ", EmployeeList=" + employeeList +
                '}';
    }
}
import java.util.*;

public class Company {

    //Manager manager = new Manager();

    public List<Employee> employeeList = new ArrayList<>();

    public void hire(Employee employee) {
        employee.setCompany(this);
        employeeList.add(employee);
    }

    public void hireAll(List<Employee> employees) {
        employeeList.addAll(employees);
    }

    public void fire(int percentOfEmployees) {
        for (int a = 0; a <= employeeList.size() -1; a++) {
            employeeList.remove(employeeList.size() * percentOfEmployees /100);
        }
        System.out.println("Столько % сотрудников было уволено : " + percentOfEmployees + "%");
    }

    public void getIncome() {
        double totalIncome = 0;
        for (int a = 0; a <= employeeList.size() - 1; a++) {
            totalIncome += employeeList.get(a).getIncome();
        }
        System.out.println("Общий доход компании " + totalIncome + " рублей");
    }

    public void checkSize() {
        System.out.println("Кол-во сотрудников " + employeeList.size());
    }

    public ArrayList<Employee> getTopSalaryStaff(int count) {
        return null;
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
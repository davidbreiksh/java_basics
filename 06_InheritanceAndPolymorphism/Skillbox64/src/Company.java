import java.util.*;

public class Company {

    Manager manager;

    List<Employee> employeeList = new ArrayList<>();

    double companyIncome = (int) (Math.random() * (140000 - 115000) + 115000);
    public Object Manager;

    public void hire(Employee employee) {
        employee.setCompany(this);
        employeeList.add(employee);
    }

    public void hireAll(Employee employee, int employeeAmount) {
        for (int a = 0; a <= employeeAmount - 1; a++) {
            employeeList.add(employee);
        }
        System.out.println(employeeList.size()+ " Колличесиво сотрудников");
    }

    public void fire(Company company, int percentOfEmployees) {
        Random random = new Random();
        for (int a = 0; a <= employeeList.size() * percentOfEmployees / 100; a++) {
            Employee firedEmployee = employeeList.get(random.nextInt(employeeList.size()));
            employeeList.remove(firedEmployee);
        }
        System.out.println(employeeList.size() + " Колличесиво сотрудников");
    }

    public void getIncome() {
        int managersCount = Collections.frequency(employeeList, manager);
        for (int a = 0; a <= managersCount; a++) {
            companyIncome += companyIncome;
            System.out.println("Общий доход компании " + companyIncome + " рублей");
        }
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
                "Manager=" + Manager +
                "EmployeeList=" + employeeList +
                //"companyIncome=" + income +
                ", EmployeeList=" + employeeList +
                '}';
    }
}
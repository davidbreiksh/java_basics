import java.util.*;

public class Company {

    public List<Employee> employeeList = new ArrayList<>();

    Employee employee;

    public void hire(Employee employee) {
        employee.setCompany(this);
        employeeList.add(employee);
    }

    public void hireAll(List<Employee> employees) {
        for (Employee employee : employees) {
            hire(employee);
        }
        System.out.println("Колличество сотрудников " + employeeList.size());
    }

    public void fire(int amountOfFiredEmployee) {
        Random random = new Random();
        if (amountOfFiredEmployee > 0 && amountOfFiredEmployee < employeeList.size()) {
            for (int a = 0; a < amountOfFiredEmployee; a++) {
                employee = employeeList.get(random.nextInt(employeeList.size()));
                employeeList.remove(employee);
            }
            System.out.println("Было уволено сотрудников " + amountOfFiredEmployee);
            System.out.println("Колличество сотрудников " + employeeList.size());
        } else {
            System.out.println("Неверное колличесвто сотурдников");
        }
    }

    public double getIncome() {
        double income = 0D;
        for (Employee value : employeeList) {
            income += value.getIncome();
        }
        return income;
    }

    public List<Employee> getTopSalaryStaff(int count) {
        Comparator<Employee> comparator = new EmployeeComparator();
        employeeList.sort(comparator.reversed());
        if (count > employeeList.size() || count <= 0) {
            return employeeList;
        }
        return employeeList.subList(0, count);
    }

    public List<Employee> getLowestSalaryStaff(int count) {
        Comparator<Employee> comparator = new EmployeeComparator();
        employeeList.sort(comparator);
        if (count > employeeList.size() || count <= 0){
            return employeeList;
        }
        return employeeList.subList(0 , count);
    }

    @Override
    public String toString() {
        return "Company{" +
                "EmployeeList=" + employeeList +
                '}';
    }
}
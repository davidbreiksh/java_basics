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

    public ArrayList<Employee> getTopSalaryStaff(int count) {
        Comparator comparator = new ObjectsComparator();
        Collections.sort(employeeList, comparator);
        ArrayList<Employee> sorted = new ArrayList<>(employeeList.subList(0, count));
        return sorted;
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
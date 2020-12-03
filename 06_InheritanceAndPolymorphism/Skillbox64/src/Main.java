import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Company company = new Company();
        List<Employee> multipleEmployees = new ArrayList<>();

        for (int a = 0; a < 15; a++) {
            multipleEmployees.add(new Manager());
        }
        for (int a = 0; a < 40; a++) {
            multipleEmployees.add(new Operator());
        }
        for (int a = 0; a < 5; a++) {
            multipleEmployees.add(new TopManager());
        }
        company.hireAll(multipleEmployees);

        List<Employee> employeeList = company.getTopSalaryStaff(20);
        System.out.println("Топ зарплат " +  employeeList);
        List<Employee> employeeList1 = company.getLowestSalaryStaff(20);
        System.out.println("Топ низких зарплат " + employeeList1);
    }
}
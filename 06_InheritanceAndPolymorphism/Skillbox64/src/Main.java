import org.w3c.dom.ls.LSOutput;

import java.text.CollationElementIterator;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Company company = new Company();
        ArrayList<Employee> multipleEmployees = new ArrayList<>();

        for (int a = 0; a < 4; a++) {
            multipleEmployees.add(new Manager());
        }
        for (int a = 0; a < 1; a++) {
            multipleEmployees.add(new Operator());
        }
        for (int a = 0; a < 1; a++) {
            multipleEmployees.add(new TopManager());
        }
        company.hireAll(multipleEmployees);

        for (Employee employee : multipleEmployees) {
            employee.getMonthSalary();
        }
        company.fire(3);
    }
}
import java.text.CollationElementIterator;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Company company = new Company();
        ArrayList<Employee> multipleEmployees = new ArrayList<>();

        for (int a = 0; a < 5; a++) {
            multipleEmployees.add(new Manager());
        }
        for (int a = 0; a < 5; a++) {
            multipleEmployees.add(new Operator());
        }
        for (int a = 0; a < 3; a++) {
            multipleEmployees.add(new TopManager());
        }
        company.hireAll(multipleEmployees);

    }
}
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Company company = new Company();
        ArrayList<Employee> multipleEmployees = new ArrayList<>();

        for (int a = 0; a < 3; a++) {
            multipleEmployees.add(new Manager());
        }
        for (int a = 0 ; a < 3 ; a ++){
            multipleEmployees.add(new Operator());
        }
        company.hireAll(multipleEmployees);
        company.getIncome();
        company.checkSize();

        company.fire(50);
        company.checkSize();
    }
}
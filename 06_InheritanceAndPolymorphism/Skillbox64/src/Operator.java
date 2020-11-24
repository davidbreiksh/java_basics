public class Operator implements Employee, Comparable<Employee> {

    Operator operator;

    int OPERATOR_SALARY = 50000;
    String rub = "\u0584";

    Operator() {
        getMonthSalary();
    }

    @Override
    public double getMonthSalary() {
        System.out.println("Зарплата оператора " + OPERATOR_SALARY + rub);
        return OPERATOR_SALARY;
    }

    @Override
    public void setCompany(Company company) {

    }

    @Override
    public int compareTo(Employee employee) {
        return Double.compare(getMonthSalary(), employee.getMonthSalary());
    }

    @Override
    public String toString() {
        return "Operator";
    }

}

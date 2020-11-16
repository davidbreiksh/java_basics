public class Operator implements Employee {

    final int OPERATOR_SALARY = 50000;

    @Override
    public double getMonthSalary() {
        return OPERATOR_SALARY;
    }

    @Override
    public void setCompany(Company company) {

    }

    @Override
    public String toString() {
        return "Operator";
    }
}

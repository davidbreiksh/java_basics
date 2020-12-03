public class Operator implements Employee {

    double OPERATOR_SALARY = 50000;
    Company company;

    Operator() {
    }

    @Override
    public double getMonthSalary() {
        return OPERATOR_SALARY;
    }

    @Override
    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "Operator " + getMonthSalary();
    }
}
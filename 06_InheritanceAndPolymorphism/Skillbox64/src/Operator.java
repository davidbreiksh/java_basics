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
    public int compareTo(Employee employee) {
        return Double.compare(this.getMonthSalary(), employee.getMonthSalary());
    }

    @Override
    public String toString() {
        return "Operator " + getMonthSalary();
    }
}
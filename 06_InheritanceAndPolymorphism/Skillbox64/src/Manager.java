public class Manager implements Employee {

    private Company company;

    int companyIncome = (int) (Math.random() * (140000 - 115000) + 115000);
    double MANAGER_SALARY = 100000;
    final double BONUS_PERCENT = 0.05;

    Manager() {
    }

    @Override
    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public double getMonthSalary() {
        MANAGER_SALARY = MANAGER_SALARY + (companyIncome * BONUS_PERCENT);
        return Math.ceil(MANAGER_SALARY);
    }

    @Override
    public double getIncome() {
        return companyIncome;
    }

    @Override
    public int compareTo(Employee employee) {
       return Double.compare(this.getMonthSalary(), employee.getMonthSalary());
    }

    @Override
    public String toString() {
        return "Manager " + getMonthSalary();
    }
}
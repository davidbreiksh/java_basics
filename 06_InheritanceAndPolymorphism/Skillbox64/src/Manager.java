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
        return Math.ceil(MANAGER_SALARY + (companyIncome * BONUS_PERCENT));
    }

    @Override
    public double getIncome() {
        return companyIncome;
    }

    @Override
    public String toString() {
        return "Manager " + getMonthSalary();
    }
}
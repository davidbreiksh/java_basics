public class TopManager implements Employee{

    private Company company = new Company();
    final int BONUS = 10000000;
    double TOP_MANAGER_SALARY = 150000;
    double bonusPercent = 2.5;
    TopManager topManager;

    TopManager() {
        //getMonthSalary();
    }

    @Override
    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public double getMonthSalary() {
        double bonus = 0;
        if (company.getIncome() > BONUS) {
            bonus = bonusPercent;
            System.out.println("Зарплата топ менеджера " + TOP_MANAGER_SALARY * bonus + " рублей");
            return TOP_MANAGER_SALARY * bonus;
        }
        System.out.println("Зарплата топ менеджера " + TOP_MANAGER_SALARY + " рублей");
        return TOP_MANAGER_SALARY;

    }

    @Override
    public int compareTo(Employee employee) {
        return Double.compare(this.getMonthSalary(), employee.getMonthSalary());
    }

    @Override
    public String toString() {
        return "TopManager" + getMonthSalary();
    }
}
public class TopManager implements Employee, Comparable<Employee> {

    private Company company ;
    final int BONUS = 10000000;
    double TOP_MANAGER_SALARY = 150000;
    double bonusPercent = 2.5;
    String rub = "\u0584";
    TopManager topManager;

    TopManager() {
        getMonthSalary();
    }

    @Override
    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public double getMonthSalary() {
        if (company.getTotalIncome() > BONUS){
            System.out.println("Зарплата топ менеджера " + TOP_MANAGER_SALARY * bonusPercent + rub);
        }
        System.out.println("Зарплата топ менеджера " + TOP_MANAGER_SALARY + rub);
        return TOP_MANAGER_SALARY;
    }

    @Override
    public int compareTo(Employee employee) {
        return Double.compare(topManager.getMonthSalary(), employee.getMonthSalary());
    }

    @Override
    public String toString() {
        return "TopManager" + getMonthSalary();
    }
}
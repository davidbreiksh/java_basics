import java.text.DecimalFormat;
import java.util.concurrent.atomic.AtomicMarkableReference;

public class TopManager implements Employee {

    private Company company = new Company();
    final int BONUS = 10000000;
    double TOP_MANAGER_SALARY = 150000;
    double bonusPercent = 2.5;

    TopManager() {
        getMonthSalary();
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
            return Math.ceil(TOP_MANAGER_SALARY * bonus);
        }
        return Math.ceil(TOP_MANAGER_SALARY);
    }

    @Override
    public String toString() {
        return "TopManager " + getMonthSalary();
    }
}
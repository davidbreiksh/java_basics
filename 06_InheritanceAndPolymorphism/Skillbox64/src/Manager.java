import org.w3c.dom.ls.LSOutput;

import java.util.Collections;

public class Manager implements Employee {

    int totalIncome = 0;

    int companyIncome = (int) (Math.random() * (140000 - 115000) + 115000);
    double MANAGER_SALARY = 100000;
    final double BONUS_PERCENT = 0.05;

    //Manager() {
        //getIncome();
       // getMonthSalary();
        //System.out.println();
   // }

    @Override
    public void setCompany(Company company) {
    }

    @Override
    public double getMonthSalary() {
        MANAGER_SALARY = MANAGER_SALARY + (companyIncome * BONUS_PERCENT);
        System.out.println("Зарплата менеджера " + MANAGER_SALARY + " рублей");
        return MANAGER_SALARY;
    }

    @Override
    public double getIncome() {
        System.out.println("Менеджер заработал для компании " + companyIncome + " рублей");
        return companyIncome;
    }

    @Override
    public String toString() {
        return "Manager";
    }
}
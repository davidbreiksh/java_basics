public class Manager implements Employee {

    Company company;


    double companyIncome;
    double MANAGER_SALARY = 100000;
    final double BONUS_PERCENT = 0.05;

    Manager(){
       companyIncome = (int) (Math.random() * (140000 - 115000) + 115000);
       System.out.println("Доход для компании от менеджера " + companyIncome + " рублей");
       getMonthSalary();
    }

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
    public String toString() {
        return "Manager";
    }
}
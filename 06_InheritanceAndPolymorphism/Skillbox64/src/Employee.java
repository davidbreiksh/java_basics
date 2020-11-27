public interface Employee extends Comparable <Employee>{

    void setCompany(Company company);
    double getMonthSalary();
    default double getIncome() {
        return 0;
    }
}
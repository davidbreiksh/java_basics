public class Main {
    public static void main(String[] args) {
        Company company = new Company();
        company.hireAll(new Manager() , 2);
        company.getIncome();
    }
}
import com.opencsv.bean.CsvBindByName;

public class IncomeAndExpense {

    @CsvBindByName(column = "Приход")
    private double income;

    @CsvBindByName(column = "Расход")
    private double expense;

    public double getExpense() {
        return expense;
    }

    public void setExpense(double expense) {
        this.expense = expense;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }
}
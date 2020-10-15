package BankAccount;

public class PercentageAccount extends MainAccount {

    public PercentageAccount(double moneyAmount) {
        super(moneyAmount);
    }

    @Override
    public double withDrawMoney(double withdraw) {
        final double PERCENTAGEWITHDRAW = (withdraw / 100) * 1;
        return super.withDrawMoney(PERCENTAGEWITHDRAW + withdraw);
    }
}

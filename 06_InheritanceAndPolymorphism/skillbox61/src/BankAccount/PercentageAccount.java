package BankAccount;

public class PercentageAccount extends MainAccount{

    public PercentageAccount(double moneyAmount) {
        super(moneyAmount);
    }
    public double percentageOfWithdraw;

    public double withDrawMoney(double withdraw){
        percentageOfWithdraw = (withdraw / 100) * 1;
        return super.withDrawMoney(percentageOfWithdraw + withdraw);
    }
}

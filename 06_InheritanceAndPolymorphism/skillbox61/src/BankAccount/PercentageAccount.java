package BankAccount;

public class PercentageAccount extends MainAccount {

    final double PERCENTAGE_OF_WITHDRAW = 0.01;

    public PercentageAccount(double moneyAmount) {
        super(moneyAmount);
    }

    @Override
    public double withDrawMoney(double withdraw) {
        System.out.println("Commission is 1% : " + withdraw * PERCENTAGE_OF_WITHDRAW + " USD");
        return super.withDrawMoney(withdraw + (withdraw * PERCENTAGE_OF_WITHDRAW));
    }
}
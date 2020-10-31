package BankAccount;

public class PercentageAccount extends MainAccount {

    private final double PERCENTAGE_OF_WITHDRAW = 0.01;

    public PercentageAccount(double moneyAmount) {
        super(moneyAmount);
    }

    @Override
    public boolean withDrawMoney(double withdraw) {
        if (withdraw + (withdraw * PERCENTAGE_OF_WITHDRAW) > moneyAmount) {
            System.out.println("Not enough money (percentage account)");
            return false;
        }
        System.out.println(super.withDrawMoney(withdraw + (withdraw * PERCENTAGE_OF_WITHDRAW)));
        System.out.println("Commission is 1% : " + withdraw * PERCENTAGE_OF_WITHDRAW + " USD");
        moneyAmount = moneyAmount - (withdraw + (withdraw * PERCENTAGE_OF_WITHDRAW));
        return true;
    }
}
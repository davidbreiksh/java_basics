package BankAccount;

public class PercentageAccount extends MainAccount {

    final double PERCENTAGE_OF_WITHDRAW = 0.01;

    public PercentageAccount(double moneyAmount) {
        super(moneyAmount);
    }

    @Override
    public boolean withDrawMoney(double withdraw) {
        if (withdraw + (withdraw * PERCENTAGE_OF_WITHDRAW) > moneyAmount){
            System.out.println("Not enough money");
            return false;
        }
        System.out.println("Commission is 1% : " + withdraw * PERCENTAGE_OF_WITHDRAW + " USD");
        System.out.println(super.withDrawMoney(withdraw + (withdraw * PERCENTAGE_OF_WITHDRAW)));
        return true;
    }
}
package BankAccount;

import java.time.LocalDate;

public class DepositAccount extends MainAccount {
    LocalDate depositDate;
    final int MONTH_DELAY_WITHDRAW = 1;


    public DepositAccount(double moneyAmount) {
        super(moneyAmount);
    }

    @Override
    public double checkMoney() {
        return super.checkMoney();
    }

    @Override
    public double depositMoney(double deposit) {
        depositDate = LocalDate.now();
        return super.depositMoney(deposit);

    }

    @Override
    public boolean withDrawMoney(double withdraw) {
        if (LocalDate.now().isBefore(depositDate.plusMonths(MONTH_DELAY_WITHDRAW))) {
            System.out.println("Not possible");
            return false;
        }
        System.out.println(super.withDrawMoney(withdraw));
        return true;
    }
}

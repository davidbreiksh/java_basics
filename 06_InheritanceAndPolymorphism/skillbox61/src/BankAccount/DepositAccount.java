package BankAccount;

import java.time.LocalDate;

public class DepositAccount extends MainAccount {
    LocalDate depositDate;
    LocalDate possibleWithdrawDraw;


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
        possibleWithdrawDraw = depositDate.plusMonths(1);
        return super.depositMoney(deposit);

    }
    @Override
    public double withDrawMoney(double withdraw) {
        LocalDate actualDate = LocalDate.now();
        if (actualDate.isBefore(possibleWithdrawDraw)) {
            System.out.println("Not possible");
            return super.moneyAmount;
        } else return super.withDrawMoney(withdraw);
    }
}

package BankAccount;

import java.time.LocalDate;

public class DepositAccount extends MainAccount {

    public DepositAccount(double moneyAmount) {
        super(moneyAmount);
    }

    LocalDate date = localDate.plusMonths(1);

    public double checkMoney() {
        return super.checkMoney();
    }

    public double depositMoney(double deposit) {
        return super.depositMoney(deposit);

    }

    public double withDrawMoney(double withdraw) {
        checkDate();
        return super.withDrawMoney(withdraw);
    }
    public void checkDate(){
        if (date.isBefore(localDate)){
            System.out.println("Sorry operation failed , you must wait at least 1 month since your last deposit");
        }
    }
}
package BankAccount;

import java.time.LocalDate;

public class MainAccount {
    protected double moneyAmount;
    private LocalDate todaysDate = LocalDate.now();

    public MainAccount(double moneyAmount) {
        this.moneyAmount = moneyAmount;
    }

    public void setMoneyAmount(double moneyAmount) {
        this.moneyAmount = moneyAmount;
    }

    public double getMoneyAmount() {
        return moneyAmount;
    }

    public double checkMoney() {
        System.out.println("Your Balance is : " + moneyAmount + " USD");
        return moneyAmount;
    }

    public boolean withDrawMoney(double withdraw) {
        System.out.println("How much money would you like to withdraw ? " + withdraw + " USD");
        if (withdraw > moneyAmount) {
            System.out.println("Sorry , your balance is too low");
            return false;
        }
        System.out.println("Your balance is : " + moneyAmount + " USD");
        moneyAmount = moneyAmount - withdraw;
        return true;

    }

    public double depositMoney(double deposit) {
        System.out.println("Your deposit is " + deposit + " USD" + " , Operation date is : " + todaysDate);
        moneyAmount = deposit + moneyAmount;
        System.out.println("Total amount is : " + moneyAmount + " USD");
        return moneyAmount;
    }

    public boolean send(MainAccount receiver, double amount) {
        if (!withDrawMoney(amount)) {
            System.out.println("Not enough money");
            return false;
        }
        receiver.depositMoney(amount);
        return true;
    }
}
package BankAccount;

import java.time.LocalDate;

public class MainAccount {
    public double moneyAmount;
    public LocalDate localDate = LocalDate.now();

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

    public double withDrawMoney(double withdraw) {
        System.out.println("How much money would you like to withdraw ? " + withdraw + " USD");
        if (withdraw > moneyAmount) {
            System.out.println("Sorry , your balance is too low");
        } else {
            double balance = moneyAmount - withdraw;
            System.out.println("Your balance is : " + balance + " USD");
        }
        return moneyAmount;
    }

    public double depositMoney(double deposit) {
        System.out.println("Your deposite is " + deposit + " USD" + " , Operation date is : " + localDate);
        moneyAmount = deposit + moneyAmount;
        System.out.println("Total amount is : " + moneyAmount + " USD");
        return moneyAmount;
    }

    public boolean send(MainAccount receiver, double amount) {
       if (amount > moneyAmount){
           return false;
       }else {
           moneyAmount = moneyAmount - amount;
           receiver.moneyAmount = receiver.moneyAmount + amount;
       }return true;
    }
}
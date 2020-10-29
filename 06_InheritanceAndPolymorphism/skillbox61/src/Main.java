import BankAccount.DepositAccount;
import BankAccount.MainAccount;
import BankAccount.PercentageAccount;

public class Main {
    public static void main(String[] args) {
        MainAccount mainAccount = new MainAccount(200.0);

        DepositAccount depositAccount = new DepositAccount(300);

        PercentageAccount percentageAccount = new PercentageAccount(500);
        depositAccount.send(percentageAccount , 100);

    }
}
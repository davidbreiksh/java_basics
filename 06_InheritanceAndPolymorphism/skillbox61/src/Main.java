import BankAccount.DepositAccount;
import BankAccount.MainAccount;
import BankAccount.PercentageAccount;

public class Main {
    public static void main(String[] args) {
        MainAccount mainAccount = new MainAccount(200.0);
       // mainAccount.checkMoney();
        //System.out.println();

        DepositAccount depositAccount = new DepositAccount(300);
        //mainAccount.send(depositAccount, 200);
        //depositAccount.checkMoney();
        //mainAccount.checkMoney();
        System.out.println();

        PercentageAccount percentageAccount = new PercentageAccount(400);
        //percentageAccount.send(depositAccount, 50);
        percentageAccount.withDrawMoney(100);
    }
}
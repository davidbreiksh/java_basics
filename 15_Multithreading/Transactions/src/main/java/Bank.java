import org.apache.log4j.Logger;

import java.util.*;

public class Bank extends Thread {

    private final int maxLimitTransaction = 50000;
    private final static Logger logger = Logger.getLogger(Bank.class.getName());


    private final Map<String, Account> accounts;
    private final Random random = new Random();

    public Bank() {
        accounts = new HashMap<>();
    }

    public synchronized boolean isFraud(String fromAccountNum, String toAccountNum, long amount)
            throws InterruptedException {
        Thread.sleep(1000);
        return random.nextBoolean();
    }

    public synchronized void transfer(String fromAccountNum, String toAccountNum, long amount) throws InterruptedException {

        Account sender;
        Account receiver;

        synchronized (fromAccountNum) {
            sender = accounts.get(fromAccountNum);
        }

        synchronized (toAccountNum) {
            receiver = accounts.get(toAccountNum);
        }

        sendMoney(receiver, sender, amount);

        if (amount > maxLimitTransaction && isFraud(fromAccountNum, toAccountNum, amount)) {
            System.out.println("Транзакция проверяется системой безопасности");

            int waitingTime = (int) (1 + Math.random() * 6000);

            receiver.blockAccount();
            sender.blockAccount();

            try {
                wait(waitingTime);

                if (waitingTime > 2000) {
                    System.out.println("Счет заблокирован");
                    accounts.remove(fromAccountNum);
                    accounts.remove(toAccountNum);

                }

            } catch (InterruptedException e) {
                logger.error("Interrupted Exception", e);
            }
        }
    }

    public void printAccounts() {
        accounts.entrySet().forEach(entry -> {
            System.out.println(entry.getKey() + " " + entry.getValue());
        });
    }

    public long getBalance(String accountNum) {
        long money = 0;
        for (Map.Entry<String, Account> entry : accounts.entrySet()) {
            if (entry.getValue().getAccNumber().equals(accountNum)) {
                money = entry.getValue().getMoney();
            }
        }
        return money;
    }

    public synchronized long getSumAllAccounts() {

        long totalSumOfAllAccounts = 0;

            for (Map.Entry<String, Account> entry : accounts.entrySet()) {
                totalSumOfAllAccounts += entry.getValue().getMoney();
            }

        return totalSumOfAllAccounts;
    }

    public void registerNewAccount(String accNumber, Account account) {
        accNumber = account.getAccNumber();
        accounts.put(accNumber, account);
    }

    public synchronized void sendMoney(Account receiver, Account sender, long amount) {

            if (amount > sender.getMoney() || amount <= 0) {
                sender.setMoney(sender.getMoney());
                System.out.println("Недостаточно средств или неверная сумма перевода");
            } else {
                sender.setMoney(sender.getMoney() - amount);
                receiver.setMoney(receiver.getMoney() + amount);
            }

    }

    public synchronized long putMoneyOnAccount(Account account, long amount) {

            if (amount <= 0) {
                account.setMoney(account.getMoney() - (amount));
                System.out.println("Неверная сумма");
            }

        return account.setMoney(account.getMoney() + amount);
    }

    public synchronized long withdrawMoney(Account account, long amount) {

            if (amount > account.getMoney() || amount <= 0) {
                account.setMoney(account.getMoney() + amount);
                System.out.println("Недостаточный баланс или неверная сумма");
            }

        return account.setMoney(account.getMoney() - amount);
    }
}
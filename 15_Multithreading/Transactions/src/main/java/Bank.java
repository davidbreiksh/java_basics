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

    protected boolean isFraud()
            throws InterruptedException {

        Thread.sleep(1000);
        return random.nextBoolean();
    }

    protected void transfer(String fromAccountNum, String toAccountNum, long amount) throws InterruptedException {

        Account sender = accounts.get(fromAccountNum);
        Account receiver = accounts.get(toAccountNum);

        Object lowSyncAcc = sender.getAccNumber().compareTo(receiver.getAccNumber()) > 0 ? sender : receiver;
        Object topSynAcc = receiver.getAccNumber().compareTo(sender.getAccNumber()) > 0 ? receiver : sender;

        synchronized (lowSyncAcc) {

            synchronized (topSynAcc) {

                if (amount > maxLimitTransaction && isFraud()) {
                    sender.setBlocked(true);
                    receiver.setBlocked(true);
                }

                if (sender.isBlocked() || receiver.isBlocked()) {
                    System.out.println("Невозможно провести операцию счет заблокирован");
                    return;
                }
                sendMoney(sender, receiver, amount);
            }
        }
    }

    protected void printAccounts() {
        accounts.forEach((key, value) -> System.out.println(key + " " + value));
    }

    protected long getBalance(String accountNum) {

        long money = 0;

        for (Map.Entry<String, Account> entry : accounts.entrySet()) {
            if (entry.getValue().getAccNumber().equals(accountNum)) {
                money = entry.getValue().getMoney();
            }
        }
        return money;
    }

    protected long getSumAllAccounts() {

        return accounts.values().stream().mapToLong(Account::getMoney).sum();
    }

    public void registerNewAccount(Account account) {
        String accNumber = account.getAccNumber();
        accounts.put(accNumber, account);
    }

    private void sendMoney(Account sender, Account receiver, long amount) {

        if (sender.getMoney() >= amount) {
            sender.withdraw(amount);
            receiver.depositMoney(amount);
        } else {
            System.out.println("Операция невозможна");
        }
    }
}
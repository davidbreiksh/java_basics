import java.lang.reflect.Field;
import java.util.*;

public class Bank extends Thread {

    private final int maxLimitTransaction = 50000;

    private final Map<String, Account> accounts;
    private final Random random = new Random();
    private final Map<String, Account> fraudAccounts = new HashMap<>();

    public Bank() {
        accounts = new HashMap<>();
    }

    public synchronized boolean isFraud(String fromAccountNum, String toAccountNum, long amount)
            throws InterruptedException {
        Thread.sleep(1000);
        return random.nextBoolean();
    }

    /**
     * TODO: реализовать метод. Метод переводит деньги между счетами. Если сумма транзакции > 50000,
     * то после совершения транзакции, она отправляется на проверку Службе Безопасности – вызывается
     * метод isFraud. Если возвращается true, то делается блокировка счетов (как – на ваше
     * усмотрение)
     */
    public synchronized void transfer(String fromAccountNum, String toAccountNum, long amount) throws InterruptedException {

        Account receiver = accounts.get(toAccountNum);
        Account sender = accounts.get(fromAccountNum);

        sendMoney(receiver, sender, amount);

        if (amount > maxLimitTransaction && isFraud(fromAccountNum, toAccountNum, amount)) {
            System.out.println("Счет заблокирован системой безопасности");

            receiver.blockAccount();
            sender.blockAccount();
            wait();
            Thread.currentThread().interrupt();
        }
    }

    /**
     * TODO: реализовать метод. Возвращает остаток на счёте.
     */
    public void getBalance(String accountNum) {
        for (Map.Entry<String, Account> entry : accounts.entrySet()) {
            if (entry.getValue().getAccNumber().equals(accountNum)) {
            }
            System.out.println("Остаток на счете : " + entry.getValue().getMoney());
        }
    }

    public long getSumAllAccounts() {

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

    public void sendMoney(Account receiver, Account sender, long amount) {

        if (amount > sender.getMoney() && amount <= 0) {
            System.out.println("Недостаточно средств или неверная сумма перевода");
        } else {
            sender.setMoney(sender.getMoney() - amount);
            receiver.setMoney(receiver.getMoney() + amount);
        }
    }
}
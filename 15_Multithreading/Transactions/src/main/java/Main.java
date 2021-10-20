import java.util.*;

public class Main {

    private static Bank bank;
    private static List<Account> accounts = new ArrayList<>();

    public static void main(String[] args) {

        bank = new Bank();

        accounts = createMultipleAccounts(100);
        registerAccountsToBank(bank, accounts);

        int transactions = (int) (1 + Math.random() * 10);
        long moneyTransaction = (long) (1 + Math.random() * 100000);

        System.out.println(bank.getSumAllAccounts());

        Runnable runnable = () -> {

            for (int i = 0; i < transactions; i++) {
                String fromAcc = accounts.get((int) (Math.random() * accounts.size())).getAccNumber();
                String toAcc = accounts.get((int) (Math.random() * accounts.size())).getAccNumber();
                long money = (long) (1 + Math.random() * moneyTransaction);
                try {
                    bank.transfer(fromAcc, toAcc, money);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            Thread thread = new Thread(runnable);
            thread.start();
            threads.add(thread);
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(bank.getSumAllAccounts());
    }

    private static List<Account> createMultipleAccounts(int amount) {
        for (int i = 0; i < amount; i++) {
            accounts.add(new Account(generateMoneyAmount(), generateAccountNumber()));
        }
        return accounts;
    }

    private static long generateMoneyAmount() {
        return (long) (1 + Math.random() * 250000);
    }

    private static String generateAccountNumber() {

        StringBuilder countryCode = new StringBuilder("AA");
        Random random = new Random();

        for (int i = 0; i <= 3; i++) {
            int numbers = random.nextInt(9);
            countryCode.append((numbers));
        }
        return countryCode.toString();
    }

    private static void registerAccountsToBank(Bank bank, List<Account> accounts) {
        String accNumber;

        for (Account account : accounts) {
            accNumber = account.getAccNumber();
            bank.registerNewAccount(accNumber, account);
        }
    }
}
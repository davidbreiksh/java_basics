import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    private static Bank bank;
    private static List<Account> accounts = new ArrayList<>();

    public static void main(String[] args) {

        bank = new Bank();

            new Thread(() -> {

            }).start();
        }

    public static List<Account> createMultipleAccounts(int amount) {
        for (int i = 0; i < amount; i++) {
            accounts.add(new Account(generateMoneyAmount(), generateAccountNumber()));
        }
        return accounts;
    }


    public static List<Account> printAccounts() {
        for (Account account : accounts) {
            System.out.println(account.toString());
        }
        return accounts;
    }

    public static long generateMoneyAmount() {
        return (long) (1 + Math.random() * 10000000);
    }

    public static String generateAccountNumber() {

        StringBuilder countryCode = new StringBuilder("IE");
        Random random = new Random();

        for (int i = 0; i <= 12; i++) {
            int numbers = random.nextInt(10);
            countryCode.append((numbers));
        }
        return countryCode.toString();
    }
}
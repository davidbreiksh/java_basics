import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.regex.PatternSyntaxException;

public class CustomerStorage {
    private HashMap<String, Customer> storage;

    public CustomerStorage() {
        storage = new HashMap<>();
    }

    public void addCustomer(String data) throws addCustomerException {
        final String EMAIL = "^(.+)@(.+)$";
        final String PHONE_NUMBER = "^\\+?7(\\d{10})$";

        String[] components = data.split("\\s+");
        String name = components[0] + " " + components[1];

        if (!components[2].matches(EMAIL) || !components[3].matches(PHONE_NUMBER)) {
            throw new addCustomerException("Неверный ввод , пример ввода :\n" +
                    "Василий Петров vasily.petrov@gmail.com +79215637722");
        }
        storage.put(name, new Customer(name, components[3], components[2]));
    }

    public void listCustomers() {
        storage.values().forEach(System.out::println);
    }

    public void removeCustomer(String name) {
        storage.remove(name);
    }

    public int getCount() {
        return storage.size();
    }
}
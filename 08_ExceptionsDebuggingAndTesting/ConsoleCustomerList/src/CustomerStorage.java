import Exceptions.WrongEmailFormatException;
import Exceptions.WrongPhoneNumberException;

import java.util.HashMap;

public class CustomerStorage {
    private HashMap<String, Customer> storage;

    public CustomerStorage() {
        storage = new HashMap<>();
    }

    public void addCustomer(String data) throws WrongEmailFormatException, WrongPhoneNumberException {
        final String EMAIL = "^(.+)@(.+)$";
        final String PHONE_NUMBER = "^\\+?7(\\d{10})$";

        String[] components = data.split("\\s+");
        String name = components[0] + " " + components[1];

        if (!components[2].matches(EMAIL)) {
            throw new WrongEmailFormatException("Неверный ввод почты, пример ввода :\n" +
                    "Василий Петров vasily.petrov@gmail.com +79215637722");
        } else if (!components[3].matches(PHONE_NUMBER)) {
            throw new WrongPhoneNumberException("Неверный ввод номера телефона, пример ввода :\n" +
                    "Василий Петров vasily.petrov@gmail.com +79215637722");
        }
        storage.put(name, new Customer(name, components[3], components[2]));
    }

    public void listCustomers() {
        storage.values().forEach(System.out::println);
    }

    public void removeCustomer(String name) throws IllegalArgumentException {
        if (name.length() <= 0) {
            throw new IllegalArgumentException("Неправильный ввод");
        }
        storage.remove(name);
    }

    public int getCount() {
        return storage.size();
    }
}
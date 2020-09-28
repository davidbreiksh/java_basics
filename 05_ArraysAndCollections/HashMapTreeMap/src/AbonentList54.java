import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class AbonentList54 {

    private static TreeMap<String, Integer> telephoneDirectory = new TreeMap<>();

    public static void main(String[] args) {


        telephoneDirectory.put("Vladimir", 28817293);
        telephoneDirectory.put("Oleg", 20346203);
        telephoneDirectory.put("Max", 22348596);

        Scanner scanner = new Scanner(System.in);

        final String subscribersName = "[a-zA-Z][a-z]*";
        final String subscribersNumber = "\\d+";

        for (; ; ) {
            String subscribers = scanner.nextLine();
            if (subscribers.equals("LIST")) {
                System.out.println("Список контактов :");
                printSubscriberList(telephoneDirectory);
            }
            if (subscribers.matches(subscribersNumber)) {
                int phone = Integer.parseInt(subscribers);
                if (telephoneDirectory.containsValue(phone)) {
                    System.out.println("Номер найден в списке контактов :");
                    findKeyByValue(phone);
                }
                if (!telephoneDirectory.containsValue(phone)) {
                    System.out.println("Номер не найден в списке контактов , запишите имя и создайте контакт");
                    String newName = scanner.nextLine();
                    telephoneDirectory.put(newName, phone);
                }
            }
            if (subscribers.matches(subscribersName)) {
                if (!telephoneDirectory.containsKey(subscribers)) {
                    System.out.println("Имя не найдено в списке контактов , запишите номер телефона и создайте контакт");
                    String phoneNumber = scanner.nextLine();
                    if (phoneNumber.matches(subscribersNumber)) {
                        int phone = Integer.parseInt(phoneNumber);
                        telephoneDirectory.put(subscribers, phone);
                    }
                } else {
                    System.out.println("Имя найдено в списке контактов :");
                    System.out.println(subscribers + " " + telephoneDirectory.get(subscribers));
                }
            }
        }
    }
    private static void printSubscriberList(Map<String, Integer> map) {
        for (String key : map.keySet()) {
            System.out.println(key + " " + map.get(key));
        }
    }
    private static void findKeyByValue(int phoneNumber) {
        Set<String> find = telephoneDirectory.keySet();
        for (String item : find) {
            if (telephoneDirectory.get(item).equals(phoneNumber)) {
                System.out.println(item + " " + phoneNumber);
            }
        }
    }
}
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class AbonentList54 {
    public static void main(String[] args) {
        TreeMap<String, Integer> telephoneDirectory = new TreeMap<>();

        telephoneDirectory.put("Vladimir", 28817293);
        telephoneDirectory.put("Oleg", 20346203);
        telephoneDirectory.put("Max", 22348596);

        Scanner scanner = new Scanner(System.in);

        final String SUBSCRIBERS_NAME = "[a-zA-Z][a-z]*";
        final String SUBSCIRBERS_NUMBER = "\\d+";

        for (; ; ) {
            String subscribers = scanner.nextLine();
            if (subscribers.equals("LIST")) {
                System.out.println("Список контактов :");
                printSubscriberList(telephoneDirectory);
            }
            if (subscribers.matches(SUBSCIRBERS_NUMBER)) {
                int phone = Integer.parseInt(subscribers);
                if (telephoneDirectory.containsValue(phone)) {
                    System.out.println("Номер найден в списке контактов :");
                    Set<String> find = telephoneDirectory.keySet();
                    for (String item : find) {
                        if (telephoneDirectory.get(item).equals(phone)) {
                            System.out.println(item + " " + phone);
                        }
                    }
                }
            }
            if (subscribers.matches(SUBSCIRBERS_NUMBER)) {
                int phone = Integer.parseInt(subscribers);
                if (!telephoneDirectory.containsValue(phone)) {
                    System.out.println("Номер не найден в списке контактов , запишите имя и создайте контакт");
                    String newName = scanner.nextLine();
                    telephoneDirectory.put(newName, phone);
                }
            }
            if (subscribers.matches(SUBSCRIBERS_NAME)) {
                if (!telephoneDirectory.containsKey(subscribers)) {
                    System.out.println("Имя не найдено в списке контактов , запишите номер телефона и создайте контакт");
                    String phoneNumber = scanner.nextLine();
                    if (phoneNumber.matches(SUBSCIRBERS_NUMBER)) {
                        int phone = Integer.parseInt(phoneNumber);
                        telephoneDirectory.put(subscribers, phone);

                    }
                }
                if (telephoneDirectory.containsKey(subscribers)) {
                    System.out.println("Имя найдено в списке контактов :");
                    System.out.println(subscribers + " " + telephoneDirectory.get(subscribers));
                }
            }
        }
    }

    //(subscribers.matches(SUBSCRIBERS_NAME))
    private static void printSubscriberList(Map<String, Integer> map) {
        for (String key : map.keySet()) {
            System.out.println(key + " " + map.get(key));
        }
    }
}

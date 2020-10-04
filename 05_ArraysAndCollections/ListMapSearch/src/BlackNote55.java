import java.util.*;

public class BlackNote55 {
    public static ArrayList<String> carNumbers = new ArrayList<>();
    public static Set<String> carNumbersTree = new TreeSet<>();

    public static void main(String[] args) {

        String[] letters = {"C", "M", "T", "B", "A", "P", "O", "H", "E", "Y"};

        for (int firstLetter = 0; firstLetter < letters.length; firstLetter++) {
            for (int secondLetter = 0; secondLetter < letters.length; secondLetter++) {
                for (int thirdLetter = 0; thirdLetter < letters.length; thirdLetter++) {
                    for (int c = 111; c <= 999; c += 111) {
                        for (int region = 1; region <= 199; region++) {
                            String number = String.format("%s%s%s%03d", firstLetter, c, secondLetter + thirdLetter, region);
                            carNumbersTree.add(number);
                        }
                    }
                }
            }
        }

        Scanner scanner = new Scanner(System.in);
        Collections.sort(carNumbers);
        carNumbers.addAll(carNumbersTree);
        HashSet<String> carNumbersHash = new HashSet<>(carNumbers);
        TreeSet<String> carNumberTree = new TreeSet<>(carNumbers);


        long time = System.nanoTime();

        for (; ; ) {
            System.out.println("Введите номер");
            String string = scanner.nextLine();

            if (carNumbers.contains(string)) {
                System.out.println("Метод перебора , время поиска : " + (System.nanoTime() - time) + " наносекунд");
            } else {
                System.out.println("Номер не найден , время поиска : " + (System.nanoTime() - time) + " наносекунд");
            }
            int searchedIndex = Collections.binarySearch(carNumbers, string, Collections.reverseOrder());
            if (searchedIndex > -1) {
                System.out.println("Метод бинарного поиска , время поиска " + (System.nanoTime() - time) + " наносекунд");
            } else {
                System.out.println("Номер не найден , время поиска : " + (System.nanoTime() - time) + " наносекунд");
            }
            if (carNumbersHash.contains(string)) {
                System.out.println("Метод HashSet , время поиска " + (System.nanoTime() - time) + " наносекунд");
            } else {
                System.out.println("Номер не найден , время поиска : " + (System.nanoTime() - time) + " наносекунд");
            }
            if (carNumberTree.contains(string)) {
                System.out.println("Метод TreeSet , время поиска " + (System.nanoTime() - time) + " наносекунд");
            } else {
                System.out.println("Номер не найден , время поиска : " + (System.nanoTime() - time) + " наносекунд");
            }
        }
    }
}
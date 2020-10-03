import java.util.*;

public class BlackNote55 {
    public static ArrayList<String> carNumbers = new ArrayList<>();

    public static void main(String[] args) {

        String[] letters = {"C", "M", "T", "B", "A", "P", "O", "H", "E", "Y"};

        for (int a = 0; a < letters.length; a++) {
            for (int g = a++; g < letters.length; g++) {
                for (int f = letters.length - 1; f >= 0; f--) {
                    for (int c = 111; c <= 999; c += 111) {
                        for (int d = 1; d <= 199; d++) {
                            for (int h = 0; h < letters.length; h++) {
                                String region = String.valueOf(d);
                                String numbers = String.valueOf(c);
                                String letter = letters[h];
                                String secondLetter = letters[g];
                                String thirdLetter = letters[f];
                                String number = String.format("%s%s%s%s", letter, numbers, secondLetter + thirdLetter, region);
                                carNumbers.add(number);
                            }
                        }
                    }
                }
            }
        }

        Scanner scanner = new Scanner(System.in);
        Collections.sort(carNumbers , Collections.reverseOrder());
        HashSet<String> carNumbersHash = new HashSet<>(carNumbers);
        TreeSet<String> carNumberTree = new TreeSet<>(carNumbers);

        for (; ; ) {
            System.out.println("Введите номер");
            String string = scanner.nextLine();

            if (carNumbers.contains(string)) {
                System.out.println("Метод перебора , время поиска : " + System.nanoTime() + " наносекунд");
            }
            int searchedIndex = Collections.binarySearch(carNumbers , string , Collections.reverseOrder());
            if (searchedIndex > -1) {
                System.out.println("Метод бинарного поиска , время поиска " + System.nanoTime() + " наносекунд");
            }
            if (carNumbersHash.contains(string)) {
                System.out.println("Метод HashSet , время поиска " + System.nanoTime() + " наносекунд");
            }
            if (carNumberTree.contains(string)) {
                System.out.println("Метод TreeSet , время поиска " + System.nanoTime() + " наносекунд");
            }
        }
    }
}
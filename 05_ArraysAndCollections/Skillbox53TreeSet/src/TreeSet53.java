import java.util.Scanner;
import java.util.TreeSet;

public class TreeSet53 {

    static TreeSet<String> emails = new TreeSet<>();

    static void printTreeSet(){
        for (String set : emails){
            System.out.println(set);
        }
    }

    public static void main(String[] args) {


        emails.add("white@skillbox.ru");
        emails.add("johhny@skillbox.ru");
        emails.add("boss123@skillbox.ru");

        final String EMAIL = "^[ADD\\s+\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";

        String userInput;

        for (; ; ) {
            Scanner scanner = new Scanner(System.in);
            userInput = scanner.nextLine();

            if (userInput.matches("LIST")){
                printTreeSet();
            }

            if (userInput.matches(EMAIL)) {
                String[] split = userInput.split("\\s+", 2);
                if(!split[1].matches("^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$")){
                    System.out.println("Неверный формат ввода");
                    continue;
                }
                emails.add(split[1]);
            }
        }
    }
}
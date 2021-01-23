import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static Object DirectoryNotEmptyException;

    public static void main(String[] args) throws IOException {

        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите путь к копируемой папке");
            String from = scanner.nextLine();
            System.out.println("Введите путь куда хотите скопировать папку");
            String to = scanner.nextLine();

            FileUtils.copyFolder(from, to);

            File folder = new File(to);
            File[] files = folder.listFiles();
            System.out.println(Arrays.toString(files));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
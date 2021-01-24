import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, DirectoryNotEmptyException {

        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите путь к копируемой папке");
            String from = scanner.nextLine();
            System.out.println("Введите путь куда хотите скопировать папку");
            String to = scanner.nextLine();

            File dst = new File(to);

            FileUtils.copyFolder(from, to);

            File[] files = dst.listFiles();
            System.out.println(Arrays.toString(files));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
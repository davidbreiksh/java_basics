import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        try {

            System.out.println("Введите путь до папки");
            Scanner scanner = new Scanner(System.in);
            String pathToFolder = scanner.nextLine();

            System.out.println("Размер файлов в папке " + pathToFolder + " " + FileUtils.calculateFolderSize(pathToFolder) + " MB");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
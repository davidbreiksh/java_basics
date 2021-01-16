import java.io.File;
import java.io.IOException;

public class FileUtils {

    public static long calculateFolderSize(String path) throws IOException {

        long totalSize = 0;

        File folder = new File(path);
        File[] filesInFolder = null;

        if (folder.isDirectory()) {
            filesInFolder = folder.listFiles();
        } else {
            System.out.println("Не папка");
        }

        if (filesInFolder == null) {
            throw new RuntimeException("Папка не найдена");
        }

        for (int i = 0; i <= filesInFolder.length - 1; i++) {
            if (filesInFolder[i].isDirectory()) {
                totalSize += calculateFolderSize(filesInFolder[i].toString());
            } else {
                totalSize += filesInFolder[i].length();
            }
        }
        return convertToReadableFormat(totalSize);
    }

    public static long convertToReadableFormat(long size) {
        long kilobyte = size / 1024;
        long megabyte = kilobyte / 1024;
        long gigabyte = megabyte / 1024;
        long terabyte = gigabyte / 1024;

        if (terabyte > 0) {
            System.out.println("Размер файлов в папке " + terabyte + " TB");
        } else if (gigabyte > 0) {
            System.out.println("Размер файлов в папке " + gigabyte + " GB");
        } else if (megabyte > 0) {
            System.out.println("Размер файлов в папке " + megabyte + " MB");
        } else {
            System.out.println("Размер файлов в папке " + kilobyte + " KB");
        }
        return size;
    }
}
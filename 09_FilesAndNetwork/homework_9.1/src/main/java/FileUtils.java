import java.io.File;
import java.io.FileNotFoundException;

public class FileUtils {

    public static long calculateFolderSize(String path) throws FileNotFoundException {

        long totalSize = 0;
        long convertToMB = 1048576;

        File folder = new File(path);
        File[] filesInFolder = null;

        if (folder.isDirectory()) {
            filesInFolder = folder.listFiles();
        } else {
            System.out.println("Не папка");
        }

        if (filesInFolder != null && filesInFolder.length > 0) {
            for (File file : filesInFolder) {
                totalSize += filesInFolder.length;
            }
        }
        return totalSize / convertToMB;
    }
}

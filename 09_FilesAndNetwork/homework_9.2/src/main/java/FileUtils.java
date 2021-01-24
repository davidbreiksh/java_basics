import java.io.*;
import java.nio.file.*;
import java.util.Objects;
import java.util.stream.Stream;

public class FileUtils {
    public static void copyFolder(String sourceDirectory, String destinationDirectory) throws IOException {

        Path from = Paths.get(sourceDirectory);
        Path to = Paths.get(destinationDirectory);

        File scr = new File(sourceDirectory);
        File dir = new File(destinationDirectory);

        Stream<Path> files = Files.walk(from);

        if (dir.isDirectory() && Objects.requireNonNull(dir.list()).length != 0) {
            System.out.println("Папка не пуста или не существует");
        } else if (scr.isDirectory() || dir.isDirectory()) {
            files.forEach(file -> {
                try {
                    Files.copy(file, to.resolve(from.relativize(file)),
                            StandardCopyOption.REPLACE_EXISTING);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
        files.close();
    }
}
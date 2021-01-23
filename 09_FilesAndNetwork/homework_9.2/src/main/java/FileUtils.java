import java.io.*;
import java.nio.file.*;
import java.util.stream.Stream;

public class FileUtils {
    public static void copyFolder(String sourceDirectory, String destinationDirectory) throws IOException {

        Path from = Paths.get(sourceDirectory);
        Path to = Paths.get(destinationDirectory);

        Stream<Path> files = Files.walk(from);

        assert files != null;
        files.forEach(file -> {
            try {
                Files.copy(file, to.resolve(from.relativize(file)),
                        StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        files.close();
    }
}
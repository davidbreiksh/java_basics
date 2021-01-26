import java.io.*;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.*;
import java.util.stream.Stream;

public class FileUtils {
    public static <File> void copyFolder(String sourceDirectory, String destinationDirectory) throws IOException {

        Path from = Paths.get(sourceDirectory);
        Path to = Paths.get(destinationDirectory);

        if (Files.isDirectory(from) && Files.list(to).count() != 0) {
            System.out.println("Папка не пуста или не существует");
            return;
        }

        Files.walk(from).forEach(src -> {
            try {
                Files.copy(from, to.resolve(from.relativize(to)), StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
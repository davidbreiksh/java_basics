import java.io.File;
import java.util.*;
import java.util.concurrent.ConcurrentLinkedDeque;

public class Main {

    private static final int newWeight = 300;

    public static void main(String[] args) {

        String srcFolder = "C:/Users/Dell/Desktop/New folder";
        String destFolder = "C:/Users/Dell/Desktop/New folder (2)";

        File srcDir = new File(srcFolder);
        File[] files = srcDir.listFiles();

        int processors = Runtime.getRuntime().availableProcessors();

        assert files != null;
        Queue<File> filesQueue = new ConcurrentLinkedDeque<>(Arrays.asList(files));

        for (int b = 0; b < processors; b++) {
            Resizer resizer = new Resizer(filesQueue, newWeight, destFolder);
            Thread thread = new Thread(resizer);
            thread.start();
        }

    }
}
import java.io.File;
import java.util.*;

public class Main {

    private static final int newWeight = 300;

    public static void main(String[] args) {

        String srcFolder = "C:/Users/Dell/Desktop/New folder";
        String destFolder = "C:/Users/Dell/Desktop/New folder (2)";

        File srcDir = new File(srcFolder);
        File[] files = srcDir.listFiles();

        int processors = Runtime.getRuntime().availableProcessors();

        PriorityQueue<File> filePriorityQueue = new PriorityQueue<>();
        assert files != null;
        filePriorityQueue.addAll(Arrays.asList(files));

        while (filePriorityQueue.poll() != null) {
            filePriorityQueue.poll();

            for (int b = 0; b < processors; b++) {
                Resizer resizer = new Resizer(filePriorityQueue, newWeight, destFolder);
                Thread thread = new Thread(resizer);
                thread.start();
            }
        }
    }
}
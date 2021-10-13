import java.io.File;

public class Main {

    private static final int newWeight = 300;

    public static void main(String[] args) {

        String srcFolder = "C:/Users/Dell/Desktop/New folder";
        String destFolder = "C:/Users/Dell/Desktop/New folder (2)";

        File srcDir = new File(srcFolder);

        File[] files = srcDir.listFiles();

        int processors = Runtime.getRuntime().availableProcessors();

        for (int i = 0; i < processors; i++) {
            Resizer resizer = new Resizer(files, newWeight, destFolder);
            Thread thread = new Thread(resizer);
            thread.start();
        }
    }
}
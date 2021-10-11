import org.imgscalr.Scalr;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    private static int newHeight;
    private static final int newWeight = 300;

    public static void main(String[] args) {

        String srcFolder = "C:/Users/Dell/Desktop/New folder";
        String destFolder = "C:/Users/Dell/Desktop/New folder (2)";

        File srcDir = new File(srcFolder);

        File[] files = srcDir.listFiles();

        ExecutorService e = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        e.execute(new Thread(new Resizer(files, newWeight, destFolder)));
        e.shutdown();

        try {
            for (File file : files) {

                BufferedImage image = ImageIO.read(file);

                if (image == null) {
                    continue;
                }
                newHeight = (int) Math.round(image.getHeight() / (image.getWidth() / (double) newWeight));

                BufferedImage resizedImage = resize(image, newHeight, newWeight);

                File newFile = new File(destFolder + "/" + file.getName());
                ImageIO.write(resizedImage, "jpg", newFile);
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }

    }

    public static BufferedImage resize(BufferedImage originalImage, int targetHeight, int targetWeight) throws
            IOException {
        return Scalr.resize(originalImage, targetHeight, targetWeight);
    }
}
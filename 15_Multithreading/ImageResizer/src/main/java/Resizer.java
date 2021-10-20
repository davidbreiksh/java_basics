import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Queue;

import org.imgscalr.Scalr;

import javax.imageio.ImageIO;

public class Resizer implements Runnable {

    private final Queue<File> file;
    private final int newWeight;
    private final String destFolder;

    public Resizer(Queue<File> file, int newWeight, String destFolder) {
        this.file = file;
        this.newWeight = newWeight;
        this.destFolder = destFolder;
    }

    @Override
    synchronized public void run() {

        try {
            while (true) {

                File files = file.poll();
                if (files == null) {
                    break;
                }

                BufferedImage image = ImageIO.read((files));

                int newHeight = (int) Math.round(image.getHeight() / (image.getWidth() / (double) newWeight));

                BufferedImage resizedImage = Scalr.resize(image, newHeight, newWeight);

                File newFile = new File(destFolder + "/" + files.getName());
                ImageIO.write(resizedImage, "jpg", newFile);
                System.out.println(Thread.currentThread().getName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
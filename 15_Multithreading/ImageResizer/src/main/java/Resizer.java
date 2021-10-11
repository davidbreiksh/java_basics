import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import org.imgscalr.Scalr;

import javax.imageio.ImageIO;

public class Resizer implements Runnable {

    private final File[] file;
    private final int newWeight;
    private final String destFolder;

    public Resizer(File[] file, int newWeight, String destFolder) {
        this.file = file;
        this.newWeight = newWeight;
        this.destFolder = destFolder;
    }

    @Override
    public void run() {

        try {
            for (File files : file) {

                BufferedImage image = ImageIO.read(files);

                if (image == null) {
                    continue;
                }
                int newHeight = (int) Math.round(image.getHeight() / (image.getWidth() / (double) newWeight));

                BufferedImage resizedImage = resize(image, newHeight, newWeight);

                File newFile = new File(destFolder + "/" + files.getName());
                ImageIO.write(resizedImage, "jpg", newFile);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static BufferedImage resize(BufferedImage originalImage, int targetHeight, int targetWeight) throws
            IOException {
        return Scalr.resize(originalImage, targetHeight, targetWeight);
    }
}
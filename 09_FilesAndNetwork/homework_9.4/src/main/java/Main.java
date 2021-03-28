import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;

import java.net.URL;

public class Main {

    private static Logger notImageLogger;

    private static String dstPath = "C:\\Users\\david\\IdeaProjects\\homework_9.4\\src\\image";

    public static void main(String[] args) throws IOException {

        notImageLogger = LogManager.getLogger("NotImage");

        String webSite = "http://lenta.ru/";


        Document doc = Jsoup.connect(webSite).get();
        Elements img = doc.select("img");


        try {

            for (Element links : img) {
                String st = links.attr("src");
                downloadImg(st);
                System.out.println(st);
            }
        } catch (Exception e) {
            notImageLogger.info("Не картинка");
        }
    }

    public static void downloadImg(String imgLink) throws IOException {
        URL url = new URL(imgLink);
        inStream(url, imgLink);
    }

    public static void inStream(URL url, String imgName) throws IOException {
        String fileName = imgName.substring(imgName.lastIndexOf('/') + 1);

        InputStream it = new BufferedInputStream(url.openStream());

        ByteArrayOutputStream os = new ByteArrayOutputStream();

        byte[] buf = new byte[1024];
        int n = 0;
        while (-1 != (n = it.read(buf))) {
            os.write(buf, 0, n);
        }
        it.close();
        os.close();
        byte[] response = os.toByteArray();

        FileOutputStream fs = new FileOutputStream(dstPath + "\\" + fileName);
        fs.write(response);
        fs.close();
    }
}
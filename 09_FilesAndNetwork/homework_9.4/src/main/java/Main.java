import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws IOException {

        String webSite = "http://lenta.ru/";
        String dstPath = "E:\\fol";

        Document doc = Jsoup.connect(webSite).get();
        Elements el = doc.getElementsByTag("img");

        for (Element element : el) {
            getImagesFromWebSite(webSite, dstPath);
        }
    }

    public static void getImagesFromWebSite(String url, String dstPath) throws IOException {
        String imgName = url.substring(url.lastIndexOf("/") + 1);

        URL webSiteUrl = new URL(url);
        InputStream is = webSiteUrl.openStream();

        byte[] buffer = new byte[4096];
        int n;

        OutputStream os = new FileOutputStream(dstPath + " " + imgName);

        while ((n = is.read(buffer)) != -1) {
            os.write(buffer, 0, n);
        }
        os.close();
    }
}
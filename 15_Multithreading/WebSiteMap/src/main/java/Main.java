import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Collections;
import java.util.concurrent.ForkJoinPool;

public class Main {
    private static String SITE_URL =  "https://skillbox.ru/";
    private static final String SITEMAP_DOC = "src/main/resources/map.txt";

    public static void main(String[] args) {
        Node rootUrl = new Node(SITE_URL);
        new ForkJoinPool().invoke(new RecursiveAction(rootUrl,rootUrl));
        writeSitemapUrl(rootUrl,SITEMAP_DOC);
    }

    public static void writeSitemapUrl(Node node,String sitemapDoc) {
        int depth = node.getDepth();
        String tabs = String.join("", Collections.nCopies(depth, "\t"));
        StringBuilder result = new StringBuilder(tabs + node.getUrl() + "\n");
        appendStringInFile(sitemapDoc, result.toString());
        node.getSublinks().forEach(link -> writeSitemapUrl(link, sitemapDoc));
    }

    private static void appendStringInFile(String fileName, String data) {
        OutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream((fileName), true);
            outputStream.write(data.getBytes(), 0, data.length());
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
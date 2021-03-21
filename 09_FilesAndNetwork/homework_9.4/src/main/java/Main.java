import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws IOException {

        String webSite = "http://lenta.ru/";
        String dstPath = "C:\\Users\\david\\IdeaProjects\\homework_9.4\\src\\image";


        Document doc = Jsoup.connect(webSite).get();
        Elements img = doc.select("img");

        for (Element links : img) {
            String st = links.attr("src");
            String fileName = st.substring(st.lastIndexOf('/') + 1);
            System.out.println(st);

            URL url = new URL(st);
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
}
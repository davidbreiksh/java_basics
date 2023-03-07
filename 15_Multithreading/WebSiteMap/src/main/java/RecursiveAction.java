import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.swing.text.html.parser.Parser;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import static java.lang.Thread.sleep;

public class RecursiveAction extends java.util.concurrent.RecursiveAction {
    private Node url;
    private Node rootUrl;
    private static CopyOnWriteArraySet<String> allLinks = new CopyOnWriteArraySet<>();

    public RecursiveAction(Node url, Node rootUrl) {
        this.url = url;
        this.rootUrl = rootUrl;
    }


    @Override
    protected void compute() {
        Set<RecursiveAction> taskList = new HashSet<>();
        try {
            sleep(500);
            Document doc = Jsoup.connect(url.getUrl()).timeout(100000).get();
            Elements links = doc.select("a[href]");
            for (Element link : links) {
                String absUrl = link.attr("abs:href");
                if (isCorrected(absUrl)) {
                    url.addSublinks(new Node(absUrl));
                    allLinks.add(absUrl);
                }
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        for (Node link : url.getSublinks()) {
            RecursiveAction task = new RecursiveAction(link, rootUrl);
            task.fork();
            taskList.add(task);
        }

        for (RecursiveAction task : taskList) {
            task.join();
        }
    }

    private boolean isCorrected(String url) {
        return (!url.isEmpty() && url.startsWith(rootUrl.getUrl())
                && !allLinks.contains(url) && !url.contains("#")
                && !url.matches("([^\\s]+(\\.(?i)(jpg|png|gif|bmp|pdf))$)"));
    }
}
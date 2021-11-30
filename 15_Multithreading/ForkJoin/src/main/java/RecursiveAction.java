import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.RecursiveTask;

public class RecursiveAction extends RecursiveTask<Set<String>> {

    Set<String> allLinks = new HashSet<>();
    Set<RecursiveAction> tasks = new HashSet<>();

    String rootUrl;
    String url;

    String matchUrl = "/([^\\/]+)(?=\\.\\w+$)/";

    public RecursiveAction(String url) {
        this.url = url;
    }

    public RecursiveAction(String url, String rootUrl) {
        this.url = url;
        this.rootUrl = rootUrl;
    }

    @Override
    protected Set<String> compute() {

        Set<String> links = new HashSet<>();

        try {
            getLinks(tasks);
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        for (RecursiveAction item : tasks) {
            links.addAll(item.join());
        }

        return links;
    }

    private void getLinks(Set<RecursiveAction> tasks) throws IOException {

        Document document = Jsoup.connect(url).ignoreHttpErrors(true).ignoreContentType(true).timeout(10000).get();
        Elements elements = document.select("a[href]");

        for (Element element : elements) {
            String link = element.attr("abs:href");
            if (linkFilter(link)) {
                RecursiveAction recursiveAction = new RecursiveAction(link);
                recursiveAction.fork();
                tasks.add(recursiveAction);
                allLinks.add(link);
            }
        }
    }

    private boolean linkFilter(String url) {
        return (!url.contains("#")
                &&(!url.isEmpty())
                &&(!allLinks.contains(url))
                && !url.endsWith(".pdf"))
                && (url.matches(matchUrl))
                &&(url.startsWith(rootUrl));
    }
}
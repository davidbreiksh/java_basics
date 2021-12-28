import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.RecursiveTask;

public class RecursiveAction extends RecursiveTask<List<String>> {

    List<String> allLinks = new ArrayList<>();
    List<RecursiveAction> allTasks = new ArrayList<>();

    public static String rootUrl;
    String url;

    String matchUrl = "([^\\s]+(\\.(?i)(jpg|png|gif|bmp|pdf))$)";

    public RecursiveAction(String url) {
        this.url = url;
    }

    public RecursiveAction(String url, String rootUrl) {
        this.url = url;
        RecursiveAction.rootUrl = rootUrl;
    }

    @Override
    protected List<String> compute() {


        List<RecursiveAction> tasks = new ArrayList<>();

        Document document = null;
        try {
            document = Jsoup.connect(url).ignoreHttpErrors(true).ignoreContentType(true).timeout(10000).get();
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        Elements elements = document.select("a[href]");
        if (elements.size() > 1) {
            for (Element element : elements) {
                String link = element.attr("abs:href");
                if (linkFilter(link)) {
                    allLinks.add(link);
                }
            }
        }
        if (allLinks != null) {
            for (String allLink : allLinks) {
                if (!allLink.isEmpty()) {
                    RecursiveAction task = new RecursiveAction(allLink);
                    task.fork();
                    tasks.add(task);
                }
            }
        }

        addResults(allLinks, tasks);

        return allLinks;
    }

    private boolean linkFilter(String url) {

        return (!url.isEmpty()
                && url.startsWith(rootUrl)
                && !allLinks.contains(url)
                && !url.contains("#")
                && !url.matches(matchUrl));
    }

    private void addResults(List<String> list, List<RecursiveAction> tasks) {
        for (RecursiveAction item : tasks) {
            list.addAll(item.join());
        }
    }
}
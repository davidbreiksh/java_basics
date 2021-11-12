import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.RecursiveTask;

import static java.lang.Thread.sleep;

public class RecursiveAction extends RecursiveTask<List<String>> {

    private final Node<String> rootUrl;
    private final Node<String> childUrl;

    List<String> links = new ArrayList<>();

    public RecursiveAction(Node<String> rootUrl, Node<String> childUrl) {
        this.rootUrl = rootUrl;
        this.childUrl = childUrl;
    }

    @Override
    protected List<String> compute() {

        try {
            try {
                sleep(150);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Document doc = Jsoup.connect(rootUrl.getUrl()).timeout(10000).get();
            Elements elements = doc.select("a[href]");

            for (Element el : elements) {
                String url = el.attr("abs:href");
                if (linkFilter(url)) {
                    rootUrl.addChild(new Node<>(url));
                    links.add(url);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        List<RecursiveAction> taskList = new ArrayList<>(createTasks());

        for (RecursiveAction subtask : taskList) {
            subtask.join();
        }

//        taskList.forEach(RecursiveAction::join);

        return links;
    }

    private List<RecursiveAction> createTasks() {

        List<RecursiveAction> forks = new ArrayList<>();

        for (Node<String> url : rootUrl.getChildren()) {
            RecursiveAction act = new RecursiveAction(url, rootUrl);
            forks.add(act);
            act.fork();

        }
        return forks;
    }

    private boolean linkFilter(String url) {
        return (!url.contains("#") && !links.contains(url)
                && !url.endsWith(".pdf"));
    }
}
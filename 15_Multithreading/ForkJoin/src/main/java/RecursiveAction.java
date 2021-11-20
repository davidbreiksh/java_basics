import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Document;

import static java.lang.Thread.sleep;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RecursiveAction extends RecursiveTask<Set<String>> {

    private final Node<String> rootUrl;
    private final Node<String> childUrl;

    Set<String> links = new CopyOnWriteArraySet<>();

    public RecursiveAction(Node<String> rootUrl, Node<String> childUrl) {
        this.rootUrl = rootUrl;
        this.childUrl = childUrl;
    }

    @Override
    protected Set<String> compute() {

        try {
            sleep(350);
            Document doc = Jsoup.connect(rootUrl.getUrl()).timeout(10000).get();
            Elements elements = doc.select("a[href]");

            for (Element el : elements) {
                String url = el.attr("abs:href");
                if (linkFilter(url)) {
                    rootUrl.addChild(new Node<>(url));
                    links.add(url);
                }
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        Set<RecursiveAction> taskList = new CopyOnWriteArraySet<>(createTasks());
        taskList.forEach(ForkJoinTask::fork);
        addResults(links, taskList);

        return links;
    }

    private Set<RecursiveAction> createTasks() {

        Set<RecursiveAction> forks = new HashSet<>();
        for (Node<String> url : rootUrl.getChildren()) {
            RecursiveAction act = new RecursiveAction(url, rootUrl);
            act.fork();
            forks.add(act);
        }
        return forks;
    }

    private void addResults(Set<String> list, Set<RecursiveAction> tasks) {
        for (RecursiveAction item : tasks) {
            list.addAll(item.join());
        }
    }

    //    private Collection<RecursiveAction> createSubtasks() {
//        List<RecursiveAction> tasks = new ArrayList<>();
//        for (Node<String> node : rootUrl.getChildren()) {
//            RecursiveAction action = new RecursiveAction(node, rootUrl);
//            tasks.add(action);
//        }
//        return tasks;
//    }

    private boolean linkFilter(String url) {
        return (!url.contains("#") && !links.contains(url)
                && !url.endsWith(".pdf"));
    }
}
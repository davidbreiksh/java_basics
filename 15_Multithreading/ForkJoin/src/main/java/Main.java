import java.util.concurrent.ForkJoinPool;

public class Main {

    private final static String SITE_URL = "https://lenta.ru/"; //"https://skillbox.ru/";

    public static void main(String[] args) {

        Node<String> node = new Node<>(SITE_URL);
        new ForkJoinPool().invoke(new RecursiveAction(node, node));
        print(node, "");
    }

    private static void print(Node<String> node, String app) {
        System.out.println(app + node.getUrl());
        node.getChildren().forEach(each -> print(each, app + app));
    }
}
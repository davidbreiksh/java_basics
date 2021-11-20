import java.io.*;
import java.util.Collections;
import java.util.concurrent.ForkJoinPool;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private final static String URL = "https://lenta.ru/";
    private static final String PATH = "src/main/resources/map.txt";
    private static final Logger logger = LogManager.getLogger("FileAppender");

    public static void main(String[] args) throws IOException {

        Node<String> node = new Node<>(URL);
        RecursiveAction recursiveAction = new RecursiveAction(node, node);
        ForkJoinPool pool = new ForkJoinPool();
        pool.execute(recursiveAction);
//        forkJoinPool.invoke(recursiveAction);
//        new ForkJoinPool().invoke(new RecursiveAction(node, node));
        print(node);
    }

    private static void print(Node<String> node) throws IOException {

        if (node == null) {
            return;
        }

        int size = node.getNodeSize();
        String tab = String.join("", Collections.nCopies(size, "\t"));
        String link = tab + node.getUrl() + "\n";
        logger.info("ссылки " + link + " Thread name : " + Thread.currentThread().getName());
        writeToFile(link);
        node.getChildren().forEach(each -> {
            try {
                print(each);
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        });
    }

    private static void writeToFile(String data) throws IOException {
        OutputStream outputStream = new FileOutputStream((Main.PATH), true);
        outputStream.write(data.getBytes(), 0, data.length());
    }
}
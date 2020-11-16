import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class balck {
    public static void main(String[] args) {
        List<String> words = new ArrayList<>();
        words.add("lol");
        words.add("lel");
        words.add("lol");
        words.add("lol");
        int count = Collections.frequency(words , "lol");
        System.out.println(count);
    }
}

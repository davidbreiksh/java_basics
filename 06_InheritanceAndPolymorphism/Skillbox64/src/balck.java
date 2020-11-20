import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class balck {
    public static void main(String[] args) {
        List<String> words = new ArrayList<>() {{
            add("lol");
            add("dd");
            add("ddd");
            add("dd");
        }};
        String match = "dd";
        int count = 0 ;
        for (int a = words.size()  ; a >= 0 ; a --){
            if (words.contains(match)){
                count++;
            }
        }
        System.out.println(count);
        System.out.println(words.size());
    }
}
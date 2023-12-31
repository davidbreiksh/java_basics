import core.Metro;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        //String web = "https://www.moscowmap.ru/metro.html#lines";

        //Document document = Jsoup.connect(web).maxBodySize(0).get();

        parseMetro parseMetro = new parseMetro("https://www.moscowmap.ru/metro.html#lines");

        JSONArray lines = parseMetro.parseMetroLines();
        JSONObject station = parseMetro.parseMetroStation();

        Metro metro = new Metro(station, lines);

        WriteToJSON writer = new WriteToJSON();
        writer.toJSONFile(metro.getMetro(), "src/main/resources/metro.json");

        ReadJSONFile readJSONFile = new ReadJSONFile();
        readJSONFile.numberOfStations("src/main/resources/metro.json");

    }
}
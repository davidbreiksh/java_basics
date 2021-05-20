import core.Line;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class parseMetro {

    private final String webUrl = "https://www.moscowmap.ru/metro.html#lines";

    private Document doc;
    private List<Line> metroLines;

    parseMetro(String url) throws IOException {
        doc = Jsoup.connect(webUrl).userAgent("Mozilla/5.0 Chrome/26.0.1410.64 Safari/537.31").maxBodySize(0).get();
        metroLines = new ArrayList<>();
    }

    public JSONArray parseMetroLines() throws IOException {

        doc = Jsoup.connect(webUrl).maxBodySize(0).get();

        Line line;
        JSONArray linesArray = new JSONArray();

        for (Element el : doc.select("span.js-metro-line")) { // линии
            String number = el.attr("data-line"); // НОМЕРА ЛИНИЙ

            line = new Line(el.ownText(), number);
            linesArray.add(line.getLine());
            metroLines.add(line);
        }
        return linesArray;
    }

    public JSONObject parseMetroStation() throws IOException {
        doc = Jsoup.connect(webUrl).maxBodySize(0).get();

        JSONObject station = new JSONObject();
        JSONArray stationsArray = new JSONArray();

        for (Element element : doc.select("div.js-metro-stations")) {
            System.out.println(element);
            Elements elements = element.getElementsByClass("name");
            Elements elements1 = element.getElementsByClass("num");

            for (Element element1 : elements) {
                stationsArray.add(element1.text());
                station.put(elements1, stationsArray);
            }
        }
        return station;
    }
}
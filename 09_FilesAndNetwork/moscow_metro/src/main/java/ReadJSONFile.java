import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadJSONFile {

    public void numberOfStations(String path) throws FileNotFoundException {
        JSONParser parser = new JSONParser();

        try (FileReader reader = new FileReader(path)) {

            Object obj = parser.parse(reader);
            JSONObject metro = (JSONObject) obj;
            JSONObject station = (JSONObject) metro.get("station");
            station.keySet().forEach(k -> {
                JSONArray stations = (JSONArray) station.get(k);
                System.out.println("Линия " + k + " " + "Станции на линии " + stations.size());
            });

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
}

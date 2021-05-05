package core;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Metro {

    JSONObject metro;

    public Metro(JSONObject stations, JSONArray lines) {
        metro = new JSONObject();
        metro.put("station", stations);
        metro.put("lines", lines);

    }

    public JSONObject getMetro() {
        return metro;
    }
}

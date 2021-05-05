package core;

import org.json.simple.JSONObject;

public class Station {

    private String line;
    private String stationName;
    private JSONObject station;


    public Station(String name, String line) {
        this.stationName = name;
        this.line = line;
        station.put("station", name);
        station.put("линия", line);

    }

    public String getLine() {
        return line;
    }

    public String getName() {
        return stationName;
    }
}
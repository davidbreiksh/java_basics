package core;

import org.json.simple.JSONObject;

public class Line {

    private JSONObject line;
    private String name;
    private String number;

    public Line(String name, String number) {
        line = new JSONObject();
        line.put("название линии", name);
        line.put("номер линии", number);
        this.name = name;
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public JSONObject getLine() {
        return line;
    }

}
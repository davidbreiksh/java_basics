import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class WriteToJSON {

    public void toJSONFile(JSONObject object, String filePath) throws IOException {
        FileWriter writer = new FileWriter(filePath);
        writer.write(object.toJSONString());

        writer.flush();
        writer.close();
    }
}

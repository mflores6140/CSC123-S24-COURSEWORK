import org.json.simple.JSONObject;

import java.util.Map;
import java.util.TreeMap;

public class StringMapJSON {
    public static void main(String[] args) {
        Map<String, String> map = new TreeMap<>();
        map.put("Name", "Name1");
        map.put("Address", "213 Washington Blvd");
        map.put("Zip", "90532");
        
        JSONObject jsonObject = new JSONObject();
        
        for (Map.Entry<String, String> entry : map.entrySet()) {
            jsonObject.put(entry.getKey(), entry.getValue());
        }
        
        String jsonString = jsonObject.toJSONString();
        
        System.out.println(jsonString);
    }
}

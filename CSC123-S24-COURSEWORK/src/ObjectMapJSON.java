import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.Map;
import java.util.TreeMap;

public class ObjectMapJSON {
    public static void main(String[] args) {
    	
        Map<String, Object> map = new TreeMap<>();
        map.put("Name", "Name1");
        map.put("Address", "213 Washington Blvd");
        map.put("Zip", "90532");
        
        Map<String, Object> nestedMap = new TreeMap<>();
        nestedMap.put("City", "New York");
        nestedMap.put("Country", "USA");
        map.put("Location", nestedMap);
        
        JSONObject jsonObject = new JSONObject();
        
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            jsonObject.put(entry.getKey(), convertValueToJson(entry.getValue()));
        }
        
        String jsonString = jsonObject.toJSONString();
        
        System.out.println(jsonString);
    }
    
    private static Object convertValueToJson(Object value) {
        if (value instanceof Map) {
            JSONObject innerJsonObject = new JSONObject();
            Map<String, Object> innerMap = (Map<String, Object>) value;
            for (Map.Entry<String, Object> entry : innerMap.entrySet()) {
                innerJsonObject.put(entry.getKey(), convertValueToJson(entry.getValue()));
            }
            return innerJsonObject;
        } else if (value instanceof Iterable) {
            JSONArray jsonArray = new JSONArray();
            for (Object element : (Iterable<?>) value) {
                jsonArray.add(convertValueToJson(element));
            }
            return jsonArray;
        } else {
            return value;
        }
    }
}

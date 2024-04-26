import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class ObjectArrayJSON {

	public static void main(String[] args) {
        Object[] array = {31, 32, "Hello World", new String[]{"One", "Two", "Three"}};
        
        JSONArray jsonArray = new JSONArray();
        
        for (Object obj : array) {
            if (obj instanceof Integer) {
                jsonArray.add(obj);
            } else if (obj instanceof String) {
                jsonArray.add(obj);
            } else if (obj instanceof String[]) {
                JSONArray nestedArray = new JSONArray();
                for (String s : (String[]) obj) {
                    nestedArray.add(s);
                }
                jsonArray.add(nestedArray);
            }
        }
        String jsonString = jsonArray.toJSONString();
        System.out.println(jsonString);
    }
}

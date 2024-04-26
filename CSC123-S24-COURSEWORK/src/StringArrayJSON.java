import org.json.simple.JSONArray;

public class StringArrayJSON {

	public static void main(String[] args) {
		
		String[] array = {"One", "Two", "Three", "Four"};
        
        JSONArray jsonArray = new JSONArray();
        
        for (String value : array) {
            jsonArray.add(value);
        }
        
        String jsonString = jsonArray.toJSONString();
        
        System.out.println(jsonString);
    }
}

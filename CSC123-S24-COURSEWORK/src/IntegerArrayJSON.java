import org.json.simple.JSONArray;

public class IntegerArrayJSON {
    public static void main(String[] args) {
    	
        Integer[] array = {30, 31, 34, 28, 49};
        
        JSONArray jsonArray = new JSONArray();
        
        for (Integer value : array) {
            jsonArray.add(value);
        }
        
        String jsonString = jsonArray.toJSONString();
        
        System.out.println(jsonString);
    }
}

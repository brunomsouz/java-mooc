import java.util.Map;
import java.util.HashMap;

public class MainProgram {

    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        
        map.put("first", "Bruno");
        map.put("second", "Evelin");
        map.put("third", "Magali");
        
        System.out.println(returnSize(map));
    }

    public static int returnSize(Map map) {
        return map.size();
    }
}

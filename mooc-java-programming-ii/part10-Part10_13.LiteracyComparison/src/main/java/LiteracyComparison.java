
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LiteracyComparison {
    
    public static void main(String[] args) {
        List<Literacy> data = read("literacy.csv");
        
        data.stream().sorted().forEach(item -> System.out.println(item));
    }

    public static List<Literacy> read(String file) {                
        try {
            return Files.lines(Paths.get(file)).map(row -> row.split(","))
                    .map(parts -> new Literacy(parts[3], Integer.parseInt(parts[4]), parts[2].replace("(%)", "").trim(), Double.parseDouble(parts[5])))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        return new ArrayList<>();
    }
}

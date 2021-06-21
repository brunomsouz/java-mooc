
import java.util.ArrayList;

public class SimpleCollection {

    private String name;
    private ArrayList<String> elements;

    public SimpleCollection(String name) {
        this.name = name;
        this.elements = new ArrayList<>();
    }

    public void add(String element) {
        this.elements.add(element);
    }

    public ArrayList<String> getElements() {
        return this.elements;
    }
    
    public String toString() {
        
        String header = "The collection " + name + " ";
        
        if (this.elements.isEmpty()) {
            return header + "is empty.";
        }
                
        header += "has " + this.elements.size();
        
        if (this.elements.size() == 1) {
            header += " element:";
        } else {
            header += " elements:";
        }
        
        String list = "";
        
        for (String element: this.elements) {
            list += "\n" + element;
        }
        
        return header + list;
    }
    
}

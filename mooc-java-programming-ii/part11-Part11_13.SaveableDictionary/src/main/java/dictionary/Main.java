package dictionary;

public class Main {

    public static void main(String[] args) {
        SaveableDictionary dictionary = new SaveableDictionary("words.txt");
        dictionary.add("phone", "smartphone");
        dictionary.add("phone", "banana");
        dictionary.add("smartphone", "banana");

        dictionary.save();
        
    }
}

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        HashMap<SimpleDate, String> birthdays = new HashMap<>();

        SimpleDate brunosBirthday = new SimpleDate(31, 12, 10000);
        
        System.out.println(brunosBirthday.hashCode());
    }
}

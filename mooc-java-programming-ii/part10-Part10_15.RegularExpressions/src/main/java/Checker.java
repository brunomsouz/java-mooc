

public class Checker {

    public boolean isDayOfWeek(String string) {
        return string.matches("mon|tue|wed|thu|fri|sat|sun");
    }
    
    public boolean allVowels(String string) {
        return string.matches("[a|e|i|o|u]*");
    }
    
    public boolean timeOfDay(String time) {
        //return time.matches("([00-23]{2}):([00-59]{2}):([00-59]{2})");
        return time.matches("([0-1][0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]");
    }
}

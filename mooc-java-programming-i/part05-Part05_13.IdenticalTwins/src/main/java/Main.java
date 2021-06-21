
public class Main {

    public static void main(String[] args) {
        // you can write code here to try out your program
        SimpleDate brunosBirthday = new SimpleDate(13, 12, 1995);
        SimpleDate evelinsBirthday = new SimpleDate(30, 12, 1999);
        
        Person bruno = new Person("Bruno", brunosBirthday, 181, 83);
        Person evelin = new Person("Evelin", evelinsBirthday, 160, 50);
        Person newBruno = new Person("Bruno", evelinsBirthday, 181, 83);
        
        System.out.println(bruno.equals(evelin));
        System.out.println(bruno.equals(newBruno));
    }
}

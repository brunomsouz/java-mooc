import java.util.List;
import java.util.ArrayList;

public class MainProgram {

    public static void main(String[] args) {
        Employees employees = new Employees();
        
        Person bruno = new Person("Bruno", Education.BA);
        Person evelin = new Person("Evelin", Education.BA);
        
        employees.add(bruno);
        employees.add(evelin);
        
        List<Person> list = new ArrayList<>();
        
        Person magali = new Person("Magali", Education.HS);
        list.add(magali);
        Person thor = new Person("Thor", Education.HS);
        list.add(thor);
        Person agata = new Person("Agata", Education.PHD);
        list.add(agata);
        Person bacon = new Person("Bacon", Education.MA);
        list.add(bacon);
        Person bibi = new Person("Bibi", Education.MA);
        list.add(bibi);
        
        employees.add(list);
        
        employees.fire(Education.BA);
        
        employees.print();
    }
}

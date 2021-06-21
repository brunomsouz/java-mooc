
import java.util.List;
import java.util.ArrayList;

public class MainProgram {

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        
        Student first = new Student("jamo");
        Student second = new Student("jamol");
        Student third = new Student("Bruno");
        Student fourth = new Student("evelin");
        Student fifth = new Student("Zelia");
        
        students.add(first);
        students.add(second);
        students.add(third);
        students.add(fourth);
        students.add(fifth);
        
        students.sort(null);
        
        System.out.println(students);
    }
}

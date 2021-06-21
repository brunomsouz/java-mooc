
import java.util.Comparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MainProgram {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Book> books = readBooks(scanner);
        printBooks(books);
    }

    public static List<Book> readBooks(Scanner scanner) {
        List<Book> books = new ArrayList<>();
        
        while (true) {
            System.out.println("Input the name of the book, empty stops: ");
            String title = scanner.nextLine();
            
            if (title.isEmpty()) {
                break;
            }
            
            System.out.println("Input the age recommendation: ");
            int age = Integer.valueOf(scanner.nextLine());
            
            books.add(new Book(title, age));
        }
        
        return books;
    }
    
    public static void printBooks(List<Book> books) {
        System.out.format("%d book%s in total.", books.size(), books.size() != 1 ? "s" : "");
        
        System.out.println("\n\nBooks: ");
        
        Comparator<Book> comparator = Comparator
                .comparing(Book::getAgeRecommendation)
                .thenComparing(Book::getTitle);
        
//        Collections.sort(books, comparator);
        
//        books.stream().forEach(book -> System.out.println(book));
        
        books.stream().sorted(comparator).forEach(book -> System.out.println(book));
    }
}

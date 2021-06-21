import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Books> listOfBooks = new ArrayList<>();
        
        while (true) {
            System.out.println("Title: ");
            String title = scanner.nextLine();
            
            if (title.isEmpty()) {
                break;
            }
            
            System.out.println("Pages: ");
            int numberOfPages = Integer.valueOf(scanner.nextLine());
            System.out.println("Publication year: ");
            int publicationYear = Integer.valueOf(scanner.nextLine());
            
            listOfBooks.add(new Books(title, numberOfPages, publicationYear));
        }
        
        System.out.println("What information will be printed? ");
        String info = scanner.nextLine();
        
        for (Books book: listOfBooks) {
            if ("everything".equals(info)) {
                System.out.println(book);
            } else if ("name".equals(info)) {
                System.out.println(book.getTitle());
            } else if ("pages".equals(info)) {
                System.out.println(book.getNumberOfPages());
            } else if ("publication year".equals(info)) {
                System.out.println(book.getPublicationYear());
            }
        }
    }
}

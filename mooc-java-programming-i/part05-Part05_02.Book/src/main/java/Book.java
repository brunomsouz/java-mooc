/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bruno
 */
public class Book {
    private String author;
    private String title;
    private int numberOfPages;
    
    public Book(String author, String title, int numberOfPages) {
        this.author = author;
        this.title = title;
        this.numberOfPages = numberOfPages;
    }
    
    public String getAuthor() {
        return this.author;
    }
    
    public String getName() {
        return this.title;
    }
    
    public int getPages() {
        return this.numberOfPages;
    }
    
    public String toString() {
        return this.author + ", " + this.title + ", " + this.numberOfPages + " pages";
    }
}

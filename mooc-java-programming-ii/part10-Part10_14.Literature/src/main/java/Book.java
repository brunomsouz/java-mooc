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
    private String title;
    private int ageRecommendation;

    public Book(String name, int ageRecommendation) {
        this.title = name;
        this.ageRecommendation = ageRecommendation;
    }
    
    public String getTitle() {
        return title;
    }
    
    public int getAgeRecommendation() {
        return ageRecommendation;
    }
    
    @Override
    public String toString() {
        return title + "(recommended for " + ageRecommendation + " year-olds or older)";
    }
    
}

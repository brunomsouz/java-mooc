/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bruno
 */
public class Literacy implements Comparable<Literacy> {
    private final String country;
    private final int year;
    private final String gender;
    private final double rate;

    public Literacy(String country, int year, String gender, double rate) {
        this.country = country;
        this.year = year;
        this.gender = gender;
        this.rate = rate;
    }


    
    public String getCountry() {
        return country;
    }
    
    public int getYear() {
        return year;
    }
    
    public String getGender() {
        return gender;
    }
    
    public double getRate() {
        return rate;
    }
    
    @Override
    public int compareTo(Literacy compared) {
        if (this.rate < compared.rate) {
            return -1;
        } else if (this.rate > compared.rate) {
            return 1;
        } else {
            return 0;
        }
    }
    
    @Override
    public String toString() {
        return country + " (" + year + "), " + gender + ", " + rate;
    }
}

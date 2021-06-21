/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bruno
 */
public class Team {
    private String name;
    private int gamesPlayed;
    private int wins;
    private int losses;
    
    public Team(String name) {
        this.name = name;
    }
    
    public String getName() {
        return this.name;
    }
    
    public int getGamesPlayed() {
        return this.gamesPlayed;
    }
    
    public int getWins() {
        return this.wins;
    }
    
    public int getLosses() {
        return this.losses;
    }
    
    public String toString() {
        return "Team: " + this.name + ", " + this.gamesPlayed + " games played: " + this.wins + " wins, " + this.losses + " losses";
    }
    
}

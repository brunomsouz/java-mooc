/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bruno
 */
public class Game {
    private String homeTeamName;
    private String visitingTeamName;
    private int homeTeamPlacar;
    private int visitingTeamPlacar;
    
    public Game(String homeTeamName, String visitingTeamName, int homeTeamPlacar, int visitingTeamPlacar) {
        this.homeTeamName = homeTeamName;
        this.visitingTeamName = visitingTeamName;
        this.homeTeamPlacar = homeTeamPlacar;
        this.visitingTeamPlacar = visitingTeamPlacar;
    }
    
    public String getHomeTeam() {
        return this.homeTeamName;
    }
    
    public String getVisitingTeam() {
        return this.visitingTeamName;
    }
    
    public String toString() {
        return this.homeTeamName + " x " + this.visitingTeamName + " = " + this.homeTeamPlacar + " x " + this.visitingTeamPlacar;
    }
    
    public String getWinner() {
        if (this.homeTeamPlacar > this.visitingTeamPlacar) {
            return this.homeTeamName;
        } else {
            return this.visitingTeamName;
        }
    }
}

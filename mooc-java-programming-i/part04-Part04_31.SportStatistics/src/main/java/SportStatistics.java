
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class SportStatistics {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("File: ");
        String file = scanner.nextLine();
        
        ArrayList<Game> gameStatistics = readStatisticsFromFile(file);
        
        System.out.println("Team: ");
        String team = scanner.nextLine();

        int gamesPlayed = 0;
        int wins = 0;
        int losses = 0;
        
        for (Game game: gameStatistics) {
            if ((game.getHomeTeam()).equals(team) || (game.getVisitingTeam().equals(team))) {
                gamesPlayed++;
                
                if ((game.getWinner()).equals(team)) {
                    wins++;
                } else {
                    losses++;
                }
            }
        }
        
        System.out.println("Games: " + gamesPlayed);
        System.out.println("Wins: " + wins);
        System.out.println("Losses: " + losses);
    }
    
    public static ArrayList<Game> readStatisticsFromFile(String file) {
        ArrayList<Game> listOfGames = new ArrayList<>();
        
        try (Scanner reader = new Scanner(Paths.get(file))) {
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                
                String[] parts = line.split(",");
                String homeTeamName = parts[0];
                String visitingTeamName = parts[1];
                int homeTeamPlacar = Integer.valueOf(parts[2]);
                int visitingTeamPlacar = Integer.valueOf(parts[3]);
                
                listOfGames.add(new Game(homeTeamName, visitingTeamName, homeTeamPlacar, visitingTeamPlacar));
            }
        } catch (Exception e) {
            System.out.println("Could not read file: " + file);
        }
        
        return listOfGames;
    } 

}

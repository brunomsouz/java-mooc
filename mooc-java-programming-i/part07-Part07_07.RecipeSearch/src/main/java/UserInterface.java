/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bruno
 */
import java.util.ArrayList;
import java.util.Scanner;
import java.nio.file.Paths;

public class UserInterface {

    private ArrayList<Recipe> recipes;
    private Scanner scanner;

    public UserInterface(ArrayList<Recipe> recipes, Scanner scanner) {
        this.recipes = recipes;
        this.scanner = scanner;
    }

    public void start() {
        System.out.println("File to read: ");
        String file = scanner.nextLine();
        fileReader(file);

        while (true) {
            System.out.println("Enter command: ");
            String input = scanner.nextLine();

            if (input.equals("stop")) {
                break;
            }

            processCommand(input);
        }
    }

    public void processCommand(String command) {
        if (command.equals("list")) {
            for (Recipe recipe : recipes) {
                System.out.println(recipe);
            }
        }
        
        if (command.equals("find name")) {
            System.out.println("Searched word: ");
            String word = scanner.nextLine();
            
            this.findRecipeByName(word);
        }
        
        if (command.equals("find cooking time")) {
            System.out.println("Max cooking time: ");
            int time = Integer.valueOf(scanner.nextLine());
            
            this.findRecipeByCookingTime(time);
        }
        
        if (command.equals("find ingredient")) {
            System.out.println("Ingredient: ");
            String ingredient = scanner.nextLine();
            
            this.findRecipeByIngredient(ingredient);
        }
    }

    public void fileReader(String file) {
        try ( Scanner reader = new Scanner(Paths.get(file))) {
            ArrayList<String> scannedRecipe = new ArrayList<>();

            while (reader.hasNextLine()) {
                String line = reader.nextLine();

                if (line.isEmpty()) {

                    addRecipeFromArray(scannedRecipe);
                    
                    scannedRecipe = new ArrayList<>();
                    continue;
                }

                scannedRecipe.add(line);
            }

            addRecipeFromArray(scannedRecipe);
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void addRecipeFromArray(ArrayList<String> array) {
        String name = array.remove(0);
        int cookingTime = Integer.valueOf(array.remove(0));

        this.recipes.add(new Recipe(name, cookingTime, array));
    }
    
    public void findRecipeByName(String word) {
        for (Recipe recipe: recipes) {
            if (recipe.getName().contains(word)) {
                System.out.println(recipe);
            }
        }
    }
    
    public void findRecipeByCookingTime(int time) {
        for (Recipe recipe: recipes) {
            if (recipe.getCookingTime() <= time) {
                System.out.println(recipe);
            }
        }
    }
    
    public void findRecipeByIngredient(String ingredient) {
        for (Recipe recipe: recipes) {
            if (recipe.ingredients.contains(ingredient)) {
                System.out.println(recipe);
            }
        }
    }
}

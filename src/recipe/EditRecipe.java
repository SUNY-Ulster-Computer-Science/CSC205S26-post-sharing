package recipe;

import java.util.Scanner;
import java.util.ArrayList;
import maindisplay.MainDisplay;

/**
 * This class provides the functionality to modify an existing Recipe object.
 * It prompts the user to selectively update different components of a recipe 
 * through a menu.
 */
public class EditRecipe {

	/**
     * This method displays a menu to the user for editing the attributes 
     * of a specific recipe. It handles input for strings (Title, Description),
     * lists (Ingredients, Steps), and category filtering (Tags).
     * 
     * @param scanner The Scanner object used for user input
     *                
     * @param recipe  The specific Recipe object instance that is updated.
     */
    public static void edit(Scanner scanner, Recipe recipe) {
    	// Displays the current recipe being edited
        System.out.println("\n--- Editing Recipe: " + recipe.getTitle() + " ---");
        
        // Displays the menu options to the user
        System.out.println("What would you like to edit?");
        System.out.println("1. Title");
        System.out.println("2. Ingredients");
        System.out.println("3. Description");
        System.out.println("4. Steps");
        System.out.println("5. Tags (Categories)");
        System.out.println("6. Cancel");
        System.out.print("Selection (hit 'enter' when finished): ");
        
        // Captures user's menu choice as a String
        String choice = scanner.nextLine();
        
        // Executes based on the user's choice
        switch (choice) {
            case "1":
            	// Prompts for title and then updates it
                System.out.print("Enter new title (hit 'enter' when finished): ");
                recipe.setTitle(scanner.nextLine());
                System.out.println("Title updated!");
                break;
                
            case "2":
                // Stores ingredients in Recipe class as an ArrayList
                ArrayList<String> newIngredients = new ArrayList<>();
                System.out.println("Write out the ingredient names and their measurements (Type 'END' when finished):");
                
                // Loops to allow for multiple ingredients to be inputed
                while (true) {
                    String input = scanner.nextLine();
                    // Stops the loop if user types "END"
                    if (input.equalsIgnoreCase("END")) break;
                    newIngredients.add(input);
                }
                // Saves the new list to the recipe object
                recipe.setIngredients(newIngredients);
                System.out.println("Ingredients updated!");
                break;
                
            case "3":
            	// Prompts for description and then updates it
                System.out.print("Please write out the description (hit 'enter' when finished): ");
                recipe.setDesc(scanner.nextLine());
                System.out.println("Description updated!");
                break;

            case "4":
            	// Stores a new list of steps
                ArrayList<String> newSteps = new ArrayList<>();
                System.out.println("Please write out the steps (Type 'END' when finished):");
                
                // Loops until "END" is entered
                while (true) {
                    String input = scanner.nextLine();
                    if (input.equalsIgnoreCase("END")) break;
                    newSteps.add(input);
                }
                // Updates recipe steps
                recipe.setSteps(newSteps);
                System.out.println("Steps updated!");
                break;

            case "5":
                // Calls the selectTags method from MainDisplay class
                System.out.println("Updating Tags...");
                ArrayList<Integer> tagChoices = MainDisplay.selectTags(scanner);
                
                // Creates a fresh boolean array and sets the chosen tags to true
                boolean[] newTags = {false, false, false, false, false, false, false};
                
                // Sets the boolean to true for all tags chosen by user
                for(int index : tagChoices) {
                    newTags[index] = true;
                }
                // Applies the new tag to the recipe
                recipe.setTags(newTags);
                System.out.println("Tags updated!");
                break;
                
            case "6":
            	// Exits without making changes
                System.out.println("Edit was cancelled.");
                break;
                
            default:
            	// Handle cases for any unrecognized user input
                System.out.println("Invalid selection. Please try again.");
                break;
        }
    }
}
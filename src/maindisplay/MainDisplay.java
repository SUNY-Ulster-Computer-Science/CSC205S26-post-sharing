package maindisplay;

import java.util.Scanner;
import java.util.ArrayList;
import recipe.*;

public class MainDisplay {
	
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        ArrayList<Recipe> recipes = new ArrayList<Recipe>();
	        

	        System.out.println("--- Welcome to Recipe World ---");
	        while(true) {
	        	// Main display page
		        System.out.println("\nPlease select what you would like to do:");
		        System.out.println("1. View Recipe");
		        System.out.println("2. Add Recipe");
		        System.out.println("3. Remove Recipe");
		        System.out.println("4. Save Recipe");
		        System.out.println("5. Close Application");
		        System.out.print("Please enter your selection here (1-5): ");
		        
		        
		        String selectionChoice = scanner.nextLine();
		        if(selectionChoice.equals("5"))
		        {
		        	break;
		        }

		        // Main selection choices
		        switch (selectionChoice) {
		            case "1":
		            	int recipeNum;
		                System.out.println("\n[Viewing Recipe]");
		                if(recipes.size() > 0) {
		                	for(int i = 0; i < recipes.size(); i++) {
		                		System.out.printf("%d. %s%n", i, (recipes.get(i)).getTitle());
		                	}
		                }
		                break;
		            case "2":
		                System.out.println("\n[Adding Recipe]");
		                Recipe newRecipe = AddRecipe.addRecipe(scanner);
		                recipes.add(newRecipe);
		                clear();
		                break;
		            case "3":
		                System.out.println("\n[Removing Recipe]");
		                displayCategoryMenu(scanner);
		                break;
		            case "4":
		            	System.out.println("...");
		            	break;
		            default:
		                System.out.println("Invalid selection. Please restart and choose 1-5.");
		        }
	        }
	        
	        System.out.println("Thank you for using Recipe World! See you soon. :)");
	        scanner.close();
	    }
    
	     // Method displays categories through user input
	    public static void displayCategoryMenu(Scanner scanner) {
	        System.out.println("Please select the recipe category:");
	        System.out.println("1. Breakfast");
	        System.out.println("2. Lunch");
	        System.out.println("3. Dinner");
	        System.out.println("4. Dessert");
	        System.out.println("5. Vegetarian");
	        System.out.println("6. Vegan");
	        System.out.println("7. Gluten-Free");
	        System.out.print("Please enter the recipe category here (1-7): ");

	        int categoryChoice = scanner.nextInt();

	        if (categoryChoice >= 1 && categoryChoice <= 7) {
	            System.out.println("Thank you. Now displaying recipes under category " + categoryChoice + "...");
	        } else {
	            System.out.println("Invalid category selection. Please enter a selection 1-7.");
	        }
	    }
	    
	    public static void clear() {
	    	for(int i = 0; i < 50; i++) {
	    		System.out.println("");
	    	}
	    }
}

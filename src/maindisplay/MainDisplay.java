package maindisplay;

import java.util.Scanner;
import java.util.ArrayList;
import recipe.*;
import java.util.InputMismatchException;

public class MainDisplay {
	
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        ArrayList<Recipe> recipes = new ArrayList<Recipe>();
	        ArrayList<Recipe> filteredRecipes = new ArrayList<Recipe>();
	        

	        System.out.println("--- Welcome to Recipe World ---");
	        while(true) {
	        	// Main display page
		        System.out.println("\nPlease select what you would like to do:");
		        System.out.println("1. View Recipe");
		        System.out.println("2. Add Recipe");
		        System.out.println("3. Edit Recipe");
		        System.out.println("4. Remove Recipe");
		        System.out.println("5. Save Recipe");
		        System.out.println("6. Filter Recipes");
		        System.out.println("7. Reset Filters");
		        System.out.println("8. Close Application");
		        System.out.print("Please enter your selection here (1-8): ");
		        
		        
		        String selectionChoice = scanner.nextLine();
		        if(selectionChoice.equals("8"))
		        {
		        	break;
		        }

		        // Main selection choices
		        switch (selectionChoice) {
		            case "1":
		            	System.out.println("\n[Viewing Recipe]");
		            	int selectionV = 0;
		                if(filteredRecipes.size() > 0) {
		                	selectionV = selectRecipe(scanner, filteredRecipes);
		                	(filteredRecipes.get(selectionV - 1)).printRecipe(scanner);
		                }
		                else if(recipes.size() > 0) {
		                	selectionV = selectRecipe(scanner, recipes);
		                	(recipes.get(selectionV - 1)).printRecipe(scanner);
		                }
		                else
		                {
		                	System.out.println("Please add Recipes to the list before viewing!");
		                }
		                break;
		                
		                
		            case "2":
		                System.out.println("\n[Adding Recipe]");
		                Recipe newRecipe = AddRecipe.addRecipe(scanner);
		                recipes.add(newRecipe);
		                clear();
		                break;
		                
		                
		            case "4":
		                System.out.println("\n[Removing Recipe]");
		                int selectionR = 0;
		                if(recipes.size() > 0) {
		                	selectionR = selectRecipe(scanner, recipes);
		                	//(recipes.get(selectionR - 1)).removeRecipe(scanner, recipes);
		                }
		                else
		                {
		                	System.out.println("Please add Recipes to the list before removing!");
		                }
		                break;
		                
		                
		            case "5":
		            	System.out.println("...");
		            	break;
		            	
		            	
		            case "6":
		            	ArrayList<Integer> tags = new ArrayList<Integer>();
		            	filteredRecipes.clear();
		            	tags = selectTags(scanner);
		            	boolean filter = true;
		            	for(Recipe recipe : recipes) {
		            		for(int tag : tags) {
		            			if(recipe.tagValue(tag)) {
		            				filter = true;
		            			}
		            			else {
		            				filter = false;
		            				break;
		            			}
		            		}
		            		if(filter) {
		            			filteredRecipes.add(recipe);
		            		}
		            	}
		            	System.out.println("Recipes succesfully filtered!");
		            	System.out.println("\n");
		            	break;
		            	
		            	
		            case "7":
		            	clear();
		            	System.out.println("Filters Reset");
		            	filteredRecipes.clear();
		            	break;
		            	
		            	
		            default:
		                System.out.println("Invalid selection. Please restart and choose 1-8.");
		        }
	        }
	        
	        System.out.println("Thank you for using Recipe World! See you soon. :)");
	        scanner.close();
	    }
    
	    /**
	     * This method prints out the list of scanners 
	     * @param scanner
	     */
	    public static ArrayList<Integer> selectTags(Scanner scanner) {
	        System.out.println("Please select the recipe category:");
	        System.out.println("1. Breakfast");
	        System.out.println("2. Lunch");
	        System.out.println("3. Dinner");
	        System.out.println("4. Dessert");
	        System.out.println("5. Vegetarian");
	        System.out.println("6. Vegan");
	        System.out.println("7. Gluten-Free");
	        
	        ArrayList<Integer> tagSelections = new ArrayList<Integer>();
	        boolean going = true;
	        while(going) {
	        	System.out.println("Please enter the tag category you would like to filter here (1-7): ");
	        	System.out.println("When you are done inputting tags please input END");
	        	
	        	String tagSelection = scanner.nextLine();
	        	if(tagSelection.equalsIgnoreCase("end")) {
	        		going = false;
	        	}
	        	
	        	switch (tagSelection) {
	        		case "1":
	        			tagSelections.add(0);
	        			break;
	        		case "2":
	        			tagSelections.add(1);
	        			break;
	        		case "3":
	        			tagSelections.add(2);
	        			break;
	        		case "4":
	        			tagSelections.add(3);
	        			break;
	        		case "5":
	        			tagSelections.add(4);
	        			break;
	        		case "6":
	        			tagSelections.add(5);
	        			break;
	        		case "7":
	        			tagSelections.add(6);
	        			break;
	        		default: 
	        			System.out.println("Please input a valid tag selection");
	        	}
	        }
			return tagSelections;
	    }
	    
	    /**
	     * This is a void method that works to view the list of recipes and prompt the user to choose a recipe to view
	     * It then uses the printRecipe method from the Recipe class in order to print out the entire recipe chosen by the
	     * user
	     * @param scanner This parameter is used to avoid issues with using multiple scanner objects
	     * It also handles user input within the method
	     * @param recipes This is the list of recipes that will be shown as options for the user to choose from
	     */
	    public static int selectRecipe(Scanner scanner, ArrayList<Recipe> recipes){
	    	int recipeNum = 0;
	    	for(int i = 0; i < recipes.size(); i++) {
        		System.out.printf("%d. %s%n", i + 1, (recipes.get(i)).getTitle());
        	}
        	boolean valid = false;
        	System.out.println("Which Recipe would you like to view? (Input the number)");
        	while(!valid) {
        		try {
            		recipeNum = scanner.nextInt();
            		if(recipeNum > 0 && recipeNum <= recipes.size()) {
            			valid = true;
            		}
            		else {
            			System.out.println("Please input a valid number");
            		}
            	}
            	catch(InputMismatchException e) {
            		System.out.println("Please input a valid number");
            	}
        	}
        	return recipeNum;
	    }
	    
	    /**
	     * This method emulates clearing the console since Eclipse does not have an escape command
	     * It does so by printing 50 blank lines using println
	     */
	    public static void clear() {
	    	for(int i = 0; i < 50; i++) {
	    		System.out.println("");
	    	}
	    }
	    
	    public static void clear() {
	    	for(int i = 0; i < 50; i++) {
	    		System.out.println("");
	    	}
	    }
}

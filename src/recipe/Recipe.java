package recipe;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class is meant to represent a recipe with all of the key data points such as a title, description, ingredient list and
 * step list both represented as Array Lists with the string typing
 */
public class Recipe {
	
	//Instance variables
	String title;
	String description;
	ArrayList<String> ingredients = new ArrayList<String>();
	ArrayList<String> steps = new ArrayList<String>();
	boolean[] tags = {false, false, false, false, false, false, false};
	
	
	//Constructor 
	public Recipe(String title, String description, ArrayList<String> ingredients, ArrayList<String> steps, boolean[] tags) {
		this.title = title;
		this.description = description;
		this.ingredients = ingredients;
		this.steps = steps;
		this.tags = tags;
	}
	
	/**
	 * This method returns the title for an instance of the recipe class
	 * @return String title
	 */
	public String getTitle(){
		return this.title;
	}
	
	/**
	 * This method sets a new title for an instance of the recipe class
	 * @param String newTitle
	 */
	public void setTitle(String newTitle) {
		this.title = newTitle;
	}
	
	/**
	 * This method returns the description for an instance of the recipe class
	 * @return String description
	 */
	public String getDesc(){
		return this.description;
	}
	
	/**
     * This method returns the list of ingredients for the recipe
     * @return ArrayList of strings containing ingredients
     */
    public ArrayList<String> getIngredients() {
        return this.ingredients;
    }

    /**
     * This method updates the entire list of ingredients for the recipe
     * @param newIngredients ArrayList of strings containing the new ingredients
     */
    public void setIngredients(ArrayList<String> newIngredients) {
        this.ingredients = newIngredients;
    }
    
    /**
     * This method returns the list of directions for the recipe
     * @return ArrayList of strings containing steps
     */
    public ArrayList<String> getSteps() {
        return this.steps;
    }

    /**
     * This method updates the entire list of preparation steps for the recipe
     * @param newSteps ArrayList of strings containing the new directions
     */
    public void setSteps(ArrayList<String> newSteps) {
        this.steps = newSteps;
    }
    
    /**
     * This method returns the entire array of category tags
     * @return boolean array of tags
     */
    public boolean[] getTags() {
        return this.tags;
    }
	
    /**
     * This method updates the category tags for the recipe
     * @param newTags A boolean array where each index represents a specific category (e.g., Breakfast, Vegan)
     */
    public void setTags(boolean[] newTags) {
        this.tags = newTags;
    }
    
	/**
	 * This method sets a new description for an instance of the recipe class
	 * @param String newDesc 
	 */
	public void setDesc(String newDesc) {
		this.description = newDesc;
	}
	
	public boolean tagValue(int index) {
		return this.tags[index];
	}
	
	/**
	 * This method will override the print method in order to print the recipe in steps
	 * It will use both the listIngredients method and the listSteps method in order to print the recipe in steps
	 * @return
	 */
	public void printRecipe(Scanner input) {
		//First print the title, then a break and then the description of the recipe
		System.out.printf("Title- %s%nDescription- %s", this.title, this.description);
		input.nextLine();
		
		//Then print a break and a header
		System.out.printf("%nIngredients-%n");
		//Then call the listIngredients method
		listIngredients();
		input.nextLine();
		
		//Finally print a header and then use the listSteps method to list the steps of the recipe
		System.out.printf("Directions-%n");
		listSteps(input);
	}
	
	/**
	 * This method lists the ingredients within the recipe object with a number before each
	 */
	private void listIngredients() {
		//This int is used to keep a counter of the ingredient number
		int x = 1;
		
		//Use a for each loop and print out each ingredient with a line break and a numbering
		for(String ingredient : ingredients) {
			System.out.printf("%d. %s%n", x, ingredient);
			x++;
		}
	}
	
	/**
	 * This method lists the steps within the recipe object
	 * It uses the scanner class in order to use user input to require the user to click enter in order to view the next steps
	 */
	private void listSteps(Scanner stepList) {
		//This int is used to count the step number
		int y = 1;
		
		//Use a for each loop and print out the step with the step number
		for(String step : steps) {
			System.out.printf("Step %d- %s", y, step);
			y++;
			stepList.nextLine();
			//Then wait for user input before printing the next step
		}
	}
}

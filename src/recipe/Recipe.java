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
	 * This method sets a new description for an instance of the recipe class
	 * @param String newDesc 
	 */
	public void setDesc(String newDesc) {
		this.title = newDesc;
	}
	
	/**
	 * This method will override the print method in order to print the recipe in steps
	 * It will use both the listIngredients method and the listSteps method in order to print the recipe in steps
	 * @return
	 */
	public void printRecipe() {
		//This scanner is used in order to require user input to view the next section of the recipe
		Scanner input = new Scanner(System.in);
		
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
		listSteps();
	
		input.close();
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
	private void listSteps() {
		//This scanner is used to require user input to display the next step
		Scanner stepList = new Scanner(System.in);
		//This int is used to count the step number
		int y = 1;
		
		//Use a for each loop and print out the step with the step number
		for(String step : steps) {
			System.out.printf("Step %d- %s", y, step);
			y++;
			stepList.nextLine();
			//Then wait for user input before printing the next step
		}
		
		stepList.close();
	}
}

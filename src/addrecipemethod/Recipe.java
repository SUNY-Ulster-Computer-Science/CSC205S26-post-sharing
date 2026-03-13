package addrecipemethod;
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
	
	//Constructor 
	public Recipe(String title, String description, ArrayList<String> ingredients, ArrayList<String> steps) {
		this.title = title;
		this.description = description;
		this.ingredients = ingredients;
		this.steps = steps;
	}
	
	/**
	 * This method will override the print method in order to print the recipe in steps
	 * It will use both the listIngredients method and the listSteps method in order to print the recipe in steps
	 * @return
	 */
	public void Print() {
		
	}
	
	/**
	 * This method lists the ingredients within the recipe object with a number before each
	 */
	private void listIngredients() {
		int x = 1;
		
		for(String ingredient : ingredients) {
			System.out.printf("%d. %s, x, ingredient%n");
			x++;
		}
	}
	
	/**
	 * This method lists the steps within the recipe object
	 * It uses the scanner class in order to use user input to require the user to click enter in order to view the next steps
	 */
	private void listSteps() {
		Scanner stepList = new Scanner(System.in);
		int y = 1;
		
		for(String step : steps) {
			System.out.printf("Step %d- %s, y, step");
			y++;
			stepList.next();
		}
		
		stepList.close();
	}
}

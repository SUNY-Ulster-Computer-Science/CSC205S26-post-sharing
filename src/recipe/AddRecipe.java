package recipe;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class AddRecipe {
	
	
	public static Recipe addRecipe(Scanner input) {		
		System.out.println("Firstly, what would you like to title your recipe?");
		String title = input.nextLine();
		
		System.out.println("Next, please write a brief description of your recipe.");
		String description = input.nextLine();
		
		ArrayList<String> ingredients = new ArrayList<String>();
		System.out.println("Next will be your list of ingredients");
		while(true) {
			System.out.println("Input your ingredient name as well as measurement then press enter. \nIf you would like to finish inputting ingredients please input- END");
			String userIngredient = input.nextLine();
			if(userIngredient.equalsIgnoreCase("END")){
				break;
			}
			else {
				ingredients.add(userIngredient);
			}
		}
		
		ArrayList<String> steps = new ArrayList<String>();
		System.out.println("Next will be the steps for your recipe");
		while(true) {
			System.out.println("Please write out the current step. \nIf you would like to finish writing steps please input- END");
			String userStep = input.nextLine();
			if(userStep.equalsIgnoreCase("END")){
				break;
			}
			else {
				steps.add(userStep);
			}
		}
		
		boolean[] newTags = {false, false, false, false, false, false, false};
		System.out.println("Finally, lets add a tag to your recipe so you can find it easier later");
		while(true) {
			System.out.println("To choose a tag please input the number next to it.");
			System.out.println("1. Breakfast\n2. Lunch\n3. Dinner\n4. Dessert\n5. Vegetarian\n6. Vegan\n7. Gluten Free");
			try {
				int tag = input.nextInt();
				if(tag > 0 && tag <= 7) {
					newTags[tag - 1] = true;
				}
				else {
					System.out.println("Please input a valid number 1-7");
				}
			}
			catch(InputMismatchException e) {
				System.out.println("Please input a valid number 1-7");
			}
			
			System.out.println("Would you like to add another tag? Input yes");
			String cont = input.nextLine();
			if(cont.equalsIgnoreCase("yes")) {
			}
			else
			{
				break;
			}
		}
		
		input.nextLine();
		Recipe newRecipe = new Recipe(title, description, ingredients, steps, newTags);
		
		System.out.printf("Your recipe for %s has been sucessfully added to the database! Press enter to continue to the main menu", newRecipe.getTitle());
		input.nextLine();
		
		return newRecipe;
	}
}
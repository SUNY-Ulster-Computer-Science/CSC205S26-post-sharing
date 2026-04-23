package recipe;
import java.util.Scanner;
import java.util.ArrayList;

public class AddRecipe {
	
	public static Recipe addRecipe() {
		Scanner input = new Scanner(System.in);
		
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
		
		
		
		Recipe newRecipe = new Recipe(title, description, ingredients, steps, newTags);
		
		input.close();
		return newRecipe;
	}
}


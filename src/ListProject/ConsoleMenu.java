package ListProject;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Command Pattern: Invoker - User Interface
 * 
 * @author alissamonroe
 * @version 10/14/17
 */

public class ConsoleMenu {

	/**
	 * Instance variable to create an ArrayList of type MenuItem - Establishing
	 * connection between Invoker and Command
	 */
	public ArrayList<MenuItem> consoleMenu;
		
	/** Constructor */
	public ConsoleMenu() {
		consoleMenu = new ArrayList<MenuItem>();
	}

	/** Setter for consoleMenu */
	public void setMenu(ArrayList<MenuItem> menu) {
		consoleMenu = menu;
	}

	/** Running the user interface - Prompt user and execute accordingly */
	public void run() {
		Scanner input = new Scanner(System.in);
		while (true) {
			try {
				System.out.println("String and Number List Menu");
				
				for (int i = 0; i < consoleMenu.size(); i++) {
					System.out.print(i + 1);
					System.out.println(": " + consoleMenu.get(i)); // Print text for that particular menu item
				}
				
				System.out.println("Please pick an option: ");
				int option = input.nextInt(); // Option from menu as entered by user
				option -= 1; // Because ArrayList starts at index 0
				
				consoleMenu.get(option).execute(); // Execute relevant option
			} catch (InputMismatchException e) {
				input.nextLine();
				System.out.println("Please select a valid option \n");
			} catch (Exception e) {
				input.nextLine();
				System.out.println("Please select a valid option \n");
			}
		}
	}
	
	/** Adding further options for string list or number list to the menu */
	public void extendMenu(MenuItem menuItem) {
		MenuItem copyLastItem = consoleMenu.get(consoleMenu.size()-1); // Copy of the last item in the menu (Quit)
		consoleMenu.remove(consoleMenu.size()-1); // Remove last item in the menu
		consoleMenu.add(menuItem); // Add further options for either string list or number list
		consoleMenu.add(copyLastItem); // Add copy back into the menu (this is so that the Quit option always shows at the end of the menu)
	}

}
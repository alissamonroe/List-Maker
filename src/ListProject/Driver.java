package ListProject;
import java.util.ArrayList;

/**
 * Command Pattern: Client
 * 
 * @author alissamonroe
 * @version 10/14/17
 */

public class Driver {

	/** Instance object for ConsoleMenu - the Invoker, whose purpose is to be the user interface */
	private static ConsoleMenu invoker;

	/** Instance object for ListTracker - whose purpose is to keep track of the number of the list */
	private static ListTracker tracker;
	
	public static void main(String[] args) {
		// Instantiating tracker
		tracker = new ListTracker();
		
		// Instantiating Invoker - Establishing connection between Client & Invoker
		invoker = new ConsoleMenu();
		invoker.setMenu(makeMenu()); // Set menu in Invoker to menu created here
		invoker.run(); // Run user interface		
	}

	/** Creating the options menu */
	public static ArrayList<MenuItem> makeMenu() {
		// Creating an ArrayList of the initial commands
		ArrayList<MenuItem> menu = new ArrayList<MenuItem>();
		
		AddStringList addStringList = new AddStringList(invoker, tracker); // Object for making a new string list
		AddNumberList addNumberList = new AddNumberList(invoker, tracker); // Object for making a new number list
		Quit quit = new Quit(); // Object for quitting
		
		// Add above objects (Commands) to the initial menu
		menu.add(addStringList);
		menu.add(addNumberList);
		menu.add(quit);

		return menu;
	}
}

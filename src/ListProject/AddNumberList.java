package ListProject;
/**
 * Command Pattern: Concrete Command - Implements Command (MenuItem)
 * AddStringList enables the user to make a new number list
 * 
 * @author alissamonroe
 * @version 10/25/17
 */

public class AddNumberList implements MenuItem {
	
	/** Instance object for ConsoleMenu */
	private ConsoleMenu consoleMenu;
	
	/** Instance object for ListTracker */
	private ListTracker tracker;
	
	/** Instance object for the list to be executed - Establishing connection between relevant Receiver and this Command */
	private NumberList list;
	
	/** Instance variable for the list number */
	private int listNum;
	
	/** Constructor */
	public AddNumberList(ConsoleMenu newConsoleMenu, ListTracker newTracker) {
		consoleMenu = newConsoleMenu;
		tracker = newTracker;
		list = new NumberList();
		listNum = 0;
	}
	
	/** The command here: add the further menu options for Number List into the menu */
	public void execute() {	
		list = new NumberList(); // Create a new number list
		listNum = tracker.provideListNum(); // Number of the new list
		
		EnterNumber enterNumber = new EnterNumber(list, listNum);
		PrintList printNumberList = new PrintList(list, listNum);
		ClearList clearNumberList = new ClearList(list, listNum);
		ReturnLargestNumber returnLargest = new ReturnLargestNumber(list, listNum);

		consoleMenu.extendMenu(enterNumber);
		consoleMenu.extendMenu(printNumberList);
		consoleMenu.extendMenu(clearNumberList);
		consoleMenu.extendMenu(returnLargest);
	}
	
	public String toString () {
		return "Add Number List";
	}

}

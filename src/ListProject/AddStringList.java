package ListProject;
/**
 * Command Pattern: Concrete Command - Implements Command (MenuItem)
 * AddStringList enables the user to make a new string list
 * 
 * @author alissamonroe
 * @version 10/25/17
 */

public class AddStringList implements MenuItem {
	
	/** Instance object for ConsoleMenu */
	private ConsoleMenu consoleMenu;
	
	/** Instance object for ListTracker */
	private ListTracker tracker;
	
	/** Instance object for the list to be executed - Establishing connection between relevant Receiver and this Command */
	private StringList list;
	
	/** Instance variable for the list number */
	private int listNum;
	
	/** Constructor */
	public AddStringList(ConsoleMenu newConsoleMenu, ListTracker newTracker) {
		consoleMenu = newConsoleMenu;
		tracker = newTracker;
		list = new StringList();
		listNum = 0;
	}
	
	/** The command here: add the further menu options for String List into the menu */
	public void execute() {	
		list = new StringList(); // Create a new string list
		listNum = tracker.provideListNum(); // Number of the new list
		
		EnterWord enterString = new EnterWord(list, listNum);
		PrintList printStringList = new PrintList(list, listNum);
		ClearList clearStringList = new ClearList(list, listNum);
		SortList sortStringList = new SortList(list, listNum);

		consoleMenu.extendMenu(enterString);
		consoleMenu.extendMenu(printStringList);
		consoleMenu.extendMenu(clearStringList);
		consoleMenu.extendMenu(sortStringList);
	}
	
	public String toString () {
		return "Add String List";
	}

}

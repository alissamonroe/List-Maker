package ListProject;
/**
 * Command Pattern: Concrete Command - Implements Command (MenuItem)
 * SortList sorts the chosen list in alphabetical order
 * 
 * @author alissamonroe
 * @version 10/14/17
 */

public class SortList implements MenuItem {
	
	/** Instance object for the list to be executed - Establishing connection between relevant Receiver and this Command */
	private StringList list;
	
	/** Instance variable for the list number */
	private int listNum;

	/** Constructor */
	public SortList(StringList newList, int newListNum) {
		list = newList;
		listNum = newListNum;
	}

	/** The command here: sort the relevant list (as chosen by the user through the menu) */
	public void execute() {
		list.sortList();
		System.out.println("List " + listNum + " is now sorted. \n");
	}
	
	public String toString() {		
		return "Sort List " + listNum;
	}
	
}

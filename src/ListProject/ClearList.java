package ListProject;
/**
 * Command Pattern: Concrete Command - Implements Command (MenuItem) ClearList
 * clears/empties the chosen list
 * 
 * @author alissamonroe
 * @version 10/14/17
 */

public class ClearList implements MenuItem {
	
	/** Instance variable for the list to be executed - Establishing connection between relevant Receiver and this Command  */
	private List list;

	/** Instance variable for the list number */
	private int listNum;
	
	/** Constructor */
	public ClearList(List newList, int newListNum) {
		list = newList;
		listNum = newListNum;
	}

	/** The command here: clear/empty the relevant list (as chosen by the user through the menu) */
	public void execute() {
		list.clearList();
		System.out.println("List " + listNum + " is now empty \n");
	}

	public String toString() {
		return "Clear List " + listNum;
	}

}

package ListProject;
/**
 * Command Pattern: Concrete Command - Implements Command (MenuItem)
 * PrintList prints out the chosen string list in its current state
 * 
 * @author alissamonroe
 * @version 10/14/17
 */

public class PrintList implements MenuItem {
	
	/** Instance variable for the list to be executed - Establishing connection between relevant Receiver and this Command */
	private List list;
	
	/** Instance variable for the list number */
	private int listNum;
	
	/** Constructor */
	public PrintList(List newList, int newListNum) {
		list = newList;
		listNum = newListNum;
	}

	/** The command here: print out the relevant list (as chosen by the user through the menu) */
	public void execute() {
		System.out.print("List " + listNum + " is " + "{" + list.printList() + "} \n\n");
	}

	public String toString() {
		return "Print List " + listNum;
	}

}

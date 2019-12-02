package ListProject;
/**
 * Command Pattern: Concrete Command - Implements Command (MenuItem)
 * ReturnLargestNumber gives the largest number in the chosen number list
 * 
 * @author alissamonroe
 * @version 10/23/17
 */

public class ReturnLargestNumber implements MenuItem {

	/** Instance object for the list to be executed - Establishing connection between relevant Receiver and this Command */
	private NumberList list;
	
	/** Instance variable for the list number */
	private int listNum;
	
	/** Constructor */
	public ReturnLargestNumber(NumberList newList, int newListNum) {
		list = newList;
		listNum = newListNum;
	}

	/** The command here: print out the largest number in the list */
	public void execute() {
		try {
			Number numToPrint = list.largestNum();
			
			if (numToPrint.equals(numToPrint.intValue())) { // If the largest number is an integer
				System.out.print("Biggest number in List " + listNum + " is " + numToPrint.intValue() + "\n\n");
			} else if (numToPrint.equals(numToPrint.doubleValue())) { // If the  largest number is a double
				System.out.print("Biggest number in List " + listNum + " is " + numToPrint.doubleValue() + "\n\n");
			}
		} catch (IndexOutOfBoundsException e) { // When there's nothing in the list & user tries to find a largest number
			System.out.println("List " + listNum + " is empty\n");
		}
	}

	public String toString() {
		return "Return biggest number in List " + listNum;
	}

}

package application;

import javafx.scene.control.Alert;

/**
 * ReturnLargestNumber: Concrete Command - Implements Command (MenuItem)
 * Gives the largest number in the chosen number list
 * 
 * MVC - Controller
 * 
 * @author alissamonroe
 */

public class ReturnLargestNumber implements MenuItem {

	/**
	 * Adapter object (because this class needs to communicate with the Adapter
	 * in order to return the largest number in a NumberList)
	 */
	private Adapter<?> adapter;

	/** The name of the list */
	private String title;

	/** Constructor */
	public ReturnLargestNumber(Adapter<?> newAdapter, String newTitle) {
		adapter = newAdapter;
		title = newTitle;
	}

	/** The command here: print out the largest number in the list */
	public void execute() {
		if (adapter.size() == 1) {
			Alert invalidAlert = new Alert(Alert.AlertType.ERROR, "The list is empty");
			invalidAlert.showAndWait();
		} else {
			Number numToPrint = adapter.largestNum();
			if (numToPrint.equals(numToPrint.intValue())) { // If the largest number is an integer
				numToPrint = numToPrint.intValue();
			} else if (numToPrint.equals(numToPrint.doubleValue())) { // If the largest number is a double
				numToPrint = numToPrint.doubleValue();
			}
		}
	}

	public String toString() {
		return "Return biggest number in List " + title;
	}

}

package application;

import javafx.scene.control.Alert;

/**
 * AdapterNumber (Child of Adapter): This exists as a child of Adapter
 * because there are differences between StringList and NumberList in the doSet
 * method, which is a required method in this case used to serve as the method
 * that adds items to the list. doSet here takes in a String and then converts
 * that String into a Number so that the item can be added to a number list.
 * 
 * MVC - Controller
 * 
 * @author alissamonroe
 */

public class AdapterNumber extends Adapter<Number> {

	/** Constructor */
	public AdapterNumber(ParentList<Number> newList) {
		super(newList);
	}

	/** To add numbers into the list */
	protected String doSet(int index, String element) {
		try {
			// If the number is an integer
			Integer number = Integer.parseInt(element);
			list.addTo(number);
		} catch (NumberFormatException e) {
			// If the number is a double
			try {
				Double number = Double.parseDouble(element);
				list.addTo(number);
			} catch (NumberFormatException e2) {
				Alert invalidAlert = new Alert(Alert.AlertType.ERROR, "Invalid input: Please enter a number");
				invalidAlert.showAndWait();
			}
		}
		return element;
	}

}

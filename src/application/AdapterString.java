package application;

import javafx.scene.control.Alert;

/**
 * AdapterString (Child of Adapter): This exists as a child of Adapter
 * because there are differences between StringList and NumberList in the doSet
 * method, which is a required method in this case used to serve as the method
 * that adds items to the list. doSet here takes in a String and then adds that
 * into the list.
 * 
 * MVC - Controller
 * 
 * @author alissamonroe
 */

public class AdapterString extends Adapter<String> {

	/** Constructor */
	public AdapterString(ParentList<String> newList) {
		super(newList);
	}

	/** To add strings into the list */
	protected String doSet(int index, String element) {
		if (element.equals("")) {
			Alert invalidAlert = new Alert(Alert.AlertType.ERROR, "Invalid input: Empty string");
			invalidAlert.showAndWait();
		} else {
			list.addTo(element);
		}
		return element;
	}

}

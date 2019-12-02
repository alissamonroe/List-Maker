package application;

import javafx.collections.ModifiableObservableListBase;
import javafx.scene.control.Alert;

/**
 * Adapter (Parent): This is my adapter class that stands between my list classes
 * (ParentList: String List, Number List) and ultimately ListView so that I can
 * have a ListView for the lists made. In other words, it handles the job of
 * translating between ListView -- >ObservableList Interface &
 * ModifiableObservableListBase and my list classes.
 * 
 * MVC - Controller
 * 
 * @author alissamonroe
 *
 */

public abstract class Adapter<T> extends ModifiableObservableListBase<String> {

	/** The list, either String or Number */
	protected ParentList<T> list;

	/** Constructor */
	public Adapter(ParentList<T> newList) {
		list = newList;
	}

	/**
	 * Getting a particular item at an index. Returns either a blank space (used
	 * for entering) or a space with whatever item is in the list at that index
	 */
	public String get(int index) {
		if (index == list.getListCount() - 1) {
			return "";
		} else {
			return "" + list.getItem(index);
		}
	}

	/** Returns the size of the list */
	public int size() {
		return list.getListCount();
	}

	/** To clear the list -- for both StringList and NumberList */
	public void clearList() {
		if (size() == 1) {
			Alert invalidAlert = new Alert(Alert.AlertType.ERROR, "The list is empty");
			invalidAlert.showAndWait();
		} else {
			beginChange();
			list.clearList();
			nextRemove(0, (String) null);
			endChange();
		}
	}

	/** To sort the list -- for StringList only */
	public void sortList() {
		if (size() == 1) {
			Alert invalidAlert = new Alert(Alert.AlertType.ERROR, "The list is empty");
			invalidAlert.showAndWait();
		} else {
			beginChange();
			((StringList) list).sortList();
			nextAdd(0, list.getListCount());
			endChange();
		}
	}

	/** To return the largest number in the list -- for NumberList only */
	public Number largestNum() {
		beginChange();
		((NumberList) list).largestNum();
		nextAdd(0, list.getListCount());

		Alert reportNum = new Alert(Alert.AlertType.INFORMATION,
				"The biggest number in the list is " + ((NumberList) list).largestNum());
		reportNum.showAndWait();

		endChange();

		return ((NumberList) list).largestNum();
	}

	/** Ignore - not needed */
	protected void doAdd(int index, String element) {
	}

	/** Ignore - not needed */
	protected String doRemove(int index) {
		return null;
	}

}
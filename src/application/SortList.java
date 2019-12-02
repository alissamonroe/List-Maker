package application;

/**
 * SortList: Concrete Command - Implements Command (MenuItem)
 * Sorts the chosen list in alphabetical order
 * 
 * MVC - Controller
 * 
 * @author alissamonroe
 */

public class SortList implements MenuItem {

	/**
	 * Adapter object (because this class needs to communicate with the Adapter
	 * in order to sort a StringList)
	 */
	private Adapter<?> adapter;

	/** The name of the list */
	private String title;

	/** Constructor */
	public SortList(Adapter<?> newAdapter, String newTitle) {
		adapter = newAdapter;
		title = newTitle;
	}

	/**
	 * The command here: sort the relevant list (as chosen by the user through
	 * the menu)
	 */
	public void execute() {
		adapter.sortList();
	}

	public String toString() {
		return "Sort List " + title;
	}

}

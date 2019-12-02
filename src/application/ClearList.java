package application;

/**
 * ClearList: Concrete Command - Implements Command (MenuItem)
 * Clears/empties the chosen list
 * 
 * MVC - Controller
 * 
 * @author alissamonroe
 */

public class ClearList implements MenuItem {

	/**
	 * Adapter object (because this class needs to communicate with the Adapter
	 * in order to clear a list (ParentList: NumberList or StringList)
	 */
	private Adapter<?> adapter;

	/** The name of the list */
	private String title;

	/** Constructor */
	public ClearList(Adapter<?> newAdapter, String newTitle) {
		adapter = newAdapter;
		title = newTitle;
	}

	/**
	 * The command here: clear/empty the relevant list (as chosen by the user
	 * through the menu)
	 */
	public void execute() {
		adapter.clearList();
	}

	public String toString() {
		return "Clear List " + title;
	}

}

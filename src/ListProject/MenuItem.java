package ListProject;
/**
 * Command Pattern: Command
 * All methods declared here must be present in all Concrete Commands,
 * which are all classes that implement this class
 * 
 * @author alissamonroe
 * @version 10/14/17
 */

public interface MenuItem {

	/** Method to execute the relevant commands */
	public void execute();

	/** Method to print out relevant text for the menu item */
	public String toString();

}

package ListProject;
/**
 * ListTracker keeps track of what number the list is and provides that number.
 * It also makes and returns a new string list & new number list everytime it is called.
 * 
 * @author alissamonroe
 * @version 10/25/17
 */
public class ListTracker {
	
	/** Instance variable that holds the number of the list */
	public int listNum;
	
	/** Instance object for StringList - to make a new string list */
	public StringList stringList;
	
	/** Instance object for NumberList - to make a new number list */
	public NumberList numberList;
	
	/** Constructor */
	public ListTracker() {
		listNum = 0;
	}
	
	/** Returns an int for the list number */
	public int provideListNum() {
		listNum++;
		return listNum;
	}

}

package ListProject;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Command Pattern: Receiver (String List)
 * 
 * @author alissamonroe
 * @version 10/14/17
 */

public class StringList implements List {

	/** Instance variable for the list that will hold words - It is an array list of strings */
	private ArrayList<String> list;
	
	/** Instance variable that keeps track of what number word to enter next into the list */
	private int wordCount;
	
	/** Instance variable that keeps track of the string to be printed (the list of words) */
	private String tempString;

	/** Constructor */
	public StringList() {
		list = new ArrayList<String>();
		setWordCount(1);
		tempString = "";
	}

	/** Getter for wordCount */
	public int getWordCount() {
		return wordCount;
	}

	/** Setter for wordCount */
	public void setWordCount(int wordCount) {
		this.wordCount = wordCount;
	}

	/** Method to add the word into the list */
	public void addTo(String newWord) {
		list.add(newWord);
		setWordCount(getWordCount() + 1);
	}

	/** Method to sort the list in alphabetical order */
	public void sortList() {
		Collections.sort(list);
	}

	/** Method to print the list in its current state */
	public String printList() {
		tempString = "";
		for (int i = 0; i < list.size(); i++) {
			if (i != 0)
				tempString += ", ";
			tempString += list.get(i);
		}
		return tempString;
	}

	/** Method to clear the entire list */
	public void clearList() {
		setWordCount(1);
		list.clear();
	}
}

package application;

import java.util.ArrayList;
import java.util.Collections;

/**
 * StringList: Serves as the model for MVC, contains all the relevant methods
 * that a string list is capable of
 * 
 * MVC - Model
 * 
 * @author alissamonroe
 */

public class StringList implements ParentList<String> {

	/**
	 * Instance variable for the list that will hold words - It is an array list
	 * of strings
	 */
	private ArrayList<String> list;

	/**
	 * Instance variable that keeps track of what number word to enter next into
	 * the list
	 */
	private int wordCount;

	/**
	 * Instance variable that keeps track of the string to be printed (the list
	 * of words)
	 */
	private String tempString;

	/** Constructor */
	public StringList() {
		list = new ArrayList<String>();
		setListCount(1);
		tempString = "";
	}

	/** Getter for wordCount */
	public int getListCount() {
		return wordCount;
	}

	/** Setter for wordCount */
	public void setListCount(int wordCount) {
		this.wordCount = wordCount;
	}

	/** Method to add the word into the list */
	public void addTo(String newWord) {
		list.add(newWord);
		setListCount(getListCount() + 1);
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
		setListCount(1);
		list.clear();
	}

	/** Gets the string at a particular index */
	public String getItem(int index) {
		String item = list.get(index);
		return item;
	}

}

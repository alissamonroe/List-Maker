package application;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * NumberList: Serves as the model for MVC, contains all the relevant methods
 * that a number list is capable of
 * 
 * MVC - Model
 * 
 * @author alissamonroe
 */

public class NumberList implements ParentList<Number> {

	/**
	 * Instance variable for the list that will hold numbers - It is an array
	 * list of numbers
	 */
	private ArrayList<Number> list;

	/**
	 * Instance variable that keeps track of what number number to enter next
	 * into the list
	 */
	private int numCount;

	/**
	 * Instance variable that keeps track of the string to be printed (the list
	 * of numbers)
	 */
	private String tempString;

	/** Constructor */
	public NumberList() {
		list = new ArrayList<Number>();
		setListCount(1);
		tempString = "";
	}

	/** Getter for numCount */
	public int getListCount() {
		return numCount;
	}

	/** Setter for numCount */
	public void setListCount(int numCount) {
		this.numCount = numCount;
	}

	/** Method to add the number into the list */
	public void addTo(Number item) {
		if (item.equals(item.intValue())) {
			list.add(item.intValue());
		} else if (item.equals(item.doubleValue())) {
			list.add(item.doubleValue());
		}
		setListCount(getListCount() + 1);
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

	/** Method to identify the largest element currently in the list */
	public Number largestNum() {
		Number largestNum = list.get(0);

		for (int i = 0; i < list.size(); i++) {
			if (compareTo(largestNum, list.get(i)) == -1) { // If largestNum is less than index i of list
				largestNum = list.get(i);
			}
		}

		return largestNum;
	}

	/**
	 * compareTo method: used to compare values in the list in largestNum method
	 */
	public int compareTo(Number n1, Number n2) {
		BigDecimal b1 = new BigDecimal(n1.doubleValue());
		BigDecimal b2 = new BigDecimal(n2.doubleValue());
		return b1.compareTo(b2);
	}

	/** Gets the number at a particular index */
	public Number getItem(int index) {
		Number item = list.get(index);
		return item;
	}

}

package ListProject;
import java.util.Scanner;

/**
 * Command Pattern: Concrete Command - Implements Command (MenuItem)
 * EnterWord enables the user to add words into the string list they choose
 * 
 * @author alissamonroe
 * @version 10/14/17
 */

public class EnterWord implements MenuItem {

	/** Instance object for the list to be executed - Establishing connection between relevant Receiver and this Command */
	private StringList list;
	
	/** Instance variable for the list number */
	private int listNum;

	/** Constructor */
	public EnterWord(StringList newList, int newListNum) {
		list = newList;
		listNum = newListNum;
	}

	/** The command here: add words into the relevant list (as chosen by the user through the menu) */
	public void execute() {
		Scanner input = new Scanner(System.in);

		System.out.println("\nEnter words into List " + listNum + " one at a time \n" + "Enter the word \"quit\" to stop \n");

		while (true) {
			System.out.print("Enter word " + list.getWordCount() + ": ");
			String word = input.next();

			if (word.equals("quit")) { // Stop adding words
				System.out.println("");
				break;
			} else if (!word.equals("")) { // Add word to list
				list.addTo(word);
			}
		}
	}

	public String toString() {
		return "Enter words into List " + listNum;
	}

}

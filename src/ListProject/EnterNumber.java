package ListProject;
import java.util.Scanner;

/**
 * Command Pattern: Concrete Command - Implements Command (MenuItem)
 * EnterNumber enables the user to add numbers into the number list they choose
 * 
 * @author alissamonroe
 * @version 10/23/17
 */

public class EnterNumber implements MenuItem {

	/** Instance object for the list to be executed - Establishing connection between relevant Receiver and this Command */
	private NumberList list;

	/** Instance variable for the list number */
	private int listNum;

	/** Constructor */
	public EnterNumber(NumberList newList, int newListNum) {
		list = newList;
		listNum = newListNum;
	}

	/** The command here: add numbers into the relevant list (as chosen by the user through the menu) */
	public void execute() {
		Scanner input = new Scanner(System.in);

		System.out.println("\nEnter numbers into List " + listNum + " one at a time \n" + "Enter the word \"quit\" to stop \n");

		while (true) {
			System.out.print("Enter number " + list.getNumCount() + ": ");
			String text = input.next();

			if (text.equals("quit")) { // Stop adding numbers
				System.out.println("");
				break;
			} else { // Add number to list
				try {
					// If the number is an integer
					Integer number = Integer.parseInt(text);
					list.addTo(number);
				} catch (NumberFormatException e) {
					// If the number is a double
					try {
						Double number = Double.parseDouble(text);
						list.addTo(number);
					} catch (NumberFormatException e2) {
						// If the number is anything other than an integer or double
						// Note: floats promote to double
						input.nextLine();
						System.out.println("Invalid Number");
					}
				}
			}	
		}
	}

	public String toString() {
		return "Enter numbers into List " + listNum;
	}

}

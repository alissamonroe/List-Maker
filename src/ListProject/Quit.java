package ListProject;
/**
 * Command Pattern: Concrete Command - Implements Command (MenuItem)
 * Quit ends the program
 * 
 * @author alissamonroe
 * @version 10/14/17
 */

public class Quit implements MenuItem {
	
	/** The command here: end the program */
	public void execute() {
		System.exit(0);	
	}
	
	public String toString() {
		return "Quit";
		
	}

}

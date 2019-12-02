package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

/**
 * CommandButton: Creates buttons for various commands and executes
 * relevant commands upon the user pressing them
 * 
 * MVC - View
 * 
 * @author alissamonroe
 *
 */

public class CommandButton extends Button implements EventHandler<ActionEvent> {

	/** The command for which a button is to be created for */
	private MenuItem command;

	/** Constructor */
	public CommandButton(MenuItem newCommand) {
		super(newCommand.toString());
		command = newCommand;
		setOnAction(this);
	}

	/** Run the execute method for the command when the user hits the button */
	public void handle(ActionEvent event) {
		command.execute();
	}
}

package application;

import javafx.application.Application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 * InitialWindow: The main view class which enables the user to name the
 * list and either create a StringList or NumberList
 * 
 * MVC - View
 * 
 * @author alissamonroe
 *
 */

public class InitialWindow extends Application implements EventHandler<ActionEvent> {

	/** Label providing instructions */
	private Label label;

	/** Textfield to enter the name of the list */
	private TextField listName;

	/**
	 * CommandButton (button) & AddStringList (command) to create a button
	 * enabling user to create a StringList
	 */
	private CommandButton addStringListButton;
	private AddStringList addStringList;

	/**
	 * CommandButton (button) & AddNumberList (command) to create a button
	 * enabling user to create a NumberList
	 */
	private CommandButton addNumListButton;
	private AddNumberList addNumberList;

	/** ListViewer object */
	private ListViewer<?> list;

	/**
	 * Setting the stage: Displaying all the components of the initial window
	 */
	public void start(Stage primaryStage) {
		try {
			GridPane GP = new GridPane();
			GP.setAlignment(Pos.CENTER);
			Scene scene = new Scene(GP, 400, 100);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

			primaryStage.setTitle("List Maker");

			label = new Label("Enter the name of the list: ");
			GP.add(label, 0, 0);

			listName = new TextField();
			listName.setOnAction(this);
			GP.add(listName, 1, 0);

			addStringList = new AddStringList();
			addNumberList = new AddNumberList();

			addStringListButton = new CommandButton(addStringList);
			addStringListButton.setOnAction(this);
			addNumListButton = new CommandButton(addNumberList);
			addNumListButton.setOnAction(this);

			GP.add(addNumListButton, 0, 2);
			GP.add(addStringListButton, 1, 2);

			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Handling when the user presses either the add string list button or add
	 * number list button
	 */
	public void handle(ActionEvent event) {
		if (event.getSource() == addStringListButton) { // If the user presses add string
			if (listName.getText().equals("")) {
				Alert invalidAlert = new Alert(Alert.AlertType.ERROR, "Enter a name for your list");
				invalidAlert.showAndWait();
			} else {
				StringList newStringList = new StringList();
				AdapterString stringAdapter = new AdapterString(newStringList);
				ClearList clearList = new ClearList(stringAdapter, listName.getText());
				SortList sortList = new SortList(stringAdapter, listName.getText());
				String listType = "string";

				list = new ListViewer<String>(listName.getText(), clearList, sortList, stringAdapter, listType);
				list.viewList();

				listName.setText("");
			}
		} else if (event.getSource() == addNumListButton) { // If the user presses add number
			if (listName.getText().equals("")) {
				Alert invalidAlert = new Alert(Alert.AlertType.ERROR, "Enter a name for your list");
				invalidAlert.showAndWait();
			} else {
				NumberList newNumberList = new NumberList();
				AdapterNumber numberAdapter = new AdapterNumber(newNumberList);
				ClearList clearList = new ClearList(numberAdapter, listName.getText());
				ReturnLargestNumber returnLargestNumber = new ReturnLargestNumber(numberAdapter, listName.getText());
				String listType = "number";

				list = new ListViewer<Number>(listName.getText(), clearList, returnLargestNumber, numberAdapter, listType);
				list.viewList();

				listName.setText("");
			}
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}

package application;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * ListViewer: The view class that comes up once the user chooses to
 * create either a StringList or NumberList (This is the window capable of
 * displaying either a single NumberList or StringList)
 * 
 * MVC - View
 * 
 * @author alissamonroe
 *
 */

public class ListViewer<T> {

	/** Stage for the new window */
	private Stage showList;

	/** Title of the List */
	private String title;

	/** GridPane holding textfield, label, and buttons */
	private GridPane listGP;

	/** ListView object: the list */
	private ListView<String> list;

	/** Adapter object */
	private Adapter<T> adapter;

	/**
	 * Command & Button objects to create relevant buttons depending on what the
	 * command is for a given list
	 */
	private MenuItem command1;
	private MenuItem command2;
	private Button button1;
	private Button button2;

	/** Label to give instructions for the particular list */
	private Label directions;

	/** String indicating the type of the list */
	private String listType;

	/** Constructor */
	public ListViewer(String newTitle, MenuItem newCommand1, MenuItem newCommand2, Adapter<T> newAdapter,
			String newListType) {
		title = newTitle;
		command1 = newCommand1;
		command2 = newCommand2;
		adapter = newAdapter;
		listType = newListType;
	}

	/**
	 * Setting the stage: Displaying all the components of this window (Namely
	 * the list, instructions, and the 2 buttons)
	 */
	public Stage viewList() {
		showList = new Stage();

		if (listType == "string") {
			showList.setTitle("String List: " + title);
		} else if (listType == "number") {
			showList.setTitle("Number List: " + title);
		}

		Scene scene = new Scene(makeListGP(), 800, 500);
		showList.setScene(scene);

		showList.show();

		return showList;
	}

	/**
	 * GridPane to be added to the stage (Holds the list, instructions, and
	 * buttons)
	 */
	public GridPane makeListGP() {
		listGP = new GridPane();
		listGP.setAlignment(Pos.CENTER);

		list = new ListView<String>(adapter);
		list.setEditable(true);
		list.setCellFactory(TextFieldListCell.forListView());

		button1 = new CommandButton(command1);
		button2 = new CommandButton(command2);

		directions = new Label("To add a " + listType + " to List " + title
				+ ":\nDouble click the next available line, type " + listType + ", hit enter");

		listGP.add(list, 0, 2);
		listGP.add(button1, 1, 2);
		listGP.add(button2, 2, 2);
		listGP.add(directions, 0, 1);

		return listGP;
	}

}

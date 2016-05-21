package application.view;


import application.Main;
import application.MapManager;
import application.model.input.SmartParser;
import application.view.LogEntry.LogType;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;

public class OverviewController {
	
	private static MapManager manager;
	
	public static Tab helpReference;
	public static TabPane paneReference;
	
	public static ObservableList<LogEntry> observableLog = FXCollections.observableArrayList();
	@FXML private ListView<LogEntry> logList;
	@FXML private TextField inputField;
	@FXML private TextArea menuArea;
	@FXML private Tab helpTab;
	@FXML private TabPane tabbedPane;

	
	//Creates references to observable fields (GUI Interaction), and creates a custom cell rendering process
	public void initialize() {
		
		helpReference = this.helpTab;
		paneReference = this.tabbedPane;

		logList.setItems(observableLog);
		
		logList.setCellFactory (
				 new Callback <ListView<LogEntry>, ListCell<LogEntry>>() {
					 @Override public ListCell<LogEntry> call (ListView<LogEntry> param) {
						 final ListCell<LogEntry> cell = new ListCell<LogEntry>() {
							 @Override public void updateItem(LogEntry item, boolean empty) {
								 super.updateItem(item, empty);
								 setStyle("-fx-background-color: TRANSPARENT; -fx-font-size:13pt;");
								 if (item != null) {
									setGraphic(item.getGraphic());
									setText(item.getText());
								 } else {
									 setGraphic(null);
									 setText(null);
								 }
								 setWrapText(true);
			                     setPrefWidth(0);
								 
		}}; return cell; }});
		
		Logger.log(LogType.START, "Welcome to the maze!");
		
		inputField.setStyle("-fx-text-fill: WHITE; -fx-background-color: TRANSPARENT;");
		
		//Initialized the MapManager
		try {
			manager = new MapManager();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			Logger.log(LogType.DEFAULT, e.toString());
			e.printStackTrace();
		}
		
	}
	

	//Handles user input, and sends it to the SmartParser
	@FXML
	private void handleChatEvent (ActionEvent event) {
		
		String text = "";
		text = inputField.getText().toString();
		inputField.clear();
		if (text != null && !text.equals("")) {
			SmartParser.parse(text);
			logList.scrollTo(observableLog.size()-1);
		}
		
	}
	
	//Is called by the SmartParser upon the "reset" command
	public static void resetGame () {
		try {
			manager = new MapManager();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			Logger.log(LogType.DEFAULT, e.toString());
			e.printStackTrace();
		}
	}
	

	//The following two methods are purely JavaFX-related
	//They handle the moving of an UNDECORATED Stage
	@FXML
	private void handleMousePress(MouseEvent event) {
		Delta.x = event.getSceneX();
        Delta.y = event.getSceneY();
	}
	
	@FXML
	private void handleMouseDrag (MouseEvent event) {
		Main.getPrimaryStage().setX(event.getScreenX() - Delta.x);
        Main.getPrimaryStage().setY(event.getScreenY() - Delta.y);
	}

	public static class Delta {
		public static double x, y;
	}
}

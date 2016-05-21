package application;
	
import application.view.Logger;
import application.view.LogEntry.LogType;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	
	private static Stage primaryStage;
		
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		
		try {

			Logger.log(LogType.MAZE, "By Ethan C. and Austin F. \nZork Framework by Graphica");
			FXMLLoader loader = new FXMLLoader(); 
            
			//Loads FXML document and creates a scene from it
            loader.setLocation(Main.class.getResource(/*"/src/application/view/Overview.fxml"*/
            		"view/Overview.fxml"));
            
            
            BorderPane overview = (BorderPane) loader.load();
            
            
            
          
            // Show the scene containing the root layout.
            Scene scene = new Scene(overview);
            scene.getStylesheets().add(getClass().getResource(/*"/src/application/view/application.css"*/
            		"view/application.css").toExternalForm());
            
            primaryStage.setScene(scene);
            primaryStage.initStyle(StageStyle.TRANSPARENT);
            primaryStage.show();
          

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		System.out.println("INITIALIZING");
		launch(args);
	}
	
	public static Stage getPrimaryStage() {
		return primaryStage;
	}
	
}

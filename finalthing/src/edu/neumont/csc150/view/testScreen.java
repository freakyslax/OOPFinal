/*package edu.neumont.csc150.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class testScreen extends Application {
	//all this stuff is temporary for testing purposes
	
    @Override
    public void start(Stage stage) {
        stage.initStyle(StageStyle.UNDECORATED);
        Text text = new Text("RHINO SIMULATOR V0.0.2");
        text.setFont(new Font(150));
        VBox box = new VBox();
        box.getChildren().add(text);
        stage.setResizable(false);
        stage.setTitle("Rhino Simulator");
        try {
			stage = initializeScene(stage, "nextLevel.fxml");
		} catch (Exception e) {
			e.printStackTrace();
		}
        stage.sizeToScene();
        stage.show();
        
    }

	private Stage initializeScene(Stage stage, String fxml) throws Exception {
    	AnchorPane page = FXMLLoader.load(testScreen.class.getResource(fxml));
        Scene scene = new Scene(page, 1280, 800, Color.ALICEBLUE);
        stage.setScene(scene);
        return stage;
	}

	public static void main(String[] args) {
        launch(args);
    }
}*/

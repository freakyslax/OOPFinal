package edu.neumont.csc150.Controller;


import java.io.IOException;

import edu.neumont.csc150.Model.Game;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Controller extends Application{
	private static Stage stage;
	public static String fxml = "nextLevel.fxml";
	
	@Override
    public void start(Stage stage) throws IOException {
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setResizable(false);
        stage.setTitle("Rhino Simulator");
        stage.show();
        
        run(stage);
        Controller.stage = stage;
        stage.sizeToScene();
    }

    private void run(Stage stage) throws IOException {
    	if(Platform.isFxApplicationThread()) {
    		AnchorPane page = FXMLLoader.load(Controller.class.getResource(fxml));
            Scene scene = new Scene(page, 1280, 800, Color.ALICEBLUE);
            stage.setScene(scene);
    	}
	}


	public static void main(String[] args) {
        Game.newGame(); //this sets the game
        launch(args); //this launches the game
    }

}

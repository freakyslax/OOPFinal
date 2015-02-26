package edu.neumont.csc150.Controller;

import java.io.IOException;
import java.util.TimerTask;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class SceneInitializer extends TimerTask{
	private Stage stage;

	public SceneInitializer(Stage stage) {
		super();
		this.stage = stage;
	}

	@Override
	public void run() {
    	AnchorPane page = null;
		try {
			page = FXMLLoader.load(Controller.class.getResource(Controller.fxml));
		} catch (IOException e) {
			e.printStackTrace();
		}
        Scene scene = new Scene(page, 1280, 800, Color.ALICEBLUE);
        stage.setScene(scene);
	}

}

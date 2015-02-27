package edu.neumont.csc150.view;

import java.net.URL;
import java.util.ResourceBundle;

import edu.neumont.csc150.Controller.Controller;
import edu.neumont.csc150.Model.Game;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class gameViewController implements Initializable{
	@FXML
	private Canvas game; //game is where the whole game is drawn
	private GraphicsContext gc; //what is used to draw onto the canvas
	@FXML
	private Button exitButton; 
	@FXML
	private Button saveButton; 
	@FXML
	private Button loadButton;
	@FXML
	private Button newButton;
	//buttons needed to register the button to the fxml

	@Override
	public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
		//this autoruns when gameviewcontroller is started
		
		//sets game scene overall
		gc = game.getGraphicsContext2D();
		gc.setFill(Color.BURLYWOOD);
		gc.fillRect(0, 100, game.getWidth(), game.getHeight() - 100);
		
		//gets the needed game items to put on screen
		//for(int i = 0; i < Controller.numToDraw(); i++) {
		//	URL image = Controller.getItemDraw(i);
		//	calculateDraw(image);
		//}
		
		//creates horn, will be better
		gc.setFill(Color.web("#9b9b9b"));
		double[] hornX = {game.getWidth() / 2, game.getWidth() / 3, game.getWidth() * 2 / 3};
		double[] hornY = {-60, game.getHeight(), game.getHeight()};
		gc.fillPolygon(hornX, hornY, 3);
		
		//temp text for fun
		gc.setFill(Color.LAWNGREEN);
		gc.setFont(new Font(60));
		gc.setEffect(new DropShadow());
		gc.fillText("RHINOCEROS SIMULATOR V0.1.6", 100, game.getHeight() - 100);
		
		//place various status bars
		gc.setFill(Color.TOMATO);
		gc.fillRoundRect(game.getWidth() - 220, game.getHeight() - 100, Game.getPlayer().getHealth() * 2, 10, 20, 20);
		gc.setFill(Color.HOTPINK);
		gc.fillRoundRect(game.getWidth() - 220, game.getHeight() - 70, Game.getPlayer().getHunger() * 2, 10, 20, 20);
		gc.setFill(Color.FIREBRICK);
		gc.fillRoundRect(game.getWidth() - 220, game.getHeight() - 40, Game.getPlayer().getThirst() * 2, 10, 20, 20);
		
	}
	
	private void calculateDraw(URL image) {
		//figure out what x, y, w, and h must be
		//gc.drawImage(new Image(image), x, y, w, h);
	}

	public void startPlayerMovement() {} //finds key pressed and starts player movement
	
	public void endPlayerMovement() {} //finds key released and ends player movement
	
	@FXML
	public void exitProgram(){
		System.exit(0); //done!
	}
	
	@FXML
	public void saveGame() {
		Game.save(); //Lets Game do the work
	}
	
	@FXML
	public void loadGame() {
		Game.load(); //lets Game do the work
	}
	
	@FXML
	public void newGame() {
		Game.newGame(); //lets Game do the work
	}

}

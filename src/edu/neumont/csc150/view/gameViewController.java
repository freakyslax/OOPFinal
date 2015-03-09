package edu.neumont.csc150.view;

import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;

import edu.neumont.csc150.Model.Game;
import edu.neumont.csc150.Model.GameItem;
import edu.neumont.csc150.Model.Player;
import edu.neumont.csc150.Model.WorldPosition;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
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
	@FXML
	private AnchorPane gameKeySpace;
	
	private int hornHeight, hornVariable;
	
	private static final Image horn = new Image("https://i.imgur.com/Bon6nqU.png");
	
	@Override
	public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
		//set handler for key events to pass it to startplayermovement and endplayermovement respectively
		gameKeySpace.setOnKeyPressed(new EventHandler<KeyEvent>() {
	        public void handle(KeyEvent ke) {
	            if (ke.getCode().toString().equalsIgnoreCase("W")) {
	            	Game.getPlayer().setyCoord(Game.getPlayer().getyCoord() + 1);
	            	refreshScreen(Game.getGameItems(), 60);
	            }
	            else if (ke.getCode().toString().equalsIgnoreCase("A")) {
	            	Game.getPlayer().setxCoord(Game.getPlayer().getxCoord() + 1);
	            	refreshScreen(Game.getGameItems(), 60);
	            }
	            else if (ke.getCode().toString().equalsIgnoreCase("S")) {
	            	Game.getPlayer().setyCoord(Game.getPlayer().getyCoord() - 1);
	            	refreshScreen(Game.getGameItems(), 60);
	            }
	            else if (ke.getCode().toString().equalsIgnoreCase("D")) {
	            	Game.getPlayer().setxCoord(Game.getPlayer().getxCoord() - 1);
	            	refreshScreen(Game.getGameItems(), 60);
	            }
	        }
		});
		hornHeight = 0;
		hornVariable = 10;
		refreshScreen(Game.getGameItems(), 60);
	}
	
	private void calculateDraw(ArrayList<WorldPosition> gameItems) {
		Player player = Game.getPlayer();
		for(int i = 0; i < gameItems.toArray().length; i++){
			WorldPosition item = gameItems.get(i);
			if(player.getxCoord() == item.getxCoord() && player.getyCoord() == item.getyCoord()) {
				System.out.println("k");
			}
			int relativeItemX = (int) (player.getxCoord() * 30 - item.getxCoord() * 30);
			if(relativeItemX >= 1){
				relativeItemX -= (int) game.getWidth();
			}
			else if(relativeItemX < 1){
				relativeItemX += (int) game.getWidth();
			}
			
			double distance = Math.abs(player.getyCoord() - item.getyCoord());
			int relativeItemY = (int) (game.getHeight() - distance * 25); //calulate y, done, well, not
			
			if(relativeItemY <= 200  && item.getyCoord() - player.getyCoord() > 0  && relativeItemX < game.getWidth() && relativeItemX > 0){
				gc.drawImage(item.getGameItem().getImage(), relativeItemX, relativeItemY, item.getGameItem().getBaseWidth() * relativeItemY / 1280, item.getGameItem().getBaseHeight() * relativeItemY / 1280);
				if(relativeItemX > 425 && relativeItemX < 700 && relativeItemY < game.getHeight() && relativeItemY + item.getGameItem().getBaseHeight() * relativeItemY / 1280 > game.getHeight() - 40){
					item.getGameItem().getInteraction();
				}
			}
		}
		
	}
	
	public void refreshScreen(ArrayList<WorldPosition> gameItems, int fontSize) {
		if(Platform.isFxApplicationThread()) {
			//this autoruns when gameviewcontroller is started
			if(new Random().nextInt(6) == 0  && Game.getPlayer().getHunger() > 0){
				Game.getPlayer().setHunger(Game.getPlayer().getHunger() - 1);
			}
			if(Game.getPlayer().getHunger() > 50 && Game.getPlayer().getHealth() < 100){
				Game.getPlayer().setHealth(Game.getPlayer().getHealth() + 1);
			}else if(Game.getPlayer().getHunger() < 10){
				Game.getPlayer().setHealth(Game.getPlayer().getHealth() - 1);
			}
			
			//sets game scene overall
			gc = game.getGraphicsContext2D();
			gc.setEffect(null);
			
			gc.setFill(Color.BURLYWOOD);
			gc.fillRect(0, 100, game.getWidth(), game.getHeight() - 100);
			
			gc.setFill(Color.SKYBLUE);
			gc.fillRect(0, 0, game.getWidth(), 100);
			
			calculateDraw(gameItems);//will place all items
			
			//creates horn, will be better
			gc.setFill(Color.web("#9b9b9b"));
			if(hornHeight < 60 && hornHeight > -60){
				hornHeight += hornVariable;
			}else{
				hornVariable *= -1;
				hornHeight += hornVariable;
			}
			//double[] hornX = {game.getWidth() / 2, game.getWidth() / 3, game.getWidth() * 2 / 3};
			//double[] hornY = {hornHeight, game.getHeight() + hornHeight, game.getHeight() + hornHeight};
			//gc.fillPolygon(hornX, hornY, 3);
			gc.drawImage(horn, 450, hornHeight, 500, 1000);
			
			//temp text for fun
			gc.setFill(Color.LAWNGREEN);
			gc.setFont(new Font(fontSize));
			gc.setEffect(new DropShadow());
			gc.fillText("RHINOCEROS SIMULATOR V0." + Game.getPlayer().getxCoord() + "." + Game.getPlayer().getyCoord(), 100, game.getHeight() - 100);
			
			//place various status bars
			gc.setFill(Color.TOMATO);
			gc.fillRoundRect(game.getWidth() - 220, game.getHeight() - 100, Game.getPlayer().getHealth() * 2, 10, 20, 20);
			gc.setFill(Color.GREEN);
			gc.fillRoundRect(game.getWidth() - 220, game.getHeight() - 70, Game.getPlayer().getHunger() * 2, 10, 20, 20);
			//gc.setFill(Color.FIREBRICK);
			//gc.fillRoundRect(game.getWidth() - 220, game.getHeight() - 40, Game.getPlayer().getThirst() * 2, 10, 20, 20);
		}
	}
	
	@FXML
	public void exitProgram(){
		System.exit(0); //done!
	}
	
	@FXML
	public void saveGame() {
		Game.save(); //Lets Game do the work
		refreshScreen(Game.getGameItems(), 60);
	}
	
	@FXML
	public void loadGame() {
		Game.load(); //lets Game do the work
		refreshScreen(Game.getGameItems(), 60);
	}
	
	@FXML
	public void newGame() {
		Game.newGame(); //lets Game do the work
		refreshScreen(Game.getGameItems(), 60);
	}

}

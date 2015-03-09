package edu.neumont.csc150.Model;

import java.util.Random;

import javafx.scene.image.Image;

public abstract class GameItem {
	
	
	private int baseWidth = 2000;
	private int baseHeight = 4000;
	private static final int numOfPossibleItems = 2;

	public abstract Image getImage();//I hate doing this, how do I make it not bad
	
	public double getBaseWidth() {
		return baseWidth;
	}

	public double getBaseHeight() {
		return baseHeight;
	}
	
	public void setBaseHeight(int baseHeight) {
		this.baseHeight = baseHeight;
	}
	
	public void setBaseWidth(int baseWidth) {
		this.baseWidth = baseWidth;
	}
	
	public abstract void getInteraction();

	public static GameItem newItem() {
		Random rand = new Random();
		int item = rand.nextInt(numOfPossibleItems);
		GameItem gameitem = null;
		if(item == 0){
			gameitem = new GameItemTree();
		}else if(item == 1){
			gameitem = new GameItemRock();
		}
		return gameitem;
	}

}

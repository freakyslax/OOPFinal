package edu.neumont.csc150.Model;

import javafx.scene.image.Image;

public class GameItemTree extends GameItem {
	
	public static final Image image = new Image("https://i.imgur.com/5SE5xdz.png");

	@Override
	public void getInteraction() {
		Game.getPlayer().setHunger(100);
	}

	@Override
	public Image getImage() {
		return image;
	}

}

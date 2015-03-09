package edu.neumont.csc150.Model;

import javafx.scene.image.Image;

public class GameItemRock extends GameItem {

	public static final Image image = new Image("https://i.imgur.com/ejhurME.png");

	@Override
	public void getInteraction() {
		Game.getPlayer().setHunger(Game.getPlayer().getHunger() - 25);
		if(Game.getPlayer().getHunger() < 0) {
			Game.getPlayer().setHunger(0);
		}
	}

	@Override
	public Image getImage() {
		return image;
	}

}

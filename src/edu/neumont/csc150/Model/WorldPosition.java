package edu.neumont.csc150.Model;

import java.util.Random;

public class WorldPosition {
	private int xCoord;
	private int yCoord;
	private GameItem gameItem;
	
	public WorldPosition() {
		xCoord = 2;
		yCoord = 6;
		gameItem = GameItem.newItem();
	}
	
	public WorldPosition(int x, int y) {
		xCoord = new Random().nextInt(100) - 10 + x;
		yCoord = new Random().nextInt(100) - 10 + y;
		gameItem = GameItem.newItem();
	}
	
	public int getxCoord() {
		return xCoord;
	}
	public void setxCoord(int xCoord) {
		this.xCoord = xCoord;
	}
	public int getyCoord() {
		return yCoord;
	}
	public void setyCoord(int yCoord) {
		this.yCoord = yCoord;
	}
	public GameItem getGameItem() {
		return gameItem;
	}
	public void setGameItem(GameItem gameItem) {
		this.gameItem = gameItem;
	}

}

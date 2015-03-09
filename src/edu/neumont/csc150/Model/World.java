package edu.neumont.csc150.Model;

import java.util.ArrayList;

public class World {
	private ArrayList<WorldPosition> gameItems;
	
	public World() {
		gameItems = new ArrayList<WorldPosition>();
		gameItems.add(new WorldPosition()); //temporary, will be generated
	}

	public ArrayList<WorldPosition> getGameItems() {
		return gameItems;
	}

	public void setGameItems(ArrayList<WorldPosition> gameItems) {
		this.gameItems = gameItems;
	}
	
	public void createWorld() {
		for(int i = -1000; i < 1000; i+=50){
			for(int j = -1000; j < 1000; j+=50){
				gameItems.add(new WorldPosition(i, j));
			}
		}
	}

}

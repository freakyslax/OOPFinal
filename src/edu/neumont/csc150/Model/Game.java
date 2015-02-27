package edu.neumont.csc150.Model;

import edu.neumont.csc150.Model.Player;

public class Game {
	//private static World currentWorld;
	private static Player player;

	public static void save() {
		player.setHealth(25);
	}

	public static void load() {
		// TODO Auto-generated method stub
	}

	public static void newGame() {
		player = new Player();
	}

	public static Player getPlayer() {
		return player;
	}

}

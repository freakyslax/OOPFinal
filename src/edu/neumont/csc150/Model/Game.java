package edu.neumont.csc150.Model;

import java.util.ArrayList;

import edu.neumont.csc150.Model.Player;

public class Game {
	private static World currentWorld;
	private static Player player;

	public static void save() {
	}

	public static void load() {
	}

	public static void newGame() {
		player = new Player();
		currentWorld = new World();
		currentWorld.createWorld();
	}

	public static Player getPlayer() {
		return player;
	}

	public static ArrayList<WorldPosition> getGameItems() {
		return currentWorld.getGameItems();
	}

}

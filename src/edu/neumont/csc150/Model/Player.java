package edu.neumont.csc150.Model;

public class Player {
	private int health;
	private int hunger;
	private int xCoord;
	private int yCoord;
	private int thirst;
	
	public Player() {
		health = 100;
		hunger = 100;
		thirst = 50;
		xCoord = 0;
		yCoord = 0;
	}
	
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public int getHunger() {
		return hunger;
	}
	public void setHunger(int hunger) {
		this.hunger = hunger;
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
	public int getThirst() {
		return thirst;
	}
	public void setThirst(int thirst) {
		this.thirst = thirst;
	}

}

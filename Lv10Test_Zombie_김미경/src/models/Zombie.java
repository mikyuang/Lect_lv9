package models;

abstract public class Zombie extends Unit{

	private int power;
	
	public Zombie(String name, int pos, int hp ,int att) {
		super(name, pos, hp,att);
	}
	
	
}

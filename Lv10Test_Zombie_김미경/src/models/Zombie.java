package models;

abstract public class Zombie extends Unit{

	private int power;
	
	public Zombie(int pos, int hp, int MAX_HP) {
		super(pos, hp, MAX_HP);
	}
	
	
}

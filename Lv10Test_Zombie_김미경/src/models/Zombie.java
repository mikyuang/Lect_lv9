package models;

public class Zombie extends Unit{

	private int power;
	
	public Zombie( int pos, int hp, int MAX) {
		super(pos, hp, MAX);
	}
	
	public void attack(Unit hero) {
		power = getR().nextInt(getMAX())+1;
		
		hero.setHp(hero.getHp()-power);
		if(hero.getHp()<=0) {
			hero.setHp(0);
		}
		this.setHp(this.getHp()+power/2);
		System.out.println();
		System.out.println("[Zombie의 "+power+"공격!]");
		System.out.println();
		System.out.println("[HERO HP: "+hero.getHp()+"]");
		System.out.println("[Zombie HP:"+this.getHp()+"]");
		
	
	}
	
}

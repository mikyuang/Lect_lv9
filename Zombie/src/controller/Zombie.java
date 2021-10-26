package controller;

public class Zombie extends Unit{

	int power;
	
	public Zombie(int pos, int hp, int max) {
		super(pos, hp, max);
	}
	
	public void attack(Unit hero) {
		
		power = r.nextInt(max)+1;
		
		hero.setHp(hero.getHp()- power);
		if(hero.getHp() <= 0) {
			hero.setHp(0);
		}
		this.setHp(this.getHp()+power/2);
	
		System.out.println("Zombie가 "+power + "만큼 공격!");
	
	}
	
}

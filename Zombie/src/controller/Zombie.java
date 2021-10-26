package controller;

abstract public class Zombie extends Unit implements Damageable{

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
	@Override
	public void damge(int att) {
		hp-=att;
		if(hp<=0) {
			System.out.println("Zombie를 쳐지했다!");
		}else {
			System.out.println("Zombie HP : "+power);
		}
	}
	
}

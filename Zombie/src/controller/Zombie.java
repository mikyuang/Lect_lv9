package controller;

public class Zombie extends Unit {

	int power;
	
	public Zombie(int pos, int hp, int max) {
		super(pos, hp, max);
	}
	
	public void attack(Unit hero) {
		power = r.nextInt(max)+1;
		
		hero.setHp(hero.getHp()-power);
		if(hero.getHp()<= 0) {
			hero.setHp(0);
		}
		this.setHp(this.getHp()+power/2);
		
		System.out.printf("좀비가 "+power +"의 데미지!\n"+ "hero hp :"+hero.getHp()+"\n좀비 hp : "+ this.getHp()+"\n");
		
	}
	
}

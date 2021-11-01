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
		System.out.println("[Zombie로 인해 "+power+"의 데미지를 입었다.");
		System.out.println("[HERO의 체력이 "+hero.getHp()+"가 되었다.]");
		System.out.println("[Zombie의 체력"+this.getHp()+"가 되었다.]");
	
	}
	
}

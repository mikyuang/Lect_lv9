package models;

public class ZombieKing extends Unit{
	
	private int power;
	private int sh;
	
	

	public ZombieKing(int pos, int hp, int MAX, int sh) {
		super(pos, hp, MAX);
		this.sh=sh;
	}
	
	
	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}


	
	public int getSh() {
		return sh;
	}

	public void setSh(int sh) {
		this.sh = sh;
	}
	
	
	public void attack(Unit hero) {
		int a = getR().nextInt(4)+1;
		if(a==1) {
			System.out.println("*KING의 공격력 2배 증가!*");
			int Power = 2 * (this.setR(this.getMAX()+1));
			hero.setHp(hero.getHp()-power);
			if(hero.getHp()<=0) {
				hero.setHp(0);
			}
			System.out.println("KING의 "+power+"만큼의 데미지!");
		}else {
			int Power = this.setR(this.getMAX()+1);
			System.out.println("KING의 "+power+"만큼의 데미지!");
			hero.setHp(hero.getHp()-power);
			if(hero.getHp()<=0) {
				hero.setHp(0);
			}
		}
		
		
	}


	private int setR(int i) {
		// TODO Auto-generated method stub
		return 0;
	}


	
}

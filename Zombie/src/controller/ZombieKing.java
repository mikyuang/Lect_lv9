package controller;

public class ZombieKing extends Unit{
	int shield;
	
	public ZombieKing(String name, int hp, int att, int def, int pos, int shield) {
		super(name, hp, att, def, pos);
		this.shield = shield;
	}
	public int getShield() {
		return shield;
	}
	public void setShield(int shield) {
		this.shield = shield;
	}
	public void attack(Unit target) {
		if(rn.nextInt(100)>74) {
			int dam = (this.getAtt()-target.getDef())*(rn.nextInt(150)+50)/100;
			if(dam<=0) {dam =1;}
			dam*=2;
			System.out.println(getName()+"의 필살기!!");
			System.out.println(dam+"의 데미지!");
			target.setHp(target.getHp()-dam);
			System.out.println(target.getName()+"의 남은 체력 : "+target.getHp());
		}else {
			super.attack(target);
		}
	}


}

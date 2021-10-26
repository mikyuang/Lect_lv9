package controller;

public class Hero extends Unit {

	int power;
	int cnt;
	
	public Hero(int pos, int hp, int max, int cnt) {
		super(pos, hp, max);
		this.cnt=cnt;
	}
	
	@Override
	public void attack(Unit enemy) {
		if(enemy instanceof ZombieKing) {
			ZombieKing ZK = (ZombieKing)enemy;
			
			power = r.nextInt(max)+1;
			if(ZK.getShield() >0) {
				int r = ZK.getShield() - power;
				if(r >= 0) {
					ZK.setShield(ZK.getShield()-power);
				}else {
					ZK.setShield(0);
					ZK.setHp(ZK.getHp()-r);
				}
			}else {
				ZK.setHp(ZK.getHp()-power);
			}
			
			if(ZK.getHp()<=0) {
				ZK.setHp(0);
			}
			System.out.println("HERO "+power+"만큼 공격!");
			System.out.println("ZombieKing HP : "+ZK.getHp());
			System.out.println("HERO HP : "+this.getHp());
		}else {
			power = r.nextInt(max)+1;
			enemy.setHp(enemy.getHp()-power);
			if(enemy.getHp()<= 0) {
				enemy.setHp(0);
			}
			System.out.println("HERO "+power+"만큼 공격!");
			System.out.println("Zombie HP : "+enemy.getHp());
			System.out.println("HERO HP : "+this.getHp());
		}
	}
	
	public void rehp() {
		if(cnt >0) {
			setHp(getHp()+100);
			System.out.println("체력이 회복되어"+getHp()+"가 되었습니다.");
			cnt--;
		}else if(cnt ==0) {
			System.out.println("회복약이 없습니다.");
		}
	}
}

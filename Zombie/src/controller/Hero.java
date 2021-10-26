package controller;

import java.util.Scanner;

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
			if(ZK.getShield() > 0) {
				System.out.println("King의 쉴드 : "+ZK.getShield());
				int r = ZK.getShield() - power;
				if(r >= 0) {
					ZK.setShield(ZK.getShield()-power);
				}else {
					System.out.println("King의 쉴드가 부서졌다!!");
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
			System.out.println();
			System.out.println("King HP : "+ZK.getHp() );
			System.out.println("HERO HP : "+this.getHp());
		}else {
			power = r.nextInt(max)+1;
			enemy.setHp(enemy.getHp()-power);
			if(enemy.getHp()<= 0) {
				enemy.setHp(0);
			}
			System.out.println("HERO "+power+"만큼 공격!");
			System.out.println();
			System.out.println("Zombie HP : "+enemy.getHp());
			System.out.println("HERO HP : "+this.getHp());
		}
	}
	
	public void rehp() {
		while(true) {
		if(cnt == 0) {
				System.out.println("회복약이 없습니다.");
			break;	
		}else {
		Scanner sc = new Scanner(System.in);
		System.out.println("물약 갯수 : "+cnt+"개");
		System.out.println("사용하시겠습니까?");
		System.out.println("[1]사용한다. [2]사용 안 한다.");
		int n = sc.nextInt();
		
		if(n ==1) {
		if(cnt >0) {
			setHp(getHp()+100);
			System.out.println("체력이 회복되어"+getHp()+"가 되었습니다.");
			cnt--;
			break;
		}
		}else if(n==2){
			break;
		}
		}
	}
	}
}

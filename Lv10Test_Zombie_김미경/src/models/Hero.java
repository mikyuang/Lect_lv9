package models;

import java.util.Scanner;

public class Hero extends Unit{
	
	private int cnt;
	private int power;

	public Hero(int pos, int hp, int MAX, int cnt) {
		super(pos, hp, MAX);
		this.cnt=cnt;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	
	@Override
	public void attack(Unit zom) {
		if(zom instanceof ZombieKing) {
			ZombieKing ZK = (ZombieKing)zom;
			
		power = getR().nextInt(getMAX())+1;
		if(ZK.getSh() > 0) {
			System.out.println("KING의 쉴드력 : "+ZK.getSh());
			int a = ZK.getSh() - power;
			if(a >= 0) {
				ZK.setSh(ZK.getSh()-power);
				
			}else {	
				System.out.println("KING의 쉴드가 파괴되었다!!");
				ZK.setSh(0);
				ZK.setHp(ZK.getHp()-a);
			}
		}else {
			ZK.setHp(ZK.getHp()-power);
		}
		if(ZK.getHp()<=0) {
			ZK.setHp(0);
		}
		System.out.println("HERO의 "+power+"만큼의 데미지!");
		System.out.println("현재 KING의 HP : "+ZK.getHp());
		System.out.println("현재 HERO의 HP : "+this.getHp());		
		
		}else {
			power = getR().nextInt(getMAX())+1;
			zom.setHp(zom.getHp()-power);
			if(zom.getHp()<=0) {
				zom.setHp(0);
			}
			System.out.println("HERO의 "+power+"만큼의 데미지!");
			System.out.println("현재 ZOMBIE의 HP : "+zom.getHp());
			System.out.println("현재 HERO의 HP : "+this.getHp());		
		}
	}
	
	
	
	
	public void heal() {
		while(true) {
			if(cnt ==0) {
				System.out.println("회복약이 없습니다.");
				break;
			}else {
				Scanner sc = new Scanner(System.in);
				System.out.println("[물약 갯수 : "+cnt+"개]");
				System.out.println("사용하시겠습니까?[1]사용 [2]돌아간다.");
				int n = sc.nextInt();
				
				if(n ==1) {
					if(cnt > 0) {
						this.setHp(getHp()+100);
						System.out.println("HP가 "+ getHp()+"가 되었습니다.");
						cnt--;
						break;
					}
				}else if(n==2) {
					break;
				}
			}
			
		}
		
	}
	
	

}

package controller;

import java.util.Random;

public class ZombieKing extends Unit{

	Random r = new Random();
	
	private int shield;

	public int getShield() {
		return shield;
	}

	public void setShield(int shield) {
		this.shield = shield;
	}
	
	public ZombieKing(int pos, int hp, int max, int shield) {
		super(pos, hp, max);
		this.shield=shield;
	}
	
	public void attack(Unit hero) {
		int a = r.nextInt(4)+1;
		if(a==1) {
			System.out.println("ZombieKig의 공격력 2배 증가!");
			int power = 2 *(r.nextInt(max)+1);
			hero.setHp(hero.getHp()- power);
			if(hero.getHp()<=0) {
				hero.setHp(0);
			}
			System.out.println("ZombieKing"+power+"만큼 공격!");
			System.out.println("HERO HP : "+hero.getHp());
		}else {
			int power = r.nextInt(max)+1;
			System.out.println("ZombidKing"+power+"만큼 공격!");
			hero.setHp(hero.getHp()-power);
			if(hero.getHp()<=0) {
				hero.setHp(0);
			}
			System.out.println("ZombieKing"+power+"만큼 공격!");
			System.out.println("HERO HP : "+hero.getHp());
			
		}
		
	}
	
}

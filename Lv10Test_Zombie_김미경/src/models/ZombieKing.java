package models;

import java.util.Random;

public class ZombieKing extends Unit{
	
	private int power;
	private int sh;
	
	private Random r = new Random();

	

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
		int a = r.nextInt(4)+1;
		if(a==1) {
			System.out.println("==KING의 공격력 2배 증가!==");
			int power = 2 * (r.nextInt(getMAX()+1));
			hero.setHp(hero.getHp()-power);
			if(hero.getHp()<=0) {
				hero.setHp(0);
			}
			System.out.println("KING의 "+power+"만큼의 데미지!");
		}else {
			int power = r.nextInt(getMAX()+1);
			System.out.println("KING의 "+power+"만큼의 데미지!");
			hero.setHp(hero.getHp()-power);
			if(hero.getHp()<=0) {
				hero.setHp(0);
			}
		}
		
		
	}


	}

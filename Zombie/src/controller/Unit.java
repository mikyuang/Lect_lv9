package controller;

import java.util.Random;

abstract public class Unit {
	
	//좀비 유닛 추상클래스로 처리.
	//인터페이스 활용 어택 처리.
	
	private int pos;
	private int hp;
	int max;
	Random r;
	
	
	public Unit(int pos, int hp, int max) {
		this.pos=pos;
		this.hp=hp;
		this.max=max;
		r=new Random();
	}
	public int getPos() {
		return pos;
	}

	public void setPos(int pos) {
		this.pos = pos;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	
	public void move() {
		if(pos <= 10) {
			pos++;
		}System.out.println("현재위치  : "+pos);
	}
	
	abstract void attack(Unit unit); 
}

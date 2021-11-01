package models;

import java.util.Random;

abstract public class Unit {

	 private int hp;
	 private int pos;
	 private int MAX;
//	 private int att;
	 
	private Random r;

	
	public Unit(int pos, int hp , int MAX) {
		 this.hp=hp;
		 this.pos=pos;
		 this.MAX=MAX;
		 r=new Random();
	 }
	 
	 	public int getHp() {
			return hp;
		}
		public void setHp(int hp) {
			this.hp = hp;
		}
		public int getPos() {
			return pos;
		}
		public void setPos(int pos) {
			this.pos = pos;
		}
		
		public Random getR() {
			return r;
		}
		
		public int getMAX() {
			return MAX;
		}

		public void setMAX_HP(int MAX) {
			MAX = MAX;
		}

		public void setR(Random r) {
				this.r = r;
		}

		
		public void move() {
			if(pos <= 10) {
				pos++;
			}
			System.out.println("현재 위치 : "+ pos);
		}
		abstract public void attack(Unit unit);

}

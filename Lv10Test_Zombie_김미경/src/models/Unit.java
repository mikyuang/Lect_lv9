package models;

import java.util.Random;

abstract public class Unit {

	 private int hp;
	 private int MAX_HP;
	 private int pos;
	 
	 Random r;


	 public Unit(int pos, int hp, int MAX_HP) {
		 this.hp=hp;
		 this.pos=pos;
		 this.MAX_HP=MAX_HP;
		 r=new Random();
	 }
	 
	 	public int getHp() {
			return hp;
		}
		public void setHp(int hp) {
			this.hp = hp;
		}
		
		public int getMAX_HP() {
			return MAX_HP;
		}
		public void setMAX_HP(int MAX_HP) {
			MAX_HP = MAX_HP;
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
		public void move() {
			if(pos <= 10) {
				pos++;
			}
			System.out.println("현재 위치 : "+ pos);
		}


}

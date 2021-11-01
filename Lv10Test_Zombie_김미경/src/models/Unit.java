package models;

import java.util.Random;

abstract public class Unit {

	 private int hp;
	 private int pos;
	 private String name;
	 private int att;
	 
	Random r;


	 public Unit(String name, int pos, int hp , int att) {
		 this.name=name;
		 this.hp=hp;
		 this.pos=pos;
		 this.att=att;
		 r=new Random();
	 }
	 
	 public String getName() {
			return name;
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
		public void move() {
			if(pos <= 10) {
				pos++;
			}
			System.out.println("현재 위치 : "+ pos);
		}
		

}

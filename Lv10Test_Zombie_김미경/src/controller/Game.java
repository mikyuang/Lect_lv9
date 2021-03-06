package controller;

import java.util.Random;
import java.util.Scanner;

import models.Hero;
import models.Zombie;
import models.ZombieKing;

public class Game {
	
	Random rn = new Random();
	Scanner sc = new Scanner(System.in);
	
	Hero hero = new Hero(1, 200, 25, 3);
	Zombie zb = new Zombie(5, 50, 10);
	ZombieKing ZK = new ZombieKing(9,200,25,50);
	
	public void run() {
		int pos=1;
		hero.setPos(pos);
		
	while(true) {
		System.out.println("[현재위치 : "+pos+"층 ]");
		
		System.out.println("[1]올라간다. [2]회복한다.");
		int move = sc.nextInt();
		
		if(move==1) {
			pos++;
			hero.setPos(pos);
			
			if(hero.getPos()==5) {
				System.out.println("== ZOMBIE 출현! ==");
				
				while(true) {
					System.out.println();
					System.out.println("[1] 공격 [2] 물약");
					int sel = sc.nextInt();
					
					if(sel ==1) {
						hero.attack(zb);
						zb.attack(hero);
						
					}else if (sel==2) {
						hero.heal();
						
					}
					if(zb.getHp()<=0) {
						System.out.println("ZOMBIE를 이겼습니다!");
						break;
					}if(hero.getHp()<=0) {
						System.out.println("== HERO DIE! GAME OVER! ==");
						break;
					}
					
				}
				
			}if(hero.getPos()==9) {
				System.out.println("== ZOMBIEKING이 나타났다!!! ==");
				while(true){
					System.out.println("[1] 공격  [2]물약");
					int sel = sc.nextInt();
					
					if(sel ==1) {
						hero.attack(ZK);
						ZK.attack(hero);
						
					}else if(sel ==2) {
						hero.heal();
						
					}if(hero.getHp()<=0) {
						System.out.println("=====HERO DIE! GAME OVER.=====");
						break;
						
					}
					if(ZK.getHp()<= 0) {
						System.out.print("ZombieKing를 이겼습니다.");
						break;
					}
				}
			}
			if(hero.getPos()==10) {
				System.out.println("=====HERO WIN!!=====");
				break;
			}
			
			
			
		}else if(move ==2) {
			hero.heal();
		}
		
	}
	
	}
	
}

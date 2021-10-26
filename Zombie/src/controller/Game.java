package controller;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Game {

	Random rn = new Random();
	Scanner sc = new Scanner(System.in);
	
	
	Hero hero = new Hero(1, 200, 20, 4);
	Zombie zombie = new Zombie(5, 100, 10);
	ZombieKing ZK = new ZombieKing(9, 200, 20, 50);

	
	
	
	
	public void run() {
		int pos =1;
		hero.setPos(pos);
	while(true) {
		System.out.println("현재 위치 : "+pos);
		
		
		System.out.println("[1] 올라간다.[2]회복한다.");
		int move = sc.nextInt();
		
		if(move ==1) {
			pos++;
			hero.setPos(pos);
			
			
			if(hero.getPos()==5) {
				System.out.println("좀비가 나타났다!");
				
				while(true) {
					System.out.println();
					System.out.println("1] 공격  2]물약");
					int sel = sc.nextInt();
					
					if(sel ==1) {
						zombie.attack(hero);
						hero.attack(zombie);
					}else if (sel ==2) {
						hero.rehp();
						
					}if(hero.getHp()<=0) {
						System.out.println("=====HERO DIE! GAME OVER.=====");
						break;
					}
					if(zombie.getHp()<= 0) {
						System.out.print("zombie를 이겼습니다.\n");
						break;
					}
				}
			}if(hero.getPos()==9) {
				System.out.println("ZombieKing이 나타났다!!!");
				while(true){
					System.out.println("1] 공격  2]물약");
					int sel = sc.nextInt();
					
					if(sel ==1) {
						ZK.attack(hero);
						hero.attack(ZK);
						
					}else if(sel ==2) {
						hero.rehp();
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
			hero.rehp();
		}
	}
	}
}

package controller;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {

	
	
	Random rn = new Random();
	Scanner sc = new Scanner(System.in);
	
	
	Hero hero = new Hero(1, 200, 20,2);
	Zombie zombie = new Zombie(5, 100, 10);
	ZombieKing ZK = new ZombieKing(9, 300, 20, 100);

	public void run() {
	while(true) {
		System.out.println("현재 위치 : "+hero.getPos());
		
		System.out.println("[1] 올라간다.");
		int move = sc.nextInt();
		if(move ==1) {
			hero.setPos(move);
			hero.getPos();
			
		}
	}
	}
}

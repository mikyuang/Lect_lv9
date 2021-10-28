package controller;

import java.util.Random;
import java.util.Vector;

import models.Player;
import models.Unit;

public class UnitManager {

	Vector<Player> playerList = new Vector<>();
	Vector<Unit> monsterList = new Vector<>();
	
	String path ="controller.";
	String mons[] = {"UnitBat","UnitBat","UnitOrc" };
	
	Random rn = new Random();
	
	
	UnitManager(){
							// 캐릭터들, maxhp , power
		playerList.add(new Player("전사", 1000, 45));
		playerList.add(new Player("마법사", 700, 80));
		playerList.add(new Player("힐러", 500, 60));
		
		System.out.println("playerList : "+playerList.size());
	}
	
	void monster_rand_set(int size) {
		for(int i=0; i<size; i++) {
			int num = rn.nextInt(mons.length);
			
			try {
				Class<?> clazz = Class.forName(path+mons[num]);//해당 클래스를 가져온다. 
				Object obj = clazz.newInstance();//해당 클래스의 객체를 만들어 주소를 저장한다.
				Unit temp = (Unit)obj;		//해당 클래스가 유닛을 상속받았기 때문에 부모클래스인 유닛으로 형변환 할수있다.
				int hp = rn.nextInt(100)+100;
				int pow = rn.nextInt(10)+10;
				temp.init(hp, pow);		//자식클래스에는 init가 없지만 부모클래스에는 있기에 부모클래스의 init 사용가능.
				monsterList.add(temp);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
}

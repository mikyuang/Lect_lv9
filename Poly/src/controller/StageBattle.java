package controller;

import java.util.Random;
import java.util.Vector;

import models.Player;
import models.Unit;

public class StageBattle extends Stage{

	UnitManager unitManager = new UnitManager();
	Vector<Player> playerList = null;
	Vector<Unit> monList = null;
	Random rn = new Random();
	int monDie =0;
	int playerDie =0;
	
	@Override
	public void init() {
		unitManager.monster_List.clear();
		unitManager.monster_rand_set(4);
		playerList=null;
		playerList = unitManager.player_List;
		monList = null;
		monList = unitManager.monster_List;
		monDie = monList.size();
		System.out.println("monDie : "+monDie);
		playerDie = playerList.size();
		
	}
	
	@Override
	public boolean update() {
		boolean run = true;
		int p_index =0;
		int m_index=0;
		boolean turn = true;
		
		while(run) {
			if(turn) {
				print_character();
				if(p_index < playerList.size()) {
					player_attack(p_index);
					
					p_index +=1;
				}else {
					turn = !turn;
					p_index =0;
				}
			}else if (!turn) {
				if(m_index < monList.size()) {
					monster_attack(m_index);
					m_index +=1;
				}else {
					turn = !turn;
					m_index =0;
				}
			}
			check_live();
		}
		return false;
	}
	
	public void print_character(){
		System.out.println("=======[B A T T L E]=======");
		System.out.println("=======[P L A Y E R]=======");
		System.out.println("playerList.size():"+playerList.size());
		
		for(int i=0; i<playerList.size(); i++) {
			playerList.get(i).printData();
		}
		System.out.println("=======[MONSTER]=======");
		for(int i=0; i<monList.size(); i++) {
			monList.get(i).printData();
		}
	}

	
	
	
	public void player_attack(int pindex) {
		Player p = playerList.get(pindex);
		if(p.curhp <= 0) return;
		System.out.println("=======[ M E N U ]=======");
		System.out.println("["+ p.name +"] 1.공격 2.스킬");
		int sel = GameManager.sc.nextInt();
		if(sel ==1) {
			while(true) {
				int idx = rn.nextInt(monList.size());
				
				if(monList.get(idx).curhp > 0) {
					p.attack(monList.get(idx));
					break;
				}
			}
		}else if(sel ==2) {}
		
	}
	
	public void monster_attack(int index){
		Unit m = monList.get(index);
		if(m.curhp <= 0)return;
		while(true) {
			int idx = rn.nextInt(playerList.size());
			if(playerList.get(idx).curhp > 0) {
				m.attack(playerList.get(idx));
				break;
			}
		}
	}
	
	public void check_live() {
		int num =0;
		for(int i=0; i<playerList.size(); i++) {
			if(playerList.get(i).curhp <= 0) {
				num +=1;
			}
		}
		playerDie = playerList.size() -num;
		num =0;
		for(int i=0; i<monList.size(); i++) {
			if(monList.get(i).curhp<=0) {
				num +=1;
			}
		}
		 monDie = monList.size() -num;
	}
	
}

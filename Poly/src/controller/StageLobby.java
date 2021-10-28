package controller;

public class StageLobby extends Stage{

	@Override
	public boolean update() {
		System.out.println("=== LOBBY ===");
		System.out.println("[1.배틀] [2.종료]");
		int sel = GameManager.sc.nextInt();
		
		if(sel ==1) {
			GameManager.nextStage = "BATTLE";
			
		}else if (sel ==2) {
			GameManager.nextStage="";
		}else {
			GameManager.nextStage="";
		}
		
		return false;
	}
	@Override
	public void init() {
	}
	
}

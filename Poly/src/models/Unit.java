package models;

public abstract class Unit {
	public int curhp;
	int maxhp;
	int power;
	public String name;
	String state = "노말";
	public Unit(){};
	
	public Unit(String na, int max, int pw){
		name = na;
		maxhp=max;
		curhp=max;
		power =pw;
		
	};
	public void init(int max, int pw) {
		maxhp=max;
		curhp=max;
		power=pw;
	};
	
	void init(String na, int max, int pw) {
		name = na;
		maxhp=max;
		curhp=max;
		power=pw;
	};
	
	public void attack(Unit target) {
		target.curhp -= power;
		System.out.println("["+ name+"]가 "+"["+target.name + "]에게 "+power+"의 데미지!");
		if(target.curhp <=0) {
			System.out.println("["+target.name+"] 을 처지!!");
			target.curhp=0;
		}
	}
	public void printData() {
		System.out.println("["+name+"]["+curhp+"/"+maxhp+"]["+power+"]");
	}

}

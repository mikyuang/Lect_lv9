package podels;

public class Accont { 
	//계좌개설/철회(회원당 3개 계좌 제한) 
	//개좌번호, 사용자코드, 잔액,<<잔액만 변화하니까 set을 만들어 준다.
	
	public static int MAX =3;
	
	private int accNum; //프라이머키 
	private int userCode; //서브로 사용되는 키 
	private int money;
	
	
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public int getAccNum() {
		return accNum;
	}
	public int getUserCode() {
		return userCode;
	}
	
	//생성자
	public Accont(int accNum, int userCode) {
		this.accNum = accNum;
		this.userCode=userCode;
		this.money=5000; //welcome money
	}
	
	public Accont(int accNum, int userCode,int money) {
		this.accNum = accNum;
		this.userCode=userCode;
		this.money=money;
	}
	
	@Override
	public String toString() {
		return this.accNum + "(" +  this.userCode + ") : "+ this.money+ "원";
	}
	
}

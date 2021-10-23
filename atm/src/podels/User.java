package podels;

public class User {
	
	
	private int userCode;
	
	private String id;
	private String pw;
	private String name;
	private int accCnt;
	
	//보유계좌의 객체주소 배열
	
	public User(int userCode, String id, String pw, String name) {
		this.userCode = userCode;
		this.id = id;
		this.pw= pw;
		this.name=name;
	}
	
	public User(int userCode, String id, String pw, String name , int accCnt) {
		this.userCode = userCode;
		this.id = id;
		this.pw= pw;
		this.name=name;
		this.accCnt=accCnt;
	}
	
	
	public String getName() {
		return name;
	}
	public int getAccCnt() {
		return accCnt;
	}
	
	public void setAccCnt(int accCnt) {
		this.accCnt = accCnt;
	}
	public String getId() {
		return this.id;
	}
	public String getPw() {
		return this.pw;
	}
	public void setUserCode(int userCode) {
		this.userCode = userCode;
	}
	public int getUserCode() {
		return this.userCode;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.userCode + ")" + this.id + "/" + this.pw+ " : "+ this.name;
	}
	
}

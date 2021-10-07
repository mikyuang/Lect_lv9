package podels;

public class User {

	int userCode;
	private String id;
	private String pw;
	private String name;
	private int accCnt;
	
	//보윺계좌의 객체주소 배열 
	
	public User(int userCode, String id, String pw, String name) {
		this.userCode = userCode;
		this.id = id;
		this.pw= pw;
		this.name=name;
	}
	
	public String getId() {
		return this.id;
	}
	public String getPw() {
		return this.pw;
	}
}

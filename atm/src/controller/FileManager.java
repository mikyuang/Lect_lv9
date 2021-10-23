package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import podels.Accont;
import podels.User;

public class FileManager {
	
	
	private File file;
	private FileWriter fw;
	private FileReader fr;
	private BufferedReader br;
	
	private String fileUsersName = "users.txt";
	private String fileAccsName ="accs.txt";
	
	
	private UserManager um = UserManager.instance;
	private AccountManager am = AccountManager.instance;
	
	public static FileManager instance = new FileManager();
	
	public void save() {
		//code/id/pw/name/accnt
		//accNum/code/money
		
		String data=makeUserData();
		
		try {
			file = new File(fileUsersName);
			fw = new FileWriter(file);
			fw.write(data);
			fw.close();
			
		}catch(Exception e) {
			
		}
		
		
		data = makeAccsData();
			try {
				file = new File(fileAccsName);
				fw = new FileWriter(file);
				fw.write(data);
				fw.close();
			}catch(Exception e) {
				
			}
	}
	
	private String makeUserData() {
		String data="";
		for(int i=0; i<um.getUserSize(); i++) {
			data += um.getUser(i).getUserCode()+"/";
			data += um.getUser(i).getId()+"/";
			data += um.getUser(i).getPw()+"/";
			data += um.getUser(i).getName()+"/";
			data += um.getUser(i).getAccCnt()+"/n";
		}
		return data;
	}
	
	private String makeAccsData() {
		String data="";
		
		for(int i=0; i<am.getAccsSize(); i++) {
			data += am.getAccont(i).getAccNum()+"/";
			data += am.getAccont(i).getUserCode()+"/";
			data += am.getAccont(i).getMoney()+"/n";
		}
		return data;
	}
		
		public void load() {
			
			try {
				file = new File(fileUsersName);
				fr = new FileReader(file);
				br = new BufferedReader(fr);
				
				String data = br.readLine();
				while(data !=  null) {
					String info[] = data.split("/");
					
					int code = Integer.parseInt(info[0]);
					String id=info[1];
					String pw = info[2];
					String name = info[3];
					int cnt = Integer.parseInt(info[4]);
					User user = new User(code, id, pw, name, cnt);
					
					um.addUser(user);
					
					data = br.readLine();
				}
				fr.close();
				br.close();
				
			}catch(Exception e) {
				
			}
		
			
			try {
				file = new File(fileAccsName);
				fr = new FileReader(file);
				br = new BufferedReader(fr);
				
				String data = br.readLine();
				while(data !=  null) {
					String info[] = data.split("/");
					
					int num = Integer.parseInt(info[0]);
					int code = Integer.parseInt(info[1]);
					int money = Integer.parseInt(info[2]);
					
					Accont acc = new Accont(num,code,money);
					am.addAccount(acc);
					data = br.readLine();
				}
				
				fr.close();
				br.close();
			}catch(Exception e) {
				
			}
			if(um.getUserSize() == 0) {
				um.setadmin();
			}
		}
}

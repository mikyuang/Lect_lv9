package models;

import java.util.Scanner;

import controller.ItemManager;
import controller.UserManager;

public class Shop {//로그인 화면 

	Scanner scan = new Scanner(System.in);
	ItemManager im = new ItemManager();
	UserManager um = new UserManager();

	void mainMenu() {
		boolean run = true;
		while (run) {
			System.out.println("[1.가입] [2.탈퇴] [3.로그인] " + "\n[100.관리자] [0.종료]\n");
			int sel = scan.nextInt();
			if (sel == 1) {
				um.join();
			}else if(sel ==2) {
				um.deluser();
				
			} else if (sel == 3) {
				if (um.logIn()) {
					loginMenu();
				}
			} else if (sel == 100) {
				managerMenu();
			}
		}
	}

	void loginMenu() {
		boolean run = true;
		while (run) {
			System.out.println("[1.쇼핑] [2.장바구니목록] [3.로그아웃] [0.뒤로가기]\n");
			int sel = scan.nextInt();
			if (sel == 1) {
				shopMenu();
			} else if (sel == 2) {
				cartMenu();
			} else if (sel == 3) {
				um.logOut();
				break;
			} else if (sel == 0) {
				break;
			}
		}
	}

	void cartMenu() {
		boolean run = true;
		while (run) {
			System.out.println("[1.내 장바구니] [2.삭제] [3.구입] [0.뒤로가기]");
			int sel = scan.nextInt();
			
			if (sel == 1) {
				im.printJang(um.getUserList().get(um.userLog));
			
			}else if(sel ==2) {
				im.delItem();
			}else if(sel ==3) {
				im.buyItem();
			} else if (sel == 0) {
				break;
			}
		}
	}

	void shopMenu() {
		boolean run = true;
		
		while (run) {
			im.printCategory();
			
			System.out.println("[카테고리] 번호를 입력하세요.[종료.-1]");
			int caId = scan.nextInt();
			
			if (caId == -1)
				break;
			System.out.println("[아이템] 번호를 입력하세요. ");
			im.printItemList(caId);
			
			int itemId = scan.nextInt();
			im.addCart(um.getUserList().get(um.userLog).getId(), caId, itemId);
		}
	}

	void managerMenu() {
		boolean run = true;
		while (run) {
			System.out.println("[1.아이템관리] [2.카테고리관리] [3.장바구니관리] [4.유저관리] [0.뒤로가기] ");
			int sel = scan.nextInt();
			if (sel == 1) {
				itemMenu();
			} else if (sel == 2) {
				categoryMenu();
			} else if (sel == 3) {
				CartMe();
			} else if (sel == 4) {
				userMenu();
			} else if (sel == 0) {
				run = false;
			}
		}
	}

	void CartMe() {
		boolean run = true;
		while(run) {
			System.out.println("[1.전체 장바구니][2.장바구니추가][3.장바구니 삭제][0.뒤로가기]");
			int sel = scan.nextInt();
			
			if(sel ==1) {
				im.printAllCart();
			}else if( sel ==2) {
				im.addAllCart();
			}else if( sel ==3) {
				im.delAllCart();
			}else if( sel ==0) {
				run=false;
			}
			
		}
		
	}
	void categoryMenu() {
		boolean run = true;
		while (run) {
			System.out.println("[1.전체카테고리] [2.카테고리추가] [3.카테고리삭제] [0.뒤로가기]");
			int sel = scan.nextInt();
			if (sel == 1) {
				im.printCategory();
			} else if (sel == 2) {
				im.addCategory();
			}else if(sel ==3) {
				im.delCate();
			} else if (sel == 0) {
				run = false;
			}
		}
	}

	void itemMenu() {
		boolean run = true;
		while (run) {
			System.out.println("[1.전체아이템] [2.아이템추가] [3.아이템삭제] [0.뒤로가기]");
			int sel = scan.nextInt();
			if (sel == 1) {
				im.printItemList();
			} else if (sel == 2) {
				im.addItem();
			}else if(sel ==3) {
				im.delItem();
			} else if (sel == 0) {
				run = false;
			}
		}
	}

	void userMenu() {
		boolean run = true;
		while (run) {
			System.out.println("[1.전체유저] [2.유저추가] [3.유저삭제] [0.뒤로가기]");
			int sel = scan.nextInt();
			if (sel == 1) {
				um.printUser();
			}else if(sel ==2) {
				um.join();
			}else if(sel ==3) {
				um.deluser();
		}else if (sel == 0) {
				run = false;
			}
		}
	}
}
	
	
	


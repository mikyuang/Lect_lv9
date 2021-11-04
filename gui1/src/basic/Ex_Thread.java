package basic;

import java.awt.Toolkit;

//thread


class PalyGame extends Thread{
	
	private void PalyGame() {
		
		
	}
	
	@Override
	public void run() {
		
		while(true) {
			System.out.println("신나게 게임을 하는 중..!");
			try{
				sleep(100);
			}catch(Exception e) {
				
			}
		
		}
	}
	
}
//playmusic 는 runnable의 자식이기때문에 형변환을 하면된다.


//런어블을 인터페이스를 받아서 사용하기때문에 다형성이 넓기때문이다. 

class PlayMusic implements Runnable{//start 다른 버전.

	boolean play;
	
	@Override
	public void run() {
		play = true;
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		
		while(play) {
			System.out.println("음악이 흐르고..");
			toolkit.music();
			try{
				Thread.sleep(100);
			}catch(Exception e) {
				
			}
			
		}
		
	}
	
	
}

public class Ex_Thread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PalyGame p = new PalyGame();
//		p.start();
		//멀티 쓰레드가 돌아간다. 
		
//		//두개의 쓰레드가 돌아가는것이다.
//		for(int n=0; n<10; n++) {
//			System.out.println("n : "+n);
//			if(n==8) {
//				System.out.println("앗! 엄마가 등장했다!");
//				p.stop();//낮은 버전이라서 -표시가 나타남, 사용하는데는 지장이 없음.(불리언값을 위에 playGame에 주어서 하면됨)
//			}
//			try{
//				Thread.sleep(1000);
//			}catch(Exception e) {
//				
//			}
//		PlayMusic q = new PlayMusic();//start 요 버전.
//		q.run();
		
		Runnable music = new PlayMusic();//요버전이 있다.
		Thread thread = new Thread(music);
		thread.start();
	
		for(int n=0; n<10; n++) {
			System.out.println("n: "+n);
			
			if(n == 7) {
				System.out.println("선생님 등장!!");
				
				//항상 형변환은 시도할떄는 if문을 써서 music이 인스턴스오브로 playMusic을 검증한후에 형변환해야한다.
				//music이 playMusicd으로 형변환이 가능하면 true
				PlayMusic stop = (PlayMusic)music;
				stop.play = false;
			}
			try{
				Thread.sleep(1000);
			}catch(Exception e) {
				
			}
		
	}
	
	
	
	
	}

}

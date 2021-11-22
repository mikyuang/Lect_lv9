package controller;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.JOptionPane;

import models.Block;
import models.MyUtill;

public class GamePlay extends MyUtill{
	
	private Random random = new Random();
	
	private boolean check = false;
	private boolean boxNear = false;
	private int boxNum = -1;
	private int ballCnt = 0;
	private int checkCnt = 0;
	
	private final int UP = 40;
	private final int LEFT = 37;
	private final int DOWN = 38;
	private final int RIGHT = 39;
	private final int WHSIZE = 500;
	
	
	private final int SIZE=10;
	
	private final int BLOCKSIZE = WHSIZE / SIZE;
	
	private Block block[][] = new Block[SIZE][SIZE];
	private int ball[][] = null;
	private int goal[][] = null;
	private int pY, pX;
	
	private int dir = 0; // 1 위(38) 2 왼쪽(37) 3 아래(40) 4 오른쪽(39)
	
	public GamePlay() {
		setLayout(null);
		setBounds(Game.WIDTH / 2 - WHSIZE / 2, Game.HEIGHT / 2 - WHSIZE / 2, WHSIZE, WHSIZE);
		setBackground(Color.white);
		
		setMap();
		setBallCnt();
		setWall();
		setBall();
		setGoal();
		setPlayer();
		
		setFocusable(true);
		addKeyListener(this);
	}
	
	private void setPlayer() {
		// TODO Auto-generated method stub
		while (true) {
			int y = random.nextInt(SIZE);
			int x = random.nextInt(SIZE);
			if (block[y][x].getState() == Block.ROAD) {
				pY = y;
				pX = x;
				block[y][x].setState(Block.PLAYER);
				break;
			}

		}
		
	}

	private void setGoal() {
		// TODO Auto-generated method stub
		goal = new int[ballCnt][2];

		for (int j = 0; j < ballCnt; j++) {

			while (true) {
				int y = random.nextInt(SIZE);
				int x = random.nextInt(SIZE);

				if (block[y][x].getState() == Block.ROAD) {
					block[y][x].setState(Block.GOAL);
					goal[j][0] = y;
					goal[j][1] = x;

					break;
				}
			}
		}
		
	}

	private void setBall() {
		// TODO Auto-generated method stub
		ball = new int[ballCnt][2];
		for (int j = 0; j < ballCnt; j++) {
			while (true) {
				int y = random.nextInt(SIZE - 2) + 1;
				int x = random.nextInt(SIZE - 2) + 1;
				if (block[y][x].getState() == Block.ROAD) {
					int check = 0;
					for (int i = -1; i <= 1; i++) {
						if (y + i >= 0 && y + i < SIZE && block[y + i][x].getState() != Block.ROAD) {
							check++;
						}
						if (x + i >= 0 && x + i < SIZE && block[y][x + i].getState() != Block.ROAD) {
							check++;
						}
					}
					if (check <= 1) {
						this.block[y][x].setState(Block.BALL);
						ball[j][0] = y;
						ball[j][1] = x;
						break;
					}
				}
			}
		}
	}

	private void setWall() {
		// TODO Auto-generated method stub
		int walls = random.nextInt(SIZE / 2) + SIZE / 2;
		for (int i = 0; i < walls; i++) {
			int wallY = random.nextInt(SIZE);
			int wallX = random.nextInt(SIZE);
			Block b = this.block[wallY][wallX];
			if (b.getState() == Block.ROAD) {
				b.setState(Block.WALL);

			} else {
				i--;
			}

		}
		
	}

	private void setBallCnt() {
		// TODO Auto-generated method stub
		ballCnt = Integer.parseInt(JOptionPane.showInputDialog("박스의 수를 입력"));
	}

	private void setMap() {
	
//		int mx;
//		int my;
//		
//	String [][] mapStage = {
//			{"#,#,w,w,w,w,w,#",
//			"w,w,w,#,#,#,w,#",
//			"w,@,p,*,#,#,w,#",
//			"w,w,w,#,*,@,w,#",
//			"w,@,w,w,*,#,w,#",
//			"w,#,w,#,@,#,w,w",
//			"w,*,#,6,*,*,@,w",
//			"w,#,#,#,@,#,#,w",
//			"w,w,w,w,w,w,w,w",}
//		};
		int XX = Game.WIDTH / 2 - WHSIZE / 2;
		int YY = Game.HEIGHT / 2 - WHSIZE / 2;
		for (int i = 0; i < block.length; i++) {
			for (int j = 0; j < block[i].length; j++) {
				block[i][j] = new Block (Block.ROAD, XX, YY, BLOCKSIZE, BLOCKSIZE);
				XX += BLOCKSIZE;
			}
			XX = Game.WIDTH / 2 - WHSIZE / 2;
			YY += BLOCKSIZE;
		}
		

	}	
	

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		for(int i=0; i<this.block.length; i++) {
			for(int j=0; j<this.block[i].length; j++) {
		///////
				
			Block b = this.block[i][j];
			g.drawImage(b.getImage().getImage(), b.getX(), b.getY(), null);
			
			
			}
		}
		requestFocusInWindow();
		repaint();
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		super.keyReleased(e);
		if (e.getKeyCode() == UP) {
			this.dir = 1;
		} else if (e.getKeyCode() == LEFT) {
			this.dir = 2;
		} else if (e.getKeyCode() == DOWN) {
			this.dir = 3;
		} else if (e.getKeyCode() == RIGHT) {
			this.dir = 4;
		}
		move();
		
	}
	
	private void move() {
		check = false;
		int yy = pY;
		int xx = pX;
		int byy = -1;
		int bxx = -1;
		// 1 위(38) 2 왼쪽(37) 3 아래(40) 4 오른쪽(39)
		if (dir == 1) {
			if (0 <= yy && yy < SIZE - 1) {
				yy++;
			}
		} else if (dir == 2) {
			if (0 < xx && xx < SIZE) {
				xx--;
			}
		} else if (dir == 3) {
			if (0 < yy && yy < SIZE) {
				yy--;
			}
		} else if (dir == 4) {
			if (0 <= xx && xx < SIZE - 1) {
				xx++;
			}
		}

		if (yy < 0 || yy > SIZE - 1 || xx < 0 || xx > SIZE - 1 || block[yy][xx].getState() == Block.WALL) {
			check = true;
		}
		for (int i = 0; i < ballCnt; i++) {
			if (yy == ball[i][0] && xx == ball[i][1]) {
				boxNear = true;
				boxNum = i;
			}
		}
		if (boxNear) {
			byy = ball[boxNum][0];
			bxx = ball[boxNum][1];
			if (dir == 1) {
				byy++;
			} else if (dir == 2) {
				bxx--;
			} else if (dir == 3) {
				byy--;
			} else if (dir == 4) {
				bxx++;
			}
		}
		if (this.block[yy][xx].getState() == Block.BALL) {
			if (byy < 0 || byy > SIZE - 1 || bxx < 0 || bxx > SIZE - 1 || block[byy][bxx].getState() == Block.WALL) {
				check = true;
			} else if (block[byy][bxx].getState() == Block.GOAL) {
				block[pY][pX].setState(Block.ROAD);
				pY = yy;
				pX = xx;
				block[pY][pX].setState(Block.PLAYER);
				block[byy][bxx].setState(Block.BALL_ENTERED);
				check = true;
				checkCnt++;
				ball[boxNum][0] = byy;
				ball[boxNum][1] = bxx;

			}
			if (!check) {
				block[byy][bxx].setState(Block.BALL);
				ball[boxNum][0] = byy;
				ball[boxNum][1] = bxx;
			}
		} else if (this.block[yy][xx].getState() == Block.BALL_ENTERED) {
			if (byy < 0 || byy > SIZE - 1 || bxx < 0 || bxx > SIZE - 1 || block[byy][bxx].getState() == Block.WALL) {
				check = true;
			} else if (block[byy][bxx].getState() == Block.ROAD) {
				block[pY][pX].setState(Block.ROAD);
				pY = yy;
				pX = xx;
				block[pY][pX].setState(Block.PLAYER);
				block[byy][bxx].setState(Block.BALL);
				checkCnt--;
			}
			if (!check) {
				block[byy][bxx].setState(Block.BALL);
				ball[boxNum][0] = byy;
				ball[boxNum][1] = bxx;
			}
		}

		if (!check) {
			block[pY][pX].setState(Block.ROAD);
			for (int i = 0; i < ballCnt; i++) {
				if (block[goal[i][0]][goal[i][1]].getState() == Block.ROAD) {
					block[goal[i][0]][goal[i][1]].setState(Block.GOAL);
				}
			}
			pY = yy;
			pX = xx;
			block[pY][pX].setState(Block.PLAYER);
		}
		if (checkCnt == ballCnt) {

			JOptionPane.showMessageDialog(null, "Goal");
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		this.dir = 0;
	}

	
}

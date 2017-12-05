package game;

public class Manager_gameBoard {
	public static Manager_gameBoard gmanager;
	
	String easy_2 = 
			  "1011001111"
			+ "0001000000"
			+ "0001111000"
			+ "1001100000"
			+ "1000000000"
			+ "0000000000"
			+ "1100000000"
			+ "1100000000"
			+ "1100000000"
			+ "0100000000";

	String easy_1 = 
			  "1000000000"
			+ "0000000000"
			+ "0000000000"
			+ "0000000000"
			+ "0000000000"
			+ "0000000000"
			+ "0000000000"
			+ "0000000000"
			+ "0000000000"
			+ "0000000000";
	
	String gameboard;   

	public Manager_gameBoard() {
		// TODO Auto-generated constructor stub
		gmanager=this;
	}
	
	public void selectBoard(int level) {  // 레벨을 받아서 랜덤으로 game board 세팅.
		int n = (int) (Math.random() * 2) + 1;   // 1~3 사이의 랜덤 숫자 구하기 (보드선택용)   .. 난이도별로 3개씩만구현예정   테스트용으로 현재 easy 2개만구현.
	    
		if(level==1) {
			switch(n) {
				case 1:
					gameboard = easy_1;
					break;
				case 2:
					gameboard = easy_2;
					break;
				case 3:
					break;
			}
			
		}
		else if(level==2) {
			switch(n) {
				case 1:
					break;
				case 2:
					break;
				case 3:
					break;
			}
			
		}
		else if(level==3) {
			switch(n) {
				case 1:
					break;
				case 2:
					break;
				case 3:
					break;
			}
		}
		
	}
	

}

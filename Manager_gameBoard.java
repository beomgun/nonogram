package game;

public class Manager_gameBoard {
	public static Manager_gameBoard gmanager;
	
	String test =	// normal mode 클리어 화면 테스트용
			  "100000000000000"
			+ "000000000000000"
			+ "000000000000000"
			+ "000000000000000"
			+ "000000000000000"
			+ "000000000000000"
			+ "000000000000000"
			+ "000000000000000"
			+ "000000000000000"
			+ "000000000000000"
			+ "000000000000000"
			+ "000000000000000"
			+ "000000000000000"
			+ "000000000000000"
			+ "000000000000000";
	
	String easy_1 = //리본  http://nemonemologic.com/play_logic.php?quid=4388&page=10&size=10
			  "0000000000"
			+ "0100000010"
			+ "0110000110"
			+ "1001001001"
			+ "1000110001"
			+ "1000110001"
			+ "1001001001"
			+ "0110000110"
			+ "0100000010"
			+ "0000000000";
	String easy_2 = //쥐  http://nemonemologic.com/play_logic.php?quid=5058&page=0&size=10
			  "1110000111"
			+ "1010000101"
			+ "1101111011"
			+ "0010000100"
			+ "0101001010"
			+ "0100000010"
			+ "0101001010"
			+ "0010110100"
			+ "1001111001"
			+ "0100000001";

	String easy_3 = //음표  http://nemonemologic.com/play_logic.php?quid=4871&page=3&size=10
			  "0000010000"
			+ "0000011000"
			+ "0000010100"
			+ "0000010010"
			+ "0000010001"
			+ "0000010001"
			+ "0011110010"
			+ "0111110100"
			+ "0111110000"
			+ "0011100000";
	
	String normal_1 = //티포트 & 주전자 http://nemonemologic.com/play_logic.php?quid=5024&page=0&size=15
			  "000000111111000"
			+ "000001000000100"
			+ "000001001100100"
			+ "000000111111000"
			+ "000001100001100"
			+ "110011000000110"
			+ "010110000000011"
			+ "011100000000001"
			+ "001100001100001"
			+ "000101011111101"
			+ "000101011110101"
			+ "000011111111111"
			+ "101001111111100"
			+ "101000111111000"
			+ "111000111111000";
	
	String normal_2 = //눈송이 http://nemonemologic.com/play_logic.php?quid=5007&page=1&size=15
			  "100000010000001"
			+ "011001111100110"
			+ "011000010000110"
			+ "000110111011000"
			+ "000110010011000"
			+ "010001010100010"
			+ "010100111001010"
			+ "111111111111111"
			+ "010100111001010"
			+ "010001010100010"
			+ "000110010011000"
			+ "000110111011000"
			+ "011000010000110"
			+ "011001111100110"
			+ "100000010000001";
	String normal_3 = //우주선 http://nemonemologic.com/play_logic.php?quid=4862&page=3&size=15
			  "000011101110000"
			+ "001001000100100"
			+ "011101010001110"
			+ "001000101000100"
			+ "000001000100000"
			+ "001110010011100"
			+ "001010101010100"
			+ "001010101010100"
			+ "001010101010100"
			+ "001010101010100"
			+ "001010111010100"
			+ "001110000011100"
			+ "000011111110000"
			+ "000110111011000"
			+ "000110111011000";
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
					gameboard = easy_3;
					break;
			}
			
		}
		else if(level==2) {
			switch(n) {
				case 1:
					gameboard = normal_1;
					break;
				case 2:
					gameboard = normal_2;
					break;
				case 3:
					gameboard = normal_3;
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

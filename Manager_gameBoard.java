package game;

public class Manager_gameBoard {
	public static Manager_gameBoard gmanager;
	
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
	String hard_1 = //불금 http://nemonemologic.com/play_logic.php?quid=3569&page=25&size=20
			  "00111110000000110000" //1
			+ "00111110000010110100" //2
			+ "00011100000010110100" //3
			+ "00011100000000110000" //4
			+ "00011100000001111000" //5
			+ "00111110000011001100" //6
			+ "01111111000010000100" //7
			+ "11111111100000000000" //8
			+ "10001000100000000000" //9
			+ "10111010100000010000" //10
			+ "10001010100000111000" //11
			+ "11101010100001111100" //12
			+ "10001000100011000110" //13
			+ "11111111100110000011" //14
			+ "10001010100001111100" //15
			+ "11011010100000010000" //16
			+ "11011010100001111100" //17
			+ "11011010100000010000" //18
			+ "10011000100001010100" //19
			+ "11111111100111111111";//20
	String hard_2 = //체리 http://nemonemologic.com/play_logic.php?quid=4561&page=7&size=20
			  "00000000000000000111" //1
			+ "00011100000111111111" //2
			+ "00111111111111111111" //3
			+ "00111111111111111111" //4
			+ "00011111101100110000" //5
			+ "00000000001100110000" //6
			+ "00000000011000111000" //7
			+ "00000000111000011000" //8
			+ "00000000110000011000" //9
			+ "00000001100000011000" //10
			+ "00000011000001111110" //11
			+ "00011110000010111111" //12
			+ "01111111000101111111" //13
			+ "11011111100111111111" //14
			+ "10111111110111111111" //15
			+ "10111111110111111111" //16
			+ "11111111110111111111" //17
			+ "11111111110011111110" //18
			+ "01111111100001111100" //19
			+ "00111111000000000000";//20
	String hard_3 = //만년필 http://nemonemologic.com/play_logic.php?quid=4524&page=8&size=20
			  "00000000000001101111" //1
			+ "00000000000011011111" //2
			+ "00000000000110111111" //3
			+ "11111111111101111111" //4
			+ "00000000011111111111" //5
			+ "00000000110011111111" //6
			+ "00000000111101111111" //7
			+ "00000001111110111111" //8
			+ "00000111000011011110" //9
			+ "00011100000001011100" //10
			+ "00110000000011011000" //11
			+ "00100000000011100000" //12
			+ "00100110000110000011" //13
			+ "00100110001100011111" //14
			+ "01001100001000110011" //15
			+ "01011000011000000000" //16
			+ "01110011110011110000" //17
			+ "11111100000111001000" //18
			+ "11111111111110111111" //19
			+ "00000000000000111100";//20
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
					gameboard = hard_1;
					break;
				case 2:
					gameboard = hard_2;
					break;
				case 3:
					gameboard = hard_3;
					break;
			}
		}
		
	}
	

}
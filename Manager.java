package game;


public class Manager {

	public static Manager manager;

	public boolean gameIn;       // ���� �ϰ� �ִ��� ���� Ȯ��
	public boolean gameReady;    // ���� ī��Ʈ ���������� Ȯ��
	public boolean gamePause;    // ���� �Ͻ�����������.
		
	public int level;
	public int clientWidth;
	public int clientHeight;
	
	public int xSize;            // x�� �ڽ� ���� (����)
	public int ySize;            // y�� �ڽ� ���� (����)
	
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
	public Manager() {
		manager=this;
		// TODO Auto-generated method stub
		gameIn = false;
		gameReady = false;
		gamePause = false;
		
		
		level = 2;
		clientWidth = 700;
		clientHeight = 700;
		xSize = 15;
		ySize = 15;
		
		
		
		new Frame();           // �ʱ� ������ Frame ������ �̵�
	}
	
	// �����ٲٱ�!
	public void changeLevel(int level) {
		if(level == 1) {
			this.level = 1;
			xSize = 10;
			ySize = 10;
		}
		else if(level == 2) {
			this.level = 2;
			xSize = 15;
			ySize = 15;
		}
		else if(level == 3) {
			this.level = 3;
			xSize = 20;
			ySize = 20;
		}
			
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Manager();
	}
}
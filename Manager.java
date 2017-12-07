package game;


public class Manager {

	public static Manager manager;
		
	public int level;
	public int clientWidth;
	public int clientHeight;
	public int xSize;            // x�� �ڽ� ���� (����)
	public int ySize;            // y�� �ڽ� ���� (����)

	public Manager_ranking rk = new Manager_ranking();
	public Manager_gameBoard gb = new Manager_gameBoard();
	
	public Manager() {
		manager=this;
		// TODO Auto-generated method stub
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
package game;


public class Manager {

	public static Manager manager;

	public boolean gameIn;       // ���� �ϰ� �ִ��� ���� Ȯ��
	public boolean gameReady;    // ���� ī��Ʈ ���������� Ȯ��
	public boolean gameOver;     // ������ ���ӿ����ߴ��� Ȯ��  > ������� ��������
	public boolean gamePause;    // ���� �Ͻ�����������.
	
	public int level;
	public int clientWidth;
	public int clientHeight;
	
	public int xSize;            // x�� �ڽ� ���� (����)
	public int ySize;            // y�� �ڽ� ���� (����)
	
	
	public float time_readyWait;
	
	public Manager() {
		manager=this;
		// TODO Auto-generated method stub
		gameIn = false;
		gameReady = false;
		gameOver = false;
		gamePause = false;
		
		level = 2;
		clientWidth = 700;
		clientHeight = 700;
		xSize = 15;
		ySize = 15;
		
		time_readyWait = 5.0f;
		
		
		new Frame();           // �ʱ� ������ Frame ������ �̵�
	}
	
	// �����ٲٱ�!
	public void changeLevel(int level) {
		if(level == 1) {
			this.level=1;
			xSize = 10;
			ySize = 10;
		}
		else if(level == 2) {
			this.level=2;
			xSize = 15;
			ySize = 15;
		}
		else if(level == 3) {
			this.level=3;
			xSize = 20;
			ySize = 20;
		}
			
	}
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Manager();
	}
}

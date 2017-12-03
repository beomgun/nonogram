package game;


public class Manager {

	public static Manager manager;

	public boolean gameIn;       // 게임 하고 있는지 여부 확인
	public boolean gameReady;    // 게임 카운트 세는중인지 확인
	public boolean gameOver;     // 게임중 게임오버했는지 확인  > 했을경우 기록저장용
	public boolean gamePause;    // 게임 일시정지중인지.
	
	public int level;
	public int clientWidth;
	public int clientHeight;
	
	public int xSize;            // x축 박스 갯수 (길이)
	public int ySize;            // y축 박스 개수 (길이)
	
	
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
		
		
		new Frame();           // 초기 설정후 Frame 만들기로 이동
	}
	
	// 레벨바꾸기!
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

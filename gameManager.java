package nonogram;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.naming.InitialContext;
import javax.swing.*;

import ex.menuItem.MenuHandler;
import nonogram.panel_Main;
 
public class gameManager extends JFrame {
	public static gameManager manager;
	
	int clientWidth;
	int clientHeigh;
	
	
	panel_Main panel_main;
	panel_Game panel_game;
	
	boolean gameIn = false;       // 게임 하고 있는지 여부 확인
	boolean gameStart = false;    // 게임 카운트 다세고 시작했는지 확인
	boolean gameOver = false;     // 게임중 게임오버했는지 확인  > 했을경우 기록저장용
	boolean gamePause = false;    // 게임 일시정지중인지.
	

    JMenuBar mb; 
	int level = 2;
	
	@Override
	protected void frameInit() {
		
		// TODO Auto-generated method stub
		manager = this;
		super.frameInit();
		setTitle("네모네모로직!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(700,700);
		
		
// 메뉴바 설정 (난이도) //////////////////////////////
		mb = new JMenuBar(); 
		JMenu m1 = new JMenu("Normal"); 
		JMenuItem m1_mi1 = new JMenuItem("Easy"); 
		JMenuItem m1_mi2 = new JMenuItem("Normal"); 
		JMenuItem m1_mi3 = new JMenuItem("Hard"); 
		m1.add(m1_mi1); 
		m1.add(m1_mi2); 
		m1.add(m1_mi3); 
		// 메인메뉴를 메뉴바에 추가 
		mb.add(m1); 
		// 메뉴바를 프레임에 메뉴바로 셋팅 
		setJMenuBar(mb); 
		MenuHandler m = new MenuHandler(); 
		//MenuHandler는 미리 만들어서 쓰기 
		m1_mi1.addActionListener(m); 
		m1_mi2.addActionListener(m); 
		m1_mi3.addActionListener(m); 
// ========================================================
		
		
		setLayout(null);
	}
	
	
	
	
	public gameManager() {
		
		setVisible(true);
		clientWidth=getContentPane().getSize().width;
		clientHeigh = getContentPane().getSize().height;
		
		
		this.addComponentListener(new ComponentAdapter() {   // Frame사이즈 수정할 때 마다 사이즈 맞춤
			public void componentResized(ComponentEvent e) {
				clientWidth=gameManager.this.getContentPane().getSize().width;
				clientHeigh = gameManager.this.getContentPane().getSize().height;
			}
		});
		
		panel_main= new panel_Main(this);
		panel_game= new panel_Game(this);
		this.getContentPane().add(panel_main);           // 이거안해주면 안됨 2#@#@#@#! 개중요 ㅅㅂ... 바로 add하면 안됩니다
		this.getContentPane().add(panel_game);
		
		panel_main.setVisible(true);
		panel_game.setVisible(false);
		
		
	}
	
// 메인화면에서 이동하는 버튼 함수- Start ==============================================
	public void goPanel_Game() {
		gameIn = true;
		panel_main.setVisible(false);
		panel_game.setVisible(true);
		mb.setVisible(false);
	}
	
	public void goPanel_main() {
		gameIn = false;
		panel_main.setVisible(true);
		panel_game.setVisible(false);
		mb.setVisible(true);
		
//		panel_rank.setVisible(false);
		
	}
// 메인화면에서 이동하는 버튼 함수 - End ==============================================
	
	
//난이도설정 메뉴바 - Start ======================================================
	  public class MenuHandler implements ActionListener { 
	       @Override 
	       public void actionPerformed(ActionEvent e) { 
	          System.out.println(e.getActionCommand() + "가 선택"); 
	          
	          String str = e.getActionCommand(); 
	          if (str.equals("Easy")) {
	        	  level =1;
	
	          } 
	          else if (str.equals("Normal")) {
	        	  level =2;
	          } 
	          else if (str.equals("Hard")) {
	        	  level =3;
	          } 
	       } 
	    } 
///난이도설정 메뉴바 - End =============================================================
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new gameManager();
		
	}



	

 

}

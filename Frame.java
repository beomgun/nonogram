package game;

import java.awt.event.*;

import javax.swing.*;

 
public class Frame extends JFrame {

	private static final long serialVersionUID = 1L;
	
	JPanel panel_main;
	JPanel panel_game;
    JMenuBar mb; 
	
	public Frame() {
		
		setTitle("네모네모로직!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(Manager.manager.clientWidth,Manager.manager.clientWidth);
		

		mb = new menuBar();   // 메뉴바 설정 (난이도)
		setJMenuBar(mb); 
		
		panel_main = new game.panel_Main(this);
		add(panel_main);
		panel_main.setVisible(true);
		panel_game = new panel_Game(this);
		add(panel_game);
		panel_game.setVisible(false);
		
		setVisible(true);
		
		
		
		
		Manager.manager.clientWidth=getContentPane().getSize().width;
		Manager.manager.clientHeight = getContentPane().getSize().height;
		
		this.addComponentListener(new ComponentAdapter() {   // Frame사이즈 수정할 때 마다 사이즈 맞춤
			public void componentResized(ComponentEvent e) {
				Manager.manager.clientWidth=Frame.this.getContentPane().getSize().width;
				Manager.manager.clientHeight = Frame.this.getContentPane().getSize().height;
			}
		});
		
		
	}
	
	
	
	public void goGame() {
		panel_main.setVisible(false);
		
		remove(panel_game);
		
		panel_game = new panel_Game(this);
		add(panel_game);
		panel_game.setVisible(true);
	}
	
	
	public void goMain() {
		panel_main.setVisible(true);
		panel_game.setVisible(false);
		
	}
	
	public void goRank() {
		panel_main.setVisible(false);
//		panel_rank.setVisible(true);    //  나중에 이걸 추가해야지!
	}
	
}

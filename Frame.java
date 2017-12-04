package game;

import java.awt.Graphics;
import java.awt.event.*;
import javax.swing.*;

 
public class Frame extends JFrame {

	private static final long serialVersionUID = 1L;
	
	JPanel panel_main;
	JPanel panel_game;
	JPanel panel_rank;
    JMenuBar mb; 
    
    int cnt = 0;
	
	public Frame() {
		setTitle("�׸�׸����!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(Manager.manager.clientWidth,Manager.manager.clientWidth);
		

		mb = new menuBar();   // �޴��� ���� (���̵�)
		setJMenuBar(mb); 
		
		panel_main = new panel_Main(this);
		add(panel_main);
		panel_main.setVisible(true);
		
		panel_game = new panel_Game(this);
		add(panel_game);
		panel_game.setVisible(false);
		

		
		panel_rank = new panel_Rank(this);
		add(panel_rank);
		panel_rank.setVisible(false);
		
		setVisible(true);
		setResizable(false);
		
		
		
		
		
		this.addComponentListener(new ComponentAdapter() {   // Frame������ ������ �� ���� ������ ����
			public void componentResized(ComponentEvent e) {
				Manager.manager.clientWidth=Frame.this.getContentPane().getSize().width;
				Manager.manager.clientHeight = Frame.this.getContentPane().getSize().height;
			}
		});
		
		
	}

	public void paintComponent (Graphics g) { //g�� ���� �ִ� ��ü
		


		Manager.manager.clientWidth=getContentPane().getSize().width;
		Manager.manager.clientHeight = getContentPane().getSize().height;
	}
	
	
	public void goGame() {
		panel_main.setVisible(false);
		
		remove(panel_game);
		
		panel_game = new panel_Game(this);
		add(panel_game);
		panel_game.setVisible(true);
		mb.setVisible(false);
	}
	
	
	public void goMain() {
		panel_main.setVisible(true);
		panel_game.setVisible(false);
		mb.setVisible(true);
	}
	
	public void goRank() {
		panel_main.setVisible(false);
		panel_rank.setVisible(true);    //  ���߿� �̰� �߰��ؾ���!
	}
	

	public void goRMain() {      //��ŷ���� ���ΰ��� ��ư
		panel_main.setVisible(true);
		panel_rank.setVisible(false);   
		
	}
	
	public void goRank_inGame() {
		panel_game.setVisible(false);
		panel_rank.setVisible(true);    //  ���߿� �̰� �߰��ؾ���!
		mb.setVisible(true);
		
	}
	
	
}

package game;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import ex.menuItem.MenuHandler;
import nonogram.panel_Main;
 
public class Frame extends JFrame {

	
	JPanel panel_main;
	JPanel panel_game;
    JMenuBar mb; 
	
	public Frame() {
		
		setTitle("�׸�׸����!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(Manager.manager.clientWidth,Manager.manager.clientWidth);
		

		mb = new menuBar();   // �޴��� ���� (���̵�)
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
		
		this.addComponentListener(new ComponentAdapter() {   // Frame������ ������ �� ���� ������ ����
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
	
}

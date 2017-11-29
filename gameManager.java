package nonogram;

import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.naming.InitialContext;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import nonogram.panel_Main;
 
public class gameManager extends JFrame {
	public static gameManager manager;
	
	int clientWidth;
	int clientHeigh;
	
	panel_Main panel_main;
	panel_Game panel_game;
	@Override
	protected void frameInit() {
		// TODO Auto-generated method stub
		manager = this;
		super.frameInit();
		setTitle("네모네모로직!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(700,700);
		setLayout(null);
	}
	public gameManager() {
		setVisible(true);
		clientWidth=getContentPane().getSize().width;
		clientHeigh = getContentPane().getSize().height;
		this.addComponentListener(new ComponentAdapter() {
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
	
	
	
	
	
	public void goPanel_Game() {
		panel_main.setVisible(false);
		panel_game.setVisible(true);
	}
	
	public void goPanel_main() {
		panel_main.setVisible(true);
		panel_game.setVisible(false);
//		panel_rank.setVisible(false);
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new gameManager();
		
	}



	

 

}

package nonogram;

import java.awt.*;

import javax.naming.InitialContext;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

 
public class gameManager extends JFrame {
	public static gameManager manager;
	
	int clientWidth;
	int clientHeigh;
	
	panel_Main panel_main= new panel_Main(this);
	panel_Game panel_game= new panel_Game();
	@Override
	protected void frameInit() {
		// TODO Auto-generated method stub
		manager = this;
		super.frameInit();
		setTitle("네모네모로직!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(700,700);
		setLayout(null);
		clientWidth=manager.getContentPane().getSize().width;
		System.out.println(clientWidth);
	}
	public gameManager() {
		this.getContentPane().add(panel_main);           // 이거안해주면 안됨 2#@#@#@#! 개중요 ㅅㅂ... 바로 add하면 안됩니다
		this.getContentPane().add(panel_game);
		
		panel_main.setVisible(true);
		panel_game.setVisible(false);
		setVisible(true);
	}
	
	
	
	
	
	public void setPanel_Game() {
		panel_main.setVisible(false);
		panel_game.setVisible(true);
		System.out.println("1");
	}
	
	public void setPanel_main() {
		panel_main.setVisible(true);
		panel_game.setVisible(false);
//		panel_rank.setVisible(false);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new gameManager();
		
	}



	

 

}

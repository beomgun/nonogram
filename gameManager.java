package nonogram;

import java.awt.*;

import javax.naming.InitialContext;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

 
public class gameManager extends JFrame {
	panel_Main panel_main = new panel_Main();
	panel_Game panel_game = new panel_Game();

	int clientWidth;
	int clientHeight;
	
	
	public gameManager() {

		setTitle("네모네모 로직");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(700,700);
		setVisible(true);

		Container win = super.getContentPane();
		Dimension d =win.getSize();
		clientWidth=d.height;
		clientHeight=d.width;
		
		panel_main.setBounds(0, 0, clientWidth, clientHeight);
		add(panel_main);
		panel_main.setVisible(true);
		
		panel_game.setBounds(0, 0, clientWidth, clientHeight);
		add(panel_game);
		panel_game.setVisible(false);
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new gameManager();

	}



	

 

}

	
	
	
	
	

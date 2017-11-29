package game;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.*;


import nonogram.gameManager;


public class panel_Main extends JPanel implements ActionListener{
	public static panel_Main main;
	Frame fr;
	
	ImageIcon imgIco = new ImageIcon("111.png","����");
	Image img = imgIco.getImage();

	
	JButton btn_main_Start = new JButton("���� ����");
	JButton btn_main_Rank = new JButton("��ŷ ����");
	JButton btn_main_Exit = new JButton("����");
	
	int size_main_btn_x = 100;
	int size_main_btn_y = 80;
	
	
	
	
	
	public panel_Main(Frame fr) {
		this.fr = fr;
		setBounds(0, 0, Manager.manager.clientWidth, Manager.manager.clientHeight);
		setLayout(null);
		add(btn_main_Start);
		add(btn_main_Rank);
		add(btn_main_Exit);
	}
	
	

	public void paintComponent (Graphics g) { //g�� ���� �ִ� ��ü
		g.drawImage(img, 0, 0, Manager.manager.clientWidth ,Manager.manager.clientHeight, this);
		makeButtonAndEventHandle();
	}
	
	
		
	public void makeButtonAndEventHandle() {
		size_main_btn_x = (int)(Manager.manager.clientWidth/2.8);
		size_main_btn_y = (int)(Manager.manager.clientHeight/8.5);
		
		btn_main_Start.setSize(size_main_btn_x, size_main_btn_y);
		btn_main_Start.setLocation((Manager.manager.clientWidth-size_main_btn_x)/2,(int)((Manager.manager.clientHeight-size_main_btn_y)/2.1));

		
		btn_main_Rank.setSize(size_main_btn_x, size_main_btn_y);
		btn_main_Rank.setLocation((Manager.manager.clientWidth-size_main_btn_x)/2,(int)((Manager.manager.clientHeight-size_main_btn_y)/1.51));

		
		btn_main_Exit.setSize(size_main_btn_x, size_main_btn_y);
		btn_main_Exit.setLocation((Manager.manager.clientWidth-size_main_btn_x)/2,(int)((Manager.manager.clientHeight-size_main_btn_y)/1.18));

		
		btn_main_Start.addActionListener(this);
		btn_main_Rank.addActionListener(this);
		btn_main_Exit.addActionListener(this);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String strCmd = e.getActionCommand(); // Ŭ���� ��ư�� �̸��� ����
		
		if (strCmd.equals("����")) {
			System.exit(0);
		}
		else if(strCmd.equals("��ŷ ȭ��")) {
			go_rank();
		}
		else if (strCmd.equals("���� ����")) {
			go_game();
		}
	}
	
	void go_rank() {
		
	}
	
	void go_game() {

		fr.goGame();
	}
	
}

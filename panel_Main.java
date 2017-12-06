package game;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


public class panel_Main extends JPanel implements ActionListener{
	private static final long serialVersionUID = 1L;
	
	public static panel_Main main;
	Frame fr;
	JPanel panel_fade = new panel_FadeIO();
	
	ImageIcon imgIco = new ImageIcon("배경.png","사진");
	Image img = imgIco.getImage();

	Listener_btnChange btnListener = new Listener_btnChange();   // 버튼에 마우스올렸을때 바뀌게하는 리스너
	Insets m = new Insets(0, 14, 0, 0);
	
	
	
	
	JButton btn_main_Start = new JButton("게임 시작");
	JButton btn_main_Rank = new JButton("랭킹 보기");
	JButton btn_main_Exit = new JButton("종료");
	
	int size_main_btn_x = 100;
	int size_main_btn_y = 80;
	

	
	
	
	public panel_Main(Frame fr) {
		this.fr = fr;
		setBounds(0, 0, Manager.manager.clientWidth, Manager.manager.clientHeight);
		setBackground(Color.WHITE);
		btn_main_Start.setIcon(new ImageIcon("게임시작.png"));
		btn_main_Start.setMargin(m);
		btn_main_Start.setBorderPainted(false);
		btn_main_Start.addMouseListener(btnListener);
		btn_main_Rank.setIcon(new ImageIcon("랭킹보기.png"));
		btn_main_Rank.setMargin(m);
		btn_main_Rank.addMouseListener(btnListener);
		btn_main_Rank.setBorderPainted(false);
		btn_main_Exit.setIcon(new ImageIcon("게임종료.png"));
		btn_main_Exit.setMargin(m);
		btn_main_Exit.addMouseListener(btnListener);
		btn_main_Exit.setBorderPainted(false);
		
		
		setLayout(null);
		add(btn_main_Start);
		add(btn_main_Rank);
		add(btn_main_Exit);
	}
	
	

	public void paintComponent (Graphics g) { //g는 원래 있는 객체
		setBounds(0, 0, Manager.manager.clientWidth, Manager.manager.clientHeight);
		g.drawImage(img, 0, 0, Manager.manager.clientWidth ,Manager.manager.clientHeight, this);
		makeButtonAndEventHandle();
	}
	
	
		
	public void makeButtonAndEventHandle() {
		size_main_btn_x = (int)(Manager.manager.clientWidth/2.8)-11;
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
		String strCmd = e.getActionCommand(); // 클릭된 버튼의 이름을 저장
		
		if (strCmd.equals("종료")) {
			System.exit(0);
		}
		else if(strCmd.equals("랭킹 보기")) {
			go_rank();
		}
		else if (strCmd.equals("게임 시작")) {
			go_game();
		}
	}
	
	void go_rank() {
		fr.goRank();
	}
	
	void go_game() {

		fr.goGame();
	}
	
}

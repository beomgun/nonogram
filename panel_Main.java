package nonogram;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import nonogram.gameManager;


public class panel_Main extends JPanel implements ActionListener{
	
	ImageIcon imgIco = new ImageIcon("111.png","사진");
	Image img = imgIco.getImage();

	
	JButton btn_main_Start = new JButton("게임 시작");
	JButton btn_main_Rank = new JButton("랭킹 보기");
	JButton btn_main_Exit = new JButton("종료");
	
	int size_main_btn_x = 230;
	int size_main_btn_y = 80;
	
	int size_clientWidth=684;
	int size_clientHeight=660;
	boolean a = false;
	
	public panel_Main(gameManager gm) {
		setBounds(0, 0, 700, 700);
		setLayout(null);
		makeButtonAndEventHandle();
		size_clientWidth=gm.getContentPane().getSize().width;
		size_clientHeight = gm.getHeight();
		System.out.println(size_clientWidth);
		System.out.println(size_clientHeight);
	}

	public void paintComponent (Graphics g) { //g는 원래 있는 객체
		super.paintComponent(g);
		g.drawImage(img, 0, 0, 700,size_clientHeight, this);
	
	}

	@Override
	public void update(Graphics g) {
		// TODO Auto-generated method stub
		super.update(g);
		if (a==false) {
			size_clientWidth=gameManager.manager.getContentPane().getSize().width;
			a=true;

			repaint();
		}
	}

	
	public void makeButtonAndEventHandle() {

		btn_main_Start.setSize(size_main_btn_x, size_main_btn_y);
		btn_main_Start.setLocation((size_clientWidth-size_main_btn_x)/2,(int)((size_clientHeight-size_main_btn_y)/2.1));
		add(btn_main_Start);
		
		btn_main_Rank.setSize(size_main_btn_x, size_main_btn_y);
		btn_main_Rank.setLocation((size_clientWidth-size_main_btn_x)/2,(int)((size_clientHeight-size_main_btn_y)/1.5));
		add(btn_main_Rank);
		
		btn_main_Exit.setSize(size_main_btn_x, size_main_btn_y);
		btn_main_Exit.setLocation((size_clientWidth-size_main_btn_x)/2,(int)((size_clientHeight-size_main_btn_y)/1.18));
		add(btn_main_Exit);
		
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
		else if(strCmd.equals("랭킹 화면")) {
			setVisible(false);
		}
		else if (strCmd.equals("게임 시작")) {
			setVisible(false);
			gameManager.manager.setPanel_Game();
		}
	}
	
	
}

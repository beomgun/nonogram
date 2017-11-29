package nonogram;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import nonogram.gameManager;


public class panel_Main extends JPanel implements ActionListener{
	public static panel_Main main;
	gameManager gm;
	
	ImageIcon imgIco = new ImageIcon("111.png","사진");
	Image img = imgIco.getImage();

	
	JButton btn_main_Start = new JButton("게임 시작");
	JButton btn_main_Rank = new JButton("랭킹 보기");
	JButton btn_main_Exit = new JButton("종료");
	
	int size_main_btn_x = 230;
	int size_main_btn_y = 80;
	
	int size_clientWidth=700;
	int size_clientHeight=700;
	boolean a = false;
	protected void frameInit() {
		setBounds(0, 0, size_clientWidth, size_clientHeight);
		setLayout(null);
		makeButtonAndEventHandle();
	}
	
	
	
	public panel_Main(gameManager gm) {
		this.gm = gm;
		size_clientWidth = gm.clientWidth;
		size_clientHeight = gm.clientHeigh;
		
		gm.addComponentListener(new ComponentAdapter() {          // JFrame의 화면크기가 변할때 마다 사이즈 변경시킴
			public void componentResized(ComponentEvent e) {
				size_clientWidth=gameManager.manager.getContentPane().getSize().width;
				size_clientHeight = gameManager.manager.getContentPane().getSize().height;
				setBounds(0, 0, size_clientWidth, size_clientHeight);
				size_main_btn_x = size_clientWidth/4;
				size_main_btn_y = size_clientHeight/10;
				makeButtonAndEventHandle();
			}
		});
		

		setBounds(0, 0, size_clientWidth, size_clientHeight);
		
		setLayout(null);
		makeButtonAndEventHandle();
	}

	public void paintComponent (Graphics g) { //g는 원래 있는 객체
		super.paintComponent(g);
		g.drawImage(img, 0, 0, size_clientWidth,size_clientHeight, this);
	
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
			gameManager.manager.goPanel_Game();
		}
	}
	
	
}

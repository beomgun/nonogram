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
	
	gameManager gm;
	
	ImageIcon imgIco = new ImageIcon("111.png","����");
	Image img = imgIco.getImage();

	
	JButton btn_main_Start = new JButton("���� ����");
	JButton btn_main_Rank = new JButton("��ŷ ����");
	JButton btn_main_Exit = new JButton("����");
	
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
		size_clientWidth = gm.getContentPane().getSize().width;
		size_clientHeight = gm.getContentPane().getSize().height;
		setBounds(0, 0, size_clientWidth, size_clientHeight);
		setLayout(null);
		makeButtonAndEventHandle();
		System.out.println(size_clientWidth);
		System.out.println(size_clientHeight);
	}

	public void paintComponent (Graphics g) { //g�� ���� �ִ� ��ü
		super.paintComponent(g);
		g.drawImage(img, 0, 0, size_clientWidth,size_clientHeight, this);
	
	}

	@Override
	public void update(Graphics g) {
		// TODO Auto-generated method stub

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
		String strCmd = e.getActionCommand(); // Ŭ���� ��ư�� �̸��� ����
		
		if (strCmd.equals("����")) {
			System.exit(0);
		}
		else if(strCmd.equals("��ŷ ȭ��")) {
			setVisible(false);
		}
		else if (strCmd.equals("���� ����")) {
			setVisible(false);
			gameManager.manager.setPanel_Game();
		}
	}
	
	
}

package game;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


public class panel_Main extends JPanel implements ActionListener{
	private static final long serialVersionUID = 1L;
	
	public static panel_Main main;
	Frame fr;
	
	ImageIcon imgIco = new ImageIcon("image/���2.gif","����");
	Image img = imgIco.getImage();

	Listener_btnChange btnListener = new Listener_btnChange();   // ��ư�� ���콺�÷����� �ٲ���ϴ� ������
	Insets m = new Insets(0, 14, 0, 0);
	
	
	
	
	JButton btn_main_Start = new JButton("���� ����");
	JButton btn_main_Rank = new JButton("��ŷ ����");
	JButton btn_main_Exit = new JButton("����");
	
	int size_main_btn_x = 100;
	int size_main_btn_y = 80;
	
	long mainStartTime = 0;
	Image offScr;
	Graphics offG;
	int size;
	
	
	public panel_Main(Frame fr) {
		this.fr = fr;
		setBounds(0, 0, Manager.manager.clientWidth, Manager.manager.clientHeight);
		setBackground(Color.WHITE);
		btn_main_Start.setIcon(new ImageIcon("image/���ӽ���.png"));
		btn_main_Start.setMargin(m);
		btn_main_Start.setBorderPainted(false);
		btn_main_Start.addMouseListener(btnListener);
		btn_main_Rank.setIcon(new ImageIcon("image/��ŷ����.png"));
		btn_main_Rank.setMargin(m);
		btn_main_Rank.addMouseListener(btnListener);
		btn_main_Rank.setBorderPainted(false);
		btn_main_Exit.setIcon(new ImageIcon("image/��������.png"));
		btn_main_Exit.setMargin(m);
		btn_main_Exit.addMouseListener(btnListener);
		btn_main_Exit.setBorderPainted(false);
		
		
		setLayout(null);
		add(btn_main_Start);
		add(btn_main_Rank);
		add(btn_main_Exit);
	}
	
	

	public void paintComponent (Graphics g) { //g�� ���� �ִ� ��ü
		setBounds(0, 0, Manager.manager.clientWidth, Manager.manager.clientHeight);
		

		offScr = createImage(Manager.manager.clientWidth, Manager.manager.clientHeight);
		offG = offScr.getGraphics();
		offG.drawImage(img, 0, 0, Manager.manager.clientWidth ,Manager.manager.clientHeight, this);

		makeButtonAndEventHandle();
		
		if(Manager.manager.mainOn==true) {
			if(Manager.manager.mainStart == true) {
				mainStartTime = System.currentTimeMillis();
				Manager.manager.mainStart = false;
			}
			Manager.manager.mainOnTime = (System.currentTimeMillis()-mainStartTime);
			size = (int)Manager.manager.mainOnTime;
			offG.setColor(new Color(54, 105, 207));
			
			
			
			
			if (size>=0) {
				
				mainAct(28,28,0);
			}
			
			if(size>=20) {
				for (int i=0; i<=5; i++) {
					mainAct(50+i*22, 50, 20+i*70);
				}
			}
			
			if(size>=400) {
				for (int i=0; i<=5; i++) {
					mainAct(510+i*22, 50, 400+i*70);
					
				}
			}
			
			
			
			if (size>=780) {
				
				mainAct(642, 28, 780);
			}
			
			
			if(size>=890) {
				for(int i=1; i<25; i++) {
					
					mainAct(50,50+i*22,820+i*70);

					mainAct(620,50+i*22,820+i*70);
				}
			}
			
			if(size>=2570) {
				for(int i=1; i<13; i++) {
					mainAct(50+i*22, 578, 2500+i*70);
					
					mainAct(620-i*22, 578, 2500+i*70);
				}
			}
			
			if(size>2600) {
				mainAct(28, 600, 2600);
				mainAct(642, 600, 2600);
			}
			if(size>3410)
				mainAct(336, 578, 3410);
			
			
			
			repaint();
			g.drawImage(offScr, 0, 0, this);
		}
	}
	
	@Override
	public void update(Graphics g) {
		super.update(g);
		paintComponent(g);
	}
		
	private void mainAct(int X, int Y, int sTime) {   // sTime�� 1000������ �ٰ�
		if(Manager.manager.mainOn==true) {
			if (size>=sTime) {
				if(size <sTime+1000) {
					offG.fillRect(X, Y,size/(sTime/20+50), size/(sTime/20+50));
				}
				else if(size >= sTime+1000) {
					offG.fillRect(X, Y,20, 20);
				}
			}
		}
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
		String strCmd = e.getActionCommand(); // Ŭ���� ��ư�� �̸��� ����
		
		if (strCmd.equals("����")) {
			
			System.exit(0);
		}
		else if(strCmd.equals("��ŷ ����")) {
			go_rank();
		}
		else if (strCmd.equals("���� ����")) {
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
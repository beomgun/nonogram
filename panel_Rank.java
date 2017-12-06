package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class panel_Rank extends JPanel implements ActionListener {
	public static panel_Rank RankManager;
	private static final long serialVersionUID = 1L;
	private Frame fr;
	
	private JButton btn_Rank_Back= new JButton("Rank_BACK");
	private JPanel panel_easy = new JPanel();
	private JPanel panel_normal = new JPanel();
	private JPanel panel_hard = new JPanel();
	
//	private JLabel label_rank, label_name, label_time;
	
	
	int size_clientWidth=700, size_clientHeight=700;
	int rankBox_width,rankBox_Height;

	Listener_btnChange btnListener = new Listener_btnChange();   // 버튼에 마우스올렸을때 바뀌게하는 리스너
	Insets m = new Insets(0, 13, 0, 0);

	JLabel rank_easyBg = new JLabel();   // 난이도에 따른 랭킹 배경화면
	JLabel rank_normalBg = new JLabel();  
	JLabel rank_hardBg = new JLabel(); 
	
	
	public panel_Rank(Frame fr) {
		RankManager = this;
		this.fr = fr;
		size_clientWidth = Manager.manager.clientWidth;
		size_clientHeight = Manager.manager.clientHeight;

		rankBox_width = (int)(size_clientWidth/1.2);
		rankBox_Height = (int)(size_clientHeight/1.1);
	
		
		
		setBounds(0, 0, Manager.manager.clientWidth, Manager.manager.clientHeight);
		setBackground(Color.WHITE);
		

		btn_Rank_Back.setIcon(new ImageIcon("rankBack.png"));
		btn_Rank_Back.setMargin(m);
		btn_Rank_Back.setBorderPainted(false);
		btn_Rank_Back.addMouseListener(btnListener);
		
		
		
		
		
		
		
		setLayout(null);
//		createRankLabel();
		makeButtonAndEventHandle();
		createRankPanel();
		
		panel_easy.add(rank_easyBg);
		panel_normal.add(rank_normalBg);
		panel_hard.add(rank_hardBg);
	
		add(btn_Rank_Back);
		add(panel_easy);  
		add(panel_normal);
		add(panel_hard);
		
		btn_Rank_Back.setVisible(true);
		
		
		panel_easy.setVisible(false);
		panel_normal.setVisible(true);
		panel_hard.setVisible(false);
	}
	
	
	
	public void actionPerformed(ActionEvent e) {
		String strCmd = e.getActionCommand(); // 클릭된 버튼의 이름을 저장
		
		if (strCmd.equals("Rank_BACK")) {
			fr.goRMain();
		}
	}
	
	
	
	
	@Override
	public void paintComponents(Graphics arg0) {
		// TODO Auto-generated method stub
		super.paintComponents(arg0);
		
		
		
	}

	
	
	public void createRankPanel() {
		//패널생성 =========================================================
		panel_easy.setLayout(null);
		panel_easy.setSize(566,550);
		panel_easy.setLocation((int)(Manager.manager.clientWidth/12),50);
		panel_easy.setBackground(Color.green);
		

		panel_normal.setLayout(null);
		panel_normal.setSize(566,550);
		panel_normal.setLocation((int)(Manager.manager.clientWidth/12),50);
		panel_normal.setBackground(Color.yellow);
		

		panel_hard.setLayout(null);
		panel_hard.setSize(566,550);
		panel_hard.setLocation((int)(Manager.manager.clientWidth/12),50);
		panel_hard.setBackground(Color.red);
		//================================================================
		
		// 패널 배경화면 생성===================================================

		rank_easyBg.setBounds(0, 0, 566, 550);   // pausePanel 의 배경이미지
		rank_easyBg.setIcon(new ImageIcon("Rank_easy.png"));
		rank_normalBg.setBounds(0, 0, 566, 550);   // pausePanel 의 배경이미지
		rank_normalBg.setIcon(new ImageIcon("Rank_normal.png"));
		rank_hardBg.setBounds(0, 0, 566, 550);   // pausePanel 의 배경이미지
		rank_hardBg.setIcon(new ImageIcon("Rank_hard.png"));
		
	}
	
	

	public void makeButtonAndEventHandle() {
		
		btn_Rank_Back.setSize(140,100 );
		btn_Rank_Back.setLocation(470,60);
		btn_Rank_Back.addActionListener(this);
		
		
	}

	// 이걺만들자 
//	public void createRankLabel() {
//		label_rank = new JLabel("RANK");
//		label_rank.setBounds(150, 160, 100, 100);
//		add(label_rank);
//		label_name = new JLabel("NAME"); 
//		label_name.setBounds(250, 160, 100, 100);
//		add(label_name);
//		
//		label_time = new JLabel("TIME");
//		label_time.setBounds(350, 160, 100, 100);
//		add(label_time);
//		
//	}
	
	
	
	
	
	
	public void ChEasy() {
		panel_easy.setVisible(true);
		panel_normal.setVisible(false);
		panel_hard.setVisible(false);
	}

	public void ChNormal() {
		panel_easy.setVisible(false);
		panel_normal.setVisible(true);
		panel_hard.setVisible(false);
	}

	public void ChHard() {
		panel_easy.setVisible(false);
		panel_normal.setVisible(false);
		panel_hard.setVisible(true);
	}
	
	
	public static void main(String[] args) {
	
	}


}
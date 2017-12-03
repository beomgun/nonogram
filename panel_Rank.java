package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class panel_Rank extends JPanel implements ActionListener {
	public static panel_Rank RankManager;
	private static final long serialVersionUID = 1L;
	private Frame fr;
	
	private JButton btn_Rank_Back= new JButton("BACK");
	private JPanel panel_easy = new JPanel();
	private JPanel panel_normal = new JPanel();
	private JPanel panel_hard = new JPanel();
	
	private JLabel label_rank, label_name, label_time;
	private JLabel label_1_rank, label_1_name, label_1_time;
	private JLabel label_2_rank, label_2_name, label_2_time;
	private JLabel label_3_rank, label_3_name, label_3_time;
	
	
	int size_clientWidth=700, size_clientHeight=700;
	int rankBox_width,rankBox_Height;
	
	
	public panel_Rank(Frame fr) {
		RankManager = this;
		this.fr = fr;
		size_clientWidth = Manager.manager.clientWidth;
		size_clientHeight = Manager.manager.clientHeight;

		rankBox_width = (int)(size_clientWidth/1.2);
		rankBox_Height = (int)(size_clientHeight/1.1);
	
		
		
		setBounds(0, 0, Manager.manager.clientWidth, Manager.manager.clientHeight);
		setLayout(null);
		createRankLabel();
		makeButtonAndEventHandle();
		createRankPanel();
		
	
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
		
		if (strCmd.equals("BACK")) {
			fr.goRMain();
		}
	}
	
	
	
	
	@Override
	public void paintComponents(Graphics arg0) {
		// TODO Auto-generated method stub
		super.paintComponents(arg0);
		
		
		
	}

	
	
	public void createRankPanel() {
		panel_easy.setLayout(null);
		panel_easy.setSize((int)(Manager.manager.clientWidth/1.2),450);
		panel_easy.setLocation((int)(Manager.manager.clientWidth/12),150);
		panel_easy.setBackground(Color.green);
		

		panel_normal.setLayout(null);
		panel_normal.setSize((int)(Manager.manager.clientWidth/1.2),450);
		panel_normal.setLocation((int)(Manager.manager.clientWidth/12),150);
		panel_normal.setBackground(Color.yellow);
		

		panel_hard.setLayout(null);
		panel_hard.setSize((int)(Manager.manager.clientWidth/1.2),450);
		panel_hard.setLocation((int)(Manager.manager.clientWidth/12),150);
		panel_hard.setBackground(Color.red);
	}
	
	

	public void makeButtonAndEventHandle() {
		
		btn_Rank_Back.setSize(170,80 );
		btn_Rank_Back.setLocation(470,60);
		btn_Rank_Back.addActionListener(this);
		
		
	}

	// 이걺만들자 
	public void createRankLabel() {
		label_rank = new JLabel("RANK");
		label_rank.setBounds(150, 160, 100, 100);
		add(label_rank);
		label_name = new JLabel("NAME"); 
		label_name.setBounds(250, 160, 100, 100);
		add(label_name);
		
		label_time = new JLabel("TIME");
		
		label_1_rank = new JLabel("1"); 
		label_1_rank.setBounds(150, 260, 100, 100);
		add(label_1_rank);
		
		label_1_name = new JLabel(); 
		label_1_time = new JLabel();
		label_2_rank = new JLabel("2"); 
		label_2_name = new JLabel(); 
		label_2_time = new JLabel();
		label_3_rank = new JLabel("3"); 
		label_3_name = new JLabel(); 
		label_3_time = new JLabel();
	}
	
	
	
	
	
	
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
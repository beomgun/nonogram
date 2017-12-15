package game;

import java.awt.Color;
import java.awt.Font;
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
	
	
	
	private JLabel label_name_1 = new JLabel("NAME");
	private JLabel label_name_2 = new JLabel("NAME");
	private JLabel label_name_3 = new JLabel("NAME");
	
	private JLabel label_time_1 = new JLabel("TIME");
	private JLabel label_time_2 = new JLabel("TIME");
	private JLabel label_time_3 = new JLabel("TIME");
	
	
	
	
	int size_clientWidth=700, size_clientHeight=700;
	int rankBox_width,rankBox_Height;

	Listener_btnChange btnListener = new Listener_btnChange();   // 버튼에 마우스올렸을때 바뀌게하는 리스너
	Insets m = new Insets(0, 13, 0, 0);

	JLabel rank_easyBg = new JLabel();   // 난이도에 따른 랭킹 배경화면
	JLabel rank_normalBg = new JLabel();  
	JLabel rank_hardBg = new JLabel(); 
	
	
	boolean setting = true;
	
	
	
	
	
	public panel_Rank(Frame fr) {
		RankManager = this;
		this.fr = fr;
		size_clientWidth = Manager.manager.clientWidth;
		size_clientHeight = Manager.manager.clientHeight;

		rankBox_width = (int)(size_clientWidth/1.2);
		rankBox_Height = (int)(size_clientHeight/1.1);
	
		
		
		setBounds(0, 0, Manager.manager.clientWidth, Manager.manager.clientHeight);
		setBackground(Color.WHITE);
		

		btn_Rank_Back.setIcon(new ImageIcon("image/rankBack.png"));
		btn_Rank_Back.setMargin(m);
		btn_Rank_Back.setBorderPainted(false);
		btn_Rank_Back.addMouseListener(btnListener);
		
		

		setLabel_normal();
		
		
		
		setLayout(null);
		createRankLabel();
		makeButtonAndEventHandle();
		createRankPanel();
		
		panel_easy.add(rank_easyBg);
		panel_normal.add(rank_normalBg);
		panel_hard.add(rank_hardBg);
	
		add(btn_Rank_Back);
		
		add(label_name_1);
		add(label_name_2);
		add(label_name_3);

		add(label_time_1);
		add(label_time_2);
		add(label_time_3);
		
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
		rank_easyBg.setIcon(new ImageIcon("image/Rank_easy.png"));
		rank_normalBg.setBounds(0, 0, 566, 550);   // pausePanel 의 배경이미지
		rank_normalBg.setIcon(new ImageIcon("image/Rank_normal.png"));
		rank_hardBg.setBounds(0, 0, 566, 550);   // pausePanel 의 배경이미지
		rank_hardBg.setIcon(new ImageIcon("image/Rank_hard.png"));
		
	}
	
	

	public void makeButtonAndEventHandle() {
		
		btn_Rank_Back.setSize(140,100 );
		btn_Rank_Back.setLocation(460,75);
		btn_Rank_Back.addActionListener(this);
		
		
	}

	public void createRankLabel() {
		label_name_1.setFont(new Font("휴먼편지체",Font.BOLD,30));
		label_name_1.setForeground(new Color(157,27,91));
		label_name_1.setBounds(215, 300, 170, 100);
		label_name_1.setHorizontalAlignment(SwingConstants.CENTER);
		add(label_name_1);
		

		label_name_2.setFont(new Font("휴먼편지체",Font.BOLD,30));
		label_name_2.setForeground(new Color(157,27,91));
		label_name_2.setBounds(215, 367, 170, 100);
		label_name_2.setHorizontalAlignment(SwingConstants.CENTER);
		add(label_name_2);

		label_name_3.setFont(new Font("휴먼편지체",Font.BOLD,30));
		label_name_3.setForeground(new Color(157,27,91));
		label_name_3.setBounds(215, 434, 170, 100);
		label_name_3.setHorizontalAlignment(SwingConstants.CENTER);
		add(label_name_3);

		
		
		label_time_1.setFont(new Font("휴먼편지체",Font.BOLD,30));
		label_time_1.setForeground(new Color(157,27,91));
		label_time_1.setBounds(390, 300, 150, 100);
		label_time_1.setHorizontalAlignment(SwingConstants.RIGHT);
		add(label_time_1);

		label_time_2.setFont(new Font("휴먼편지체",Font.BOLD,30));
		label_time_2.setForeground(new Color(157,27,91));
		label_time_2.setBounds(390, 367, 150, 100);
		label_time_2.setHorizontalAlignment(SwingConstants.RIGHT);
		add(label_time_2);

		label_time_3.setFont(new Font("휴먼편지체",Font.BOLD,30));
		label_time_3.setForeground(new Color(157,27,91));
		label_time_3.setBounds(390, 434, 150, 100);
		label_time_3.setHorizontalAlignment(SwingConstants.RIGHT);
		add(label_time_3);
		
	}
	
	
	
	
	
	
	public void ChEasy() {
		panel_easy.setVisible(true);
		panel_normal.setVisible(false);
		panel_hard.setVisible(false);
		setLabel_easy();
		
	}

	public void ChNormal() {
		panel_easy.setVisible(false);
		panel_normal.setVisible(true);
		panel_hard.setVisible(false);

		setLabel_normal();
	}

	public void ChHard() {
		panel_easy.setVisible(false);
		panel_normal.setVisible(false);
		panel_hard.setVisible(true);
		
		setLabel_hard();
	}
	
	
	
	
	
	void setLabel_easy() {
		label_name_1.setText(Manager.manager.rk.rank_name[0][0]);
		label_name_2.setText(Manager.manager.rk.rank_name[0][1]);
		label_name_3.setText(Manager.manager.rk.rank_name[0][2]);
		
		if(Manager.manager.rk.rank_time[0][0]/60 <1)
			label_time_1.setText(Manager.manager.rk.rank_time[0][0]+"초");
		else
			label_time_1.setText(Manager.manager.rk.rank_time[0][0]/60 + "분 "+Manager.manager.rk.rank_time[0][0]%60+"초");

		if(Manager.manager.rk.rank_time[0][1]/60 <1)
			label_time_2.setText(Manager.manager.rk.rank_time[0][1]+"초");
		else
			label_time_2.setText(Manager.manager.rk.rank_time[0][1]/60 + "분 "+Manager.manager.rk.rank_time[0][1]%60+"초");
		
		if(Manager.manager.rk.rank_time[0][2]/60 <1)
			label_time_3.setText(Manager.manager.rk.rank_time[0][2]+"초");
		else
			label_time_3.setText(Manager.manager.rk.rank_time[0][2]/60 + "분 "+Manager.manager.rk.rank_time[0][2]%60+"초");
		

		if(Manager.manager.rk.rank_time[0][0] == 99999999) {
			label_time_1.setText("-    ");
		}
		if(Manager.manager.rk.rank_time[0][1] == 99999999) {
			label_time_2.setText("-    ");
		}
		if(Manager.manager.rk.rank_time[0][2] == 99999999) {
			label_time_3.setText("-    ");
		}
	}
	void setLabel_normal() {
		label_name_1.setText(Manager.manager.rk.rank_name[1][0]);
		label_name_2.setText(Manager.manager.rk.rank_name[1][1]);
		label_name_3.setText(Manager.manager.rk.rank_name[1][2]);
		
		if(Manager.manager.rk.rank_time[1][0]/60 <1)
			label_time_1.setText(Manager.manager.rk.rank_time[1][0]+"초");
		else
			label_time_1.setText(Manager.manager.rk.rank_time[1][0]/60 + "분  "+Manager.manager.rk.rank_time[1][0]%60+"초");

		if(Manager.manager.rk.rank_time[1][1]/60 <1)
			label_time_2.setText(Manager.manager.rk.rank_time[1][1]+"초");
		else
			label_time_2.setText(Manager.manager.rk.rank_time[1][1]/60 + "분  "+Manager.manager.rk.rank_time[1][1]%60+"초");
		
		if(Manager.manager.rk.rank_time[1][2]/60 <1)
			label_time_3.setText(Manager.manager.rk.rank_time[1][2]+"초");
		else
			label_time_3.setText(Manager.manager.rk.rank_time[1][2]/60 + "분  "+Manager.manager.rk.rank_time[1][2]%60+"초");
		
		
		if(Manager.manager.rk.rank_time[1][0] == 99999999) {
			label_time_1.setText("-    ");
		}
		if(Manager.manager.rk.rank_time[1][1] == 99999999) {
			label_time_2.setText("-    ");
		}
		if(Manager.manager.rk.rank_time[1][2] == 99999999) {
			label_time_3.setText("-    ");
		}
	}
	
	
	void setLabel_hard() {
		label_name_1.setText(Manager.manager.rk.rank_name[2][0]);
		label_name_2.setText(Manager.manager.rk.rank_name[2][1]);
		label_name_3.setText(Manager.manager.rk.rank_name[2][2]);
		
		if(Manager.manager.rk.rank_time[2][0]/60 <1)
			label_time_1.setText(Manager.manager.rk.rank_time[2][0]+"초");
		else
			label_time_1.setText(Manager.manager.rk.rank_time[2][0]/60 + "분  "+Manager.manager.rk.rank_time[2][0]%60+"초");
	
		if(Manager.manager.rk.rank_time[2][1]/60 <1)
			label_time_2.setText(Manager.manager.rk.rank_time[2][1]+"초");
		else
			label_time_2.setText(Manager.manager.rk.rank_time[2][1]/60 + "분  "+Manager.manager.rk.rank_time[2][1]%60+"초");
		
		if(Manager.manager.rk.rank_time[2][2]/60 <1)
			label_time_3.setText(Manager.manager.rk.rank_time[2][2]+"초");
		else
			label_time_3.setText(Manager.manager.rk.rank_time[2][2]/60 + "분  "+Manager.manager.rk.rank_time[2][2]%60+"초");
		
	
		if(Manager.manager.rk.rank_time[2][0] == 99999999) {
			label_time_1.setText("-    ");
		}
		if(Manager.manager.rk.rank_time[2][1] == 99999999) {
			label_time_2.setText("-    ");
		}
		if(Manager.manager.rk.rank_time[2][2] == 99999999) {
			label_time_3.setText("-    ");
		}
		
	}
	
	
	void regist(int level) {
		if (level == 1)
			setLabel_easy();
		else if (level ==2)
			setLabel_normal();
		else if (level == 3)
			setLabel_hard();
	}
	

}
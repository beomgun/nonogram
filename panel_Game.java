package game;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class panel_Game extends JPanel implements ActionListener,MouseListener, MouseMotionListener{
	private static final long serialVersionUID = 1L;
	Frame fr;
	
	private JButton btn_play_pause= new JButton("PAUSE");
	
	private JPanel pPause = new JPanel();
	private JButton btn_pause_back= new JButton("BACK");
	private JButton btn_pause_main=new JButton("MAIN");
	
	int board_start_x,board_start_y;
	int xboxSize,yboxSize;
	
	boolean mouseMoved = false;
	boolean gameOver = false;
	StringBuffer userAns = new StringBuffer("");
	String st = new String();	
	String ans = new String();
	int xSize=15,ySize = 15;
	
	private JLabel lab_time = new JLabel("00:00");

	int PauseBoxWidth;
	int PauseBoxHeight;
	int size_clientWidth;
	int size_clientHeight;

	JPanel pEnd = new JPanel();
	JTextField tf_end_name = new JTextField();     // 3���̳� �� �� �̸��Է�ĭ
	JButton btn_end_regist = new JButton("����ϱ�"); // 3���̳� �� �� ��ŷ ��� ĭ
	JButton btn_end_goMain = new JButton("Ȩ����");
	JButton btn_end_goRank = new JButton("��ŷ ����");
	
	
	
	
	
	int mousePos_X, mousePos_Y;
	
	Image offScr;
	Graphics offG;  
	
	
	
	public panel_Game(Frame fr) {
		this.fr = fr;
		xSize=Manager.manager.xSize;
		ySize = Manager.manager.ySize;
		ans = Manager.manager.easy_1;
		
		for(int i=0; i<ySize;i++) {
			for(int j=0; j<xSize; j++) {
				userAns.append("0");
				st = userAns.toString();
			}
		}
		
		setBounds(0, 0, Manager.manager.clientWidth, Manager.manager.clientHeight);
		
		setLayout(null);
		add(pPause);     
		pPause.add(btn_pause_main);
		pPause.add(btn_pause_back);
		pPause.setVisible(false);
		
		add(pEnd);
		pEnd.add(tf_end_name);
		pEnd.add(btn_end_regist);
		pEnd.add(btn_end_goMain);
		pEnd.add(btn_end_goRank);
		pEnd.setVisible(false);
		
		add(lab_time);
		add(btn_play_pause);
		addMouseListener(this);
		addMouseMotionListener(this);
	}
	
	@Override
	public void update(Graphics g) {
		// TODO Auto-generated method stub
		super.update(g);
		paintComponent(g);
	}
	
	
	public void paintComponent (Graphics g) { //g�� ���� �ִ� ��ü
		super.paintComponent(g);

		xSize = Manager.manager.xSize;
		ySize = Manager.manager.ySize;
		
		size_clientWidth = Manager.manager.clientWidth;
		size_clientHeight = Manager.manager.clientHeight;
		
		offScr = createImage(size_clientWidth, size_clientHeight);
		offG = offScr.getGraphics();
		
		PauseBoxWidth = (int)(size_clientWidth/1.2);
		PauseBoxHeight = (int)(size_clientHeight/1.1);
		
		xboxSize = (int)(size_clientWidth/1.7)/xSize;
		yboxSize = (int)(size_clientHeight/1.7)/ySize;
		
		

		makeButtonAndEventHandle();
		createPausePanel();
		createEndPanel();
		
		
		// �簢�� ������ �������� x��ǥ (start_x) : size_clientWidth/3
		// �簢�� ������ �������� y��ǥ (start_y) : (int)(size_clientHeight/2.5)
		board_start_x = size_clientWidth/3-30;
		board_start_y = (int)(size_clientHeight/2.5)-30;
		
		
		
		// ���� ������ ���� line ���
		for(int j=0;j<ySize+1;j++) {
			offG.drawLine( board_start_x -size_clientWidth/6, board_start_y + j*yboxSize, board_start_x +xSize*xboxSize,  board_start_y+j*yboxSize);
			if (j % 5 ==0)
				offG.drawLine( board_start_x -size_clientWidth/6, board_start_y + j*yboxSize-1, board_start_x +xSize*xboxSize,  board_start_y+j*yboxSize-1);
		}
		// �׳� �簢�� ����������� �������θ� �ص� �ȵǳ�?
		
		// ���� line ���
		for (int i=0; i<xSize+1; i++) {
			offG.drawLine( board_start_x +i*xboxSize,  board_start_y-size_clientHeight/6, board_start_x +i*xboxSize,  board_start_y + ySize*yboxSize);
			if (i % 5 ==0)
				offG.drawLine( board_start_x +i*xboxSize-1,  board_start_y-size_clientHeight/6, board_start_x +i*xboxSize-1,  board_start_y + ySize*yboxSize);
		}
		// ������� ��

		if(gameOver==true) {
			go_end();
		}
		else {                              // ������ ������ ������Ұ͵�.
			// �������� ���콺 �����̸� ��ǥ ������
			if(mouseMoved==true) {
	
				int i = (mousePos_X-board_start_x)/xboxSize;
				int j = (mousePos_Y-board_start_y)/yboxSize;
				offG.setColor(new Color(0, 0, 0, 40));
				offG.fillRect( board_start_x -size_clientWidth/6, board_start_y + j*yboxSize, size_clientWidth/6 +(i+1)*xboxSize , yboxSize);
				offG.fillRect(board_start_x + i*xboxSize,board_start_y-size_clientHeight/6,xboxSize,size_clientHeight/6 + (j+1)*yboxSize);
				
				repaint();
			}
			// ��...
			
			// Ŭ���ϸ� �ȿ� ���� �ٲ� 
			for(int i=0; i<xSize; i++) {
				for(int j=0; j<ySize; j++) {
					if(st.charAt(j*ySize+i) == '2') {  // ��ĭ
						offG.setColor(Color.BLACK);
						offG.drawRect( board_start_x+i*xboxSize, board_start_y + j*yboxSize,xboxSize , yboxSize);
					}
					else if(st.charAt(j*ySize+i) == '1') {  // ä��ĭ
						offG.setColor(Color.BLACK);
						offG.fillRect( board_start_x+i*xboxSize, board_start_y + j*yboxSize,xboxSize , yboxSize);
					}
					else if (st.charAt(j*ySize+i) == '0') {
						offG.setColor(Color.BLACK);
						offG.drawLine(board_start_x+i*xboxSize, board_start_y + j*yboxSize,board_start_x+(i+1)*xboxSize, board_start_y + (j+1)*yboxSize);
						offG.drawLine(board_start_x+i*xboxSize, board_start_y + (j+1)*yboxSize,board_start_x+(i+1)*xboxSize, board_start_y + j*yboxSize);
					}
		
					repaint();
				}
				
			}
			//====================================================
		}
			
		// ���� ���� ���� ������ 
		int cnt_r = 0, cnt_c=0; // 1�������� ����
		boolean cnt_zero_r =true, cnt_zero_c=true; // 0�� ���������� 0��¿�
		
		int w_r = 0, w_c=0;
		int cnt_colH=0;
		StringBuffer row = new StringBuffer();
		StringBuffer col = new StringBuffer();
		offG.setFont(g.getFont().deriveFont(Font.BOLD, 12f));
		for (int i = 0; i<xSize; i++) {
			for(int j=0; j<ySize; j++) {
				// ������(row)���� ¥��=====================================
				if(ans.charAt(i*xSize+j) == '1') {   
					cnt_r++;
					cnt_zero_r = false;
					if(j==ySize-1) {
						if(cnt_r != 0) {
							row.append("    "+cnt_r);
							cnt_r=0;
						}
					}
				}
				else if(ans.charAt(i*xSize+j) == '0') {
					if(cnt_r != 0) {
						row.append("    "+cnt_r);
						cnt_r=0;
					}
				}
				
				FontMetrics fm_r = g.getFontMetrics();
				w_r = fm_r.stringWidth(row.toString()); 
				// ������(row)===========================================
				
				// ������(col)¥��===========================================
				if(ans.charAt((ySize-j-1)*ySize+i) == '1') {  
					cnt_c++;
					cnt_zero_c = false;
					if(j==ySize-1) {
						if(cnt_c != 0) {
							col.append(cnt_c);
							cnt_c=0;
							offG.drawString(col.toString(), board_start_x+(i+1)*xboxSize-xboxSize/2,board_start_y- cnt_colH*23-12); 
							cnt_colH++;
						}
					}
				}
				else if(ans.charAt((ySize-j-1)*ySize+i) == '0') {
					if(cnt_c != 0) {
						col.append(cnt_c);
						cnt_c=0;
						offG.drawString(col.toString(), board_start_x+(i+1)*xboxSize-xboxSize/2,board_start_y- cnt_colH*23-12); 
						cnt_colH++;
					}
				}
				
				FontMetrics fm_c = g.getFontMetrics();
				w_c = fm_c.stringWidth(col.toString()); 
				col.delete(0, col.length());
				//=======================================================
			}	
			cnt_colH = 0;
			//������ ���ڵ��� �ȿ���Ƴ�=======================
			if(cnt_zero_r == true && w_r==0) {
				offG.drawString("0", board_start_x-w_r-26, board_start_y+(i)*yboxSize+(int)(yboxSize/1.6)); 
			}
			else
				cnt_zero_r=true;
			offG.drawString(row.toString(), board_start_x-w_r-20, board_start_y+(i)*yboxSize+(int)(yboxSize/1.6)); 
			row.delete(0, row.length());
			//===========================================
			//������ ���ڵ��� �ȿ� ��Ƴ�======================
			if(cnt_zero_c == true && w_c==0) {
				offG.drawString("0", board_start_x+(i+1)*xboxSize-xboxSize/2, board_start_y-12); 
			}
			else
				cnt_zero_c=true;

			//=========================================
		}
		
	
		
		
		
		
		g.drawImage(offScr, 0, 0, this);
	}
	
	
	public void createPausePanel() {
		pPause.setLayout(null);
		pPause.setSize(PauseBoxWidth,PauseBoxHeight);
		pPause.setLocation((size_clientWidth-PauseBoxWidth)/2,(size_clientHeight-PauseBoxHeight)/2);
		pPause.setBackground(Color.YELLOW);
		
	}
	
	public void createEndPanel() {
		pEnd.setLayout(null);
		pEnd.setBounds((size_clientWidth-PauseBoxWidth)/2, (size_clientHeight-PauseBoxHeight)/2, PauseBoxWidth, PauseBoxHeight);
		pEnd.setBackground(new Color(0, 130,153,180));
	}
	
	
	
	public void makeButtonAndEventHandle() {
		
		// PLAY //=====================================================
		lab_time.setSize(size_clientWidth/5, size_clientHeight/10);
		lab_time.setLocation(size_clientWidth/17, size_clientHeight/10);
		lab_time.setFont(new Font("Serif",Font.PLAIN,50));
		
		btn_play_pause.setSize(size_clientWidth/5,size_clientHeight/10 );
		btn_play_pause.setLocation(size_clientWidth/17,(int)(size_clientHeight/4.7));
		//===========================================================
		
		
		// PAUSE //====================================================
		btn_pause_back.setSize(PauseBoxWidth/2,PauseBoxHeight/5);
		btn_pause_back.setLocation((PauseBoxWidth-PauseBoxWidth/2)/2, (int)(PauseBoxHeight/2.3));
		
		btn_pause_main.setSize(PauseBoxWidth/2,PauseBoxHeight/5);
		btn_pause_main.setLocation((PauseBoxWidth-PauseBoxWidth/2)/2,(int)(PauseBoxHeight/1.4));
		//==============================================================
		
		
		// END //=======================================================
		btn_end_regist.setBounds((PauseBoxWidth-PauseBoxWidth/2)/2, (int)(PauseBoxHeight/7), PauseBoxWidth/2, PauseBoxHeight/5);
		btn_end_goMain.setBounds((PauseBoxWidth-PauseBoxWidth/2)/2,(int)(PauseBoxHeight/2.3), PauseBoxWidth/2, PauseBoxHeight/7);
		btn_end_goRank.setBounds((PauseBoxWidth-PauseBoxWidth/2)/2, (int)(PauseBoxHeight/1.4), PauseBoxWidth/2, PauseBoxHeight/10);
		// ��ư�̺�Ʈ, ������ ���߿� �߰�����.  �ð������ ��ŷ¥�� �Լ� ���� �㿡 �����.
		//==============================================================
		
		
	
		// Listener //
		btn_play_pause.addActionListener(this);
		btn_pause_back.addActionListener(this);
		btn_pause_main.addActionListener(this);
		
		btn_end_regist.addActionListener(this);
		btn_end_goMain.addActionListener(this);
		btn_end_goRank.addActionListener(this);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String strCmd = e.getActionCommand(); // Ŭ���� ��ư�� �̸��� ����
		
		if (strCmd.equals("PAUSE")) {
			go_pause();
		}
		else if(strCmd.equals("BACK")) {
			go_back();
		}
		else if (strCmd.equals("MAIN")) {
			go_main();
		}
		
		// end�гι�ư��
		else if(strCmd.equals("Ȩ����")) {
			go_main();
		}
		else if(strCmd.equals("��ŷ ����")) {
			go_rank();
		}
		else if(strCmd.equals("����ϱ�")) {
			// ����� �Լ� �����ؾ���
		}
	}
	
	
	
	void go_pause() {
		pPause.setVisible(true);
		btn_play_pause.setVisible(false);
		lab_time.setVisible(false);
	}
	
	
	void go_back() {
		pPause.setVisible(false);
		btn_play_pause.setVisible(true);
		lab_time.setVisible(true);
	}

	void go_main() {
		fr.goMain();
		
	}
	
	void go_end() {
		pEnd.setVisible(true);
		btn_play_pause.setEnabled(false);
	}
	
	void go_rank() {
		fr.goRank_inGame();
	}
	

	@Override
	public void mouseClicked(MouseEvent e) {
		
		
	}


	@Override
	public void mouseEntered(MouseEvent e) {	}


	@Override
	public void mouseExited(MouseEvent e) {	}


	@Override
	public void mousePressed(MouseEvent e) {
		mousePos_X = e.getX();
		mousePos_Y = e.getY();
		st = userAns.toString();
		
		int i = (mousePos_X-board_start_x)/xboxSize;
		int j = (mousePos_Y-board_start_y)/yboxSize;
		 if(SwingUtilities.isLeftMouseButton(e)){
		        //my code
			 if (mousePos_X >= board_start_x && mousePos_X <= board_start_x +xSize*xboxSize) {
					if (mousePos_Y>= board_start_y && mousePos_Y <= board_start_y + ySize*yboxSize) {
						
						if(st.charAt(j*ySize+i) == '2')      // ��ĭ
							userAns.replace(j*ySize+i, j*ySize+i+1, "1");				
						else if(st.charAt(j*ySize+i) == '1')   // ��ä�� ĭ
							userAns.replace(j*ySize+i, j*ySize+i+1, "0");
						else if(st.charAt(j*ySize+i) == '0')   // X�� ĭ
							userAns.replace(j*ySize+i, j*ySize+i+1, "2");
						st = userAns.toString();
		// ����üũ =======================================================
						if(st.equals(Manager.manager.easy_1)) {
							gameOver=true;
						}
						
						
					}
			 }	
		 }
		 if(SwingUtilities.isRightMouseButton(e)){
		        //my code
			 if (mousePos_X >= board_start_x && mousePos_X <= board_start_x +xSize*xboxSize) {
					if (mousePos_Y>= board_start_y && mousePos_Y <= board_start_y + ySize*yboxSize) {
						
						if(st.charAt(j*ySize+i) == '2')      // ��ĭ
							userAns.replace(j*ySize+i, j*ySize+i+1, "0");				
						else if(st.charAt(j*ySize+i) == '1')   // ��ä�� ĭ
							userAns.replace(j*ySize+i, j*ySize+i+1, "0");
						else if(st.charAt(j*ySize+i) == '0')   // X�� ĭ
							userAns.replace(j*ySize+i, j*ySize+i+1, "2");
						st = userAns.toString();
		// ����üũ =======================================================
						if(st.equals(Manager.manager.easy_1))
							System.out.println("��");
						
						
					}
			 }	
		    }
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {	}




	@Override
	public void mouseDragged(MouseEvent e) {
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
		mousePos_X = e.getX();
		mousePos_Y = e.getY();
		
		
		if (mousePos_X >= board_start_x && mousePos_X <= board_start_x +xSize*xboxSize) {
			if (mousePos_Y>= board_start_y && mousePos_Y <= board_start_y + ySize*yboxSize) {
				mouseMoved = true;
			}
			else {
				mouseMoved = false;
				}
		}	
		else
			mouseMoved = false;
	}
	

	
	

	
}
package game;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import nonogram.gameManager;
public class panel_Game extends JPanel implements ActionListener,MouseListener{
	private static final long serialVersionUID = 1L;
	Frame fr;
	
	private JButton btn_play_pause= new JButton("PAUSE");
	
	private JPanel pPause = new JPanel();
	private JButton btn_pause_back= new JButton("BACK");
	private JButton btn_pause_main=new JButton("MAIN");
	
	int board_start_x,board_start_y;
	int xboxSize,yboxSize;
	
	private JLabel lab_time = new JLabel("00:00");

	int PauseBoxWidth;
	int PauseBoxHeight;
	int size_clientWidth;
	int size_clientHeight;

	JLabel startTimer = new JLabel("5");
	
	
	
	
	
	Image offScr;
	Graphics offG;  
	
	public panel_Game(Frame fr) {
		this.fr = fr;
	
		setBounds(0, 0, Manager.manager.clientWidth, Manager.manager.clientHeight);
		
		setLayout(null);
		add(pPause);     
		pPause.add(btn_pause_main);
		pPause.add(btn_pause_back);
		pPause.setVisible(false);
		add(lab_time);
		add(btn_play_pause);
		addMouseListener(this);
	}
	
	
	
	
	public void paintComponent (Graphics g) { //g는 원래 있는 객체
		super.paintComponent(g);
		
		size_clientWidth = Manager.manager.clientWidth;
		size_clientHeight = Manager.manager.clientHeight;
		int xSize = Manager.manager.xSize;
		int ySize = Manager.manager.ySize;
		
		offScr = createImage(size_clientWidth, size_clientHeight);
		offG = offScr.getGraphics();
		
		PauseBoxWidth = (int)(size_clientWidth/1.2);
		PauseBoxHeight = (int)(size_clientHeight/1.1);
		
		xboxSize = (int)(size_clientWidth/1.7)/xSize;
		yboxSize = (int)(size_clientHeight/1.7)/ySize;
		
		

		makeButtonAndEventHandle();
		createPausePanel();
		
		
		// 사각형 왼쪽위 시작점의 x좌표 (start_x) : size_clientWidth/3
		// 사각형 왼쪽위 시작점의 y좌표 (start_y) : (int)(size_clientHeight/2.5)
		board_start_x = size_clientWidth/3-30;
		board_start_y = (int)(size_clientHeight/2.5)-30;
		
		// 숫자 보여줄 가로 line 출력
		for(int j=0;j<ySize+1;j++) {
			offG.drawLine( board_start_x -size_clientWidth/6, board_start_y + j*yboxSize, board_start_x +xSize*xboxSize,  board_start_y+j*yboxSize);
			if (j % 5 ==0)
				offG.drawLine( board_start_x -size_clientWidth/6, board_start_y + j*yboxSize-1, board_start_x +xSize*xboxSize,  board_start_y+j*yboxSize-1);
		}
		// 그냥 사각형 출력하지말고 라인으로만 해도 안되나?
		
		// 세로 line 출력
		for (int i=0; i<xSize+1; i++) {
			offG.drawLine( board_start_x +i*xboxSize,  board_start_y-size_clientHeight/6, board_start_x +i*xboxSize,  board_start_y + ySize*yboxSize);
			if (i % 5 ==0)
				offG.drawLine( board_start_x +i*xboxSize-1,  board_start_y-size_clientHeight/6, board_start_x +i*xboxSize-1,  board_start_y + ySize*yboxSize);
		}
		// 라인출력 끝
		g.drawImage(offScr, 0, 0, this);
	}
	
	
	public void createPausePanel() {
		pPause.setLayout(null);
		pPause.setSize(PauseBoxWidth,PauseBoxHeight);
		pPause.setLocation((size_clientWidth-PauseBoxWidth)/2,(size_clientHeight-PauseBoxHeight)/2);
		pPause.setBackground(Color.YELLOW);
		
	}
	
	
	
	public void makeButtonAndEventHandle() {
		lab_time.setSize(size_clientWidth/5, size_clientHeight/10);
		lab_time.setLocation(size_clientWidth/17, size_clientHeight/10);
		lab_time.setFont(new Font("Serif",Font.PLAIN,50));
		
		btn_play_pause.setSize(size_clientWidth/5,size_clientHeight/10 );
		btn_play_pause.setLocation(size_clientWidth/17,(int)(size_clientHeight/4.7));
		
		
		
		// PAUSE//
		btn_pause_back.setSize(PauseBoxWidth/2,PauseBoxHeight/5);
		btn_pause_back.setLocation((PauseBoxWidth-PauseBoxWidth/2)/2, PauseBoxHeight/5);
		
		btn_pause_main.setSize(PauseBoxWidth/2,PauseBoxHeight/5);
		btn_pause_main.setLocation((PauseBoxWidth-PauseBoxWidth/2)/2,PauseBoxHeight*3/5);
		///////////////////
		
		
		// Listener //
		btn_play_pause.addActionListener(this);
		btn_pause_back.addActionListener(this);
		btn_pause_main.addActionListener(this);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String strCmd = e.getActionCommand(); // 클릭된 버튼의 이름을 저장
		
		if (strCmd.equals("PAUSE")) {
			go_pause();
		}
		else if(strCmd.equals("BACK")) {
			go_back();
		}
		else if (strCmd.equals("MAIN")) {
			go_main();
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
	
	

	@Override
	public void mouseClicked(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		
		if (x >= board_start_x && x <= board_start_x +Manager.manager.xSize*xboxSize) {
			if (y>= board_start_y && y <= board_start_y + Manager.manager.ySize*yboxSize) {
				lab_time.setText(x+" "+y);
				return;
			}
		}	
	}


	@Override
	public void mouseEntered(MouseEvent e) {	}


	@Override
	public void mouseExited(MouseEvent e) {	}


	@Override
	public void mousePressed(MouseEvent e) {	}


	@Override
	public void mouseReleased(MouseEvent e) {	}
	


	
	

	
}

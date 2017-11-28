package nonogram;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import logic.game_Main;
import logic.main_start;

public class panel_Game extends JPanel implements ActionListener,MouseListener{
	private static final long serialVersionUID = 1L;
	defaultValue dv = new defaultValue();
	
	private int xSize = 20;  // x축길이
	private int ySize = 20;  // y축 길이
	private int board[][] = new int[xSize][ySize];
	
	private JButton btn_play_pause= new JButton("PAUSE");
	private JPanel pPause = new JPanel();
	
	private JButton btn_pause_back= new JButton("BACK");
	private JButton btn_pause_main=new JButton("MAIN");
	
	private boolean game_Pause = false;
	private int board_start_x,board_start_y;
	private int xboxSize,yboxSize;

	int PauseBoxWidth = (int)(dv.clientWidth/1.2);
	int PauseBoxHeight = (int)(dv.clientHeight/1.1);
	
	
	
	private JLabel time = new JLabel("00:00");

	Image offScr;
	Graphics offG;  
	
	
	
	public panel_Game() {
		setLayout(null);
		createPausePanel();
		makeButtonAndEventHandle();
	}
	

	public void paintComponent (Graphics g) { //g는 원래 있는 객체
		super.paintComponent(g);
		
		offScr = createImage(dv.clientWidth, dv.clientHeight);
		offG = offScr.getGraphics();
		
		
		xboxSize = (int)(dv.clientWidth/1.7)/xSize;
		yboxSize = (int)(dv.clientHeight/1.7)/ySize;
		
		
		
		
		// 사각형 왼쪽위 시작점의 x좌표 (start_x) : dv.clientWidth/3
		// 사각형 왼쪽위 시작점의 y좌표 (start_y) : (int)(dv.clientHeight/2.5)
		board_start_x = dv.clientWidth/3;
		board_start_y = (int)(dv.clientHeight/2.5);
		
		// 숫자 보여줄 가로 line 출력
		for(int j=0;j<ySize+1;j++) {
			offG.drawLine( board_start_x -130, board_start_y + j*yboxSize, board_start_x +xSize*xboxSize,  board_start_y+j*yboxSize);
			if (j % 5 ==0)
				offG.drawLine( board_start_x -130, board_start_y + j*yboxSize-1, board_start_x +xSize*xboxSize,  board_start_y+j*yboxSize-1);
		}
		// 그냥 사각형 출력하지말고 라인으로만 해도 안되나?
		
		// 세로 line 출력
		for (int i=0; i<xSize+1; i++) {
			offG.drawLine( board_start_x +i*xboxSize,  board_start_y-130, board_start_x +i*xboxSize,  board_start_y + ySize*yboxSize);
			if (i % 5 ==0)
				offG.drawLine( board_start_x +i*xboxSize-1,  board_start_y-130, board_start_x +i*xboxSize-1,  board_start_y + ySize*yboxSize);
		}
		// 라인출력 끝
		
		g.drawImage(offScr, 0, 0, this);
	}
	
	
	public void createPausePanel() {

		pPause.setLayout(null);
		pPause.setSize(PauseBoxWidth,PauseBoxHeight);
		pPause.setLocation((dv.clientWidth-PauseBoxWidth)/2,(dv.clientHeight-PauseBoxHeight)/2);
		pPause.setBackground(Color.YELLOW);
		add(pPause);       //버튼이 먼저있어야 버튼이 제일위에옴
		pPause.setVisible(false);
		
	}
	
	public void makeButtonAndEventHandle() {

		btn_pause_back.setSize(PauseBoxWidth/2,PauseBoxHeight/5);
		btn_pause_back.setLocation((PauseBoxWidth-PauseBoxWidth/2)/2, PauseBoxHeight/5);
		pPause.add(btn_pause_back);
		
		btn_pause_main.setSize(PauseBoxWidth/2,PauseBoxHeight/5);
		btn_pause_main.setLocation((PauseBoxWidth-PauseBoxWidth/2)/2,PauseBoxHeight*3/5);
		pPause.add(btn_pause_main);
		

		btn_play_pause.setSize(dv.clientWidth/5,dv.clientHeight/10 );
		btn_play_pause.setLocation(dv.clientWidth/15,dv.clientHeight/10);
		add(btn_play_pause);
		
		
		
		btn_play_pause.addActionListener(this);
		btn_pause_back.addActionListener(this);
		btn_pause_main.addActionListener(this);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String strCmd = e.getActionCommand(); // 클릭된 버튼의 이름을 저장
		
		if (strCmd.equals("PAUSE")) {
			go_game_pause();
		}
		else if(strCmd.equals("BACK")) {
			go_game_play();
		}
		else if (strCmd.equals("MAIN")) {

			setVisible(false);
		}
	}
	
	
	
	public void go_game_pause() {
		btn_play_pause.setVisible(false);		
		pPause.setVisible(true);
	}
	
	
	public void go_game_play() {
		btn_play_pause.setVisible(true);		
		pPause.setVisible(false);
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		
		if (x >= board_start_x && x <= board_start_x +xSize*xboxSize) {
			if (y>= board_start_y && y <= board_start_y + ySize*yboxSize) {
				time.setText(x+" "+y);
				return;
			}
		}	}


	@Override
	public void mouseEntered(MouseEvent e) {	}


	@Override
	public void mouseExited(MouseEvent e) {	}


	@Override
	public void mousePressed(MouseEvent e) {	}


	@Override
	public void mouseReleased(MouseEvent e) {	}
	



	
}

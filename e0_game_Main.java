// #3 pause 구현 (미완) - 게임화면으로 돌아올 때 오류있음

package ex;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;




public class e0_game_Main extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	private int xSize = 20;  // x축길이
	private int ySize = 20;  // y축 길이
	private int board[][] = new int[xSize][ySize];
	
	private JButton btn_play_pause= new JButton("PAUSE");
	
	private JPanel pPause = new JPanel();
	private JButton btn_pause_back= new JButton("BACK");
	private JButton btn_pause_main=new JButton("MAIN");
	
	private boolean game_Pause = false;
	
	
	public e0_game_Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("네모네모 로직!");
		setSize(700,700);
		
		setLayout(null);
		makeButtonAndEventHandle();
		setVisible(true);
	}
	
	
	
	public void paint(Graphics g) {

		Container win = getContentPane();
		
		Dimension d = win.getSize();
		int clientWidth = d.width;
		int clientHeight = d.height;
		
		int xboxSize = (int)(clientWidth/1.7)/xSize;
		int yboxSize = (int)(clientHeight/1.7)/ySize;
		

		btn_play_pause.setSize(clientWidth/5,clientHeight/10 );
		btn_play_pause.setLocation(clientWidth/15,clientHeight/10);
		

		//게임중 일시정지 화면 START
		pPause.setLayout(null);
		int PauseBoxWidth = (int)(clientWidth/1.2);
		int PauseBoxHeight = (int)(clientHeight/1.1);
		pPause.setSize(PauseBoxWidth,PauseBoxHeight);
		pPause.setLocation((clientWidth-PauseBoxWidth)/2,(clientHeight-PauseBoxHeight)/2);
		pPause.setBackground(Color.YELLOW);
		

		btn_pause_back.setSize(PauseBoxWidth/2,PauseBoxHeight/5);
		btn_pause_back.setLocation((PauseBoxWidth-PauseBoxWidth/2)/2, PauseBoxHeight/5);
		pPause.add(btn_pause_back);
		
		btn_pause_main.setSize(PauseBoxWidth/2,PauseBoxHeight/5);
		btn_pause_main.setLocation((PauseBoxWidth-PauseBoxWidth/2)/2,PauseBoxHeight*3/5);
		pPause.add(btn_pause_main);
		
		add(pPause);       //버튼이 먼저있어야 버튼이 제일위에옴
		pPause.setVisible(false);
		// 게임중 일시정지화면 END
		
		for (int i=0; i<xSize; i++) {       //x축 길이
			for(int j=0; j<ySize; j++) {   //y축 길이
				g.setColor(Color.DARK_GRAY);
				if((i+1) % 5==0 && (j+1) % 5 == 0)                    // 5칸마다 찐하게
					g.draw3DRect( (clientWidth/3) +i*xboxSize, (int)(clientHeight/2.5)+j*yboxSize,xboxSize-1,yboxSize-1,false );
				else if ((i+1) % 5 == 0 && (j+1) % 5 != 0)
					g.draw3DRect( (clientWidth/3) +i*xboxSize, (int)(clientHeight/2.5)+j*yboxSize,xboxSize-1,yboxSize,false );
				else if ((i+1) % 5 != 0 && (j+1) % 5 == 0)
					g.draw3DRect( (clientWidth/3) +i*xboxSize, (int)(clientHeight/2.5)+j*yboxSize,xboxSize,yboxSize-1,false );
				else
					g.draw3DRect( (clientWidth/3) +i*xboxSize, (int)(clientHeight/2.5)+j*yboxSize,xboxSize,yboxSize,false );
				
			}
		}
		
		
	}
	
	
	
	public void update(Graphics g) {
		paint(g);
	}
	
	
	
	
	public void makeButtonAndEventHandle() {
		add(btn_play_pause);
		btn_play_pause.addActionListener(this);
		
		add(btn_pause_back);
		btn_pause_back.addActionListener(this);
		
		add(btn_pause_main);
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
	}
	
	
	
	public void go_game_pause() {
		btn_play_pause.setVisible(false);
//		btn_play_pause.setText("BACK");
		
		pPause.setVisible(true);
	}
	
	
	public void go_game_play() {

		repaint();
		btn_play_pause.setVisible(true);
		
		pPause.setVisible(false);
	}
	
	

	public static void main(String[] args) {
		e0_game_Main nemo = new e0_game_Main();
		
	}
}



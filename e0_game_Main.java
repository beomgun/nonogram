// #6 ���콺 ��� ������ ����

package ex;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;




public class e0_game_Main extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	private int xSize = 20;  // x�����
	private int ySize = 20;  // y�� ����
	private int board[][] = new int[xSize][ySize];
	
	private JButton btn_play_pause= new JButton("PAUSE");
	
	private JPanel pPause = new JPanel();
	private JButton btn_pause_back= new JButton("BACK");
	private JButton btn_pause_main=new JButton("MAIN");
	
	private boolean game_Pause = false;
	private int board_start_x,board_start_y;
	private int xboxSize, yboxSize;
	
	private JLabel lb = new JLabel("mouse Moved");
	
	
	Image offScr;
	Graphics offG;  
	
	
	
	public e0_game_Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("�׸�׸� ����!");
		setSize(700,700);
		
		setLayout(null);
		makeButtonAndEventHandle();

		add(lb);
		addMouseMotionListener(new MyMouseMotion());

		setVisible(true);
	}
	
	
	
	public void paint(Graphics g) {
		Container win = getContentPane();
		
		Dimension d = win.getSize();
		int clientWidth = d.width;
		int clientHeight = d.height;
		

		offScr = createImage(clientWidth, clientHeight);
		offG = offScr.getGraphics();
		
		
		
		xboxSize = (int)(clientWidth/1.7)/xSize;
		yboxSize = (int)(clientHeight/1.7)/ySize;
		

		btn_play_pause.setSize(clientWidth/5,clientHeight/10 );
		btn_play_pause.setLocation(clientWidth/15,clientHeight/10);
		

		

		//������ �Ͻ����� ȭ�� START
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
		
		add(pPause);       //��ư�� �����־�� ��ư�� ����������
		pPause.setVisible(false);
		// ������ �Ͻ�����ȭ�� END
		
		
		// �簢�� ������ �������� x��ǥ (start_x) : clientWidth/3
		// �簢�� ������ �������� y��ǥ (start_y) : (int)(clientHeight/2.5)
		int start_x = clientWidth/3;
		int start_y = (int)(clientHeight/2.5);
		board_start_x = start_x;
		board_start_y = start_y;
		
		// ���� ������ ���� line ���
		for(int j=0;j<ySize+1;j++) {
			offG.drawLine( start_x -130, start_y + j*yboxSize, start_x +xSize*xboxSize,  start_y+j*yboxSize);
			if (j % 5 ==0)
				offG.drawLine( start_x -130, start_y + j*yboxSize-1, start_x +xSize*xboxSize,  start_y+j*yboxSize-1);
		}
		// �׳� �簢�� ����������� �������θ� �ص� �ȵǳ�?
		
		// ���� line ���
		for (int i=0; i<xSize+1; i++) {
			offG.drawLine( start_x +i*xboxSize,  start_y-130, start_x +i*xboxSize,  start_y + ySize*yboxSize);
			if (i % 5 ==0)
				offG.drawLine( start_x +i*xboxSize-1,  start_y-130, start_x +i*xboxSize-1,  start_y + ySize*yboxSize);
		}
		// ������� ��
		
		g.drawImage(offScr, 0, 0, this);
		
		
	}
	
	
	
	public void update(Graphics g) {       // repaint() �������� ����.    �̰� ������ pauseȭ�鿡��back �Ҷ� pauseȭ�鵵 �״�� ���
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
		String strCmd = e.getActionCommand(); // Ŭ���� ��ư�� �̸��� ����
		
		if (strCmd.equals("PAUSE")) {
			go_game_pause();
		}
		else if(strCmd.equals("BACK")) {
			go_game_play();
		}
	}
	
	
	
	public void go_game_pause() {
		btn_play_pause.setVisible(false);		
		pPause.setVisible(true);
	}
	
	
	public void go_game_play() {

		repaint();
		btn_play_pause.setVisible(true);		
		pPause.setVisible(false);
	}
	
	
	
	
	
	
	
	class MyMouseMotion extends MouseMotionAdapter{
		
		public void mouseMoved(MouseEvent e) {
			lb.setOpaque(true);
			lb.setBackground(Color.yellow);
			lb.setText(e.getX()+ ", " + e.getY());
			
			Dimension d = lb.getPreferredSize();
			int width = (int)d.getWidth();
			int height = (int)d.getHeight();
			lb.setSize(width, height);
			lb.setLocation(e.getX() - width, e.getY() - height);
			
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public static void main(String[] args) {
		e0_game_Main nemo = new e0_game_Main();
		
	}




		
	
}



// #2 pause버튼 이벤트
package ex;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;


public class e0_game_Main extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	private int xSize = 20;  // x축길이
	private int ySize = 20;  // y축 길이
	private int board[][] = new int[xSize][ySize];
	
	private JButton btn_pause= new JButton("PAUSE");
	
	
	
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
		

		btn_pause.setSize(clientWidth/5,clientHeight/10 );
		btn_pause.setLocation(clientWidth/15,clientHeight/10);
		
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

	
	public void makeButtonAndEventHandle() {
		add(btn_pause);
		btn_pause.addActionListener(this);
		
	}

	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String strCmd = e.getActionCommand(); // 클릭된 버튼의 이름을 저장
		Container pane = getContentPane();
		
		if (strCmd.equals("PAUSE")) {
			btn_pause.setText("BACK");
		}
		if (strCmd.equals("BACK")) {
			btn_pause.setText("PAUSE");
			
		}
		
		
	}
	
	

	public static void main(String[] args) {
		e0_game_Main nemo = new e0_game_Main();
		
	}
}

// #0 Start ���ڱ���

package ex;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;




public class e0_game_Main extends JFrame {
	private static final long serialVersionUID = 1L;
	private int xSize = 20;  // x�����
	private int ySize = 20;  // y�� ����
	private int board[][] = new int[xSize][ySize];
	
	
	public e0_game_Main() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("�׸�׸� ����!");
		setSize(700,700);
		
		setLayout(null);
		setVisible(true);
	}
	
	
	public void paint(Graphics g) {

		
		Container win = getContentPane();
		
		Dimension d = win.getSize();
		
		int clientWidth = d.width;
		int clientHeight = d.height;
		
		int xboxSize = (int)(clientWidth/1.7)/xSize;
		int yboxSize = (int)(clientHeight/1.7)/ySize;
		
		
		for (int i=0; i<xSize; i++) {       //x�� ����
			for(int j=0; j<ySize; j++) {   //y�� ����
				g.setColor(Color.DARK_GRAY);
				if((i+1) % 5==0 && (j+1) % 5 == 0)                    // 5ĭ���� ���ϰ�
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

	

	public static void main(String[] args) {
		e0_game_Main nemo = new e0_game_Main();
		
	}
}



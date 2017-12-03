package game;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
 
public class panel_FadeIO extends JPanel {
	private static final long serialVersionUID = 1L;
	int alpha = 0;
	
	
	
	
	public panel_FadeIO() {
		fadeout();
		
		setBounds(0, 0, Manager.manager.clientWidth, Manager.manager.clientHeight);
		setLayout(null);	
		setVisible(true);
	}
	
	
	
	
	void fadeout() {
		new Timer(35, new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if (alpha<255) {
				alpha = alpha + 5;
				if (alpha > 255) {
					alpha = 255;
				}
			}
			setBackground(new Color(0, 0, 0, alpha));
		}
	}).start();
		
	}
	
	
}
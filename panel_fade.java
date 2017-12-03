//package game;
//import java.awt.Color;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import javax.swing.*;
// 
//public class panel_fade {
// 
//	private int alpha = 255;
//	private int increment = 5;
//	private JLabel label = new JLabel("Fading Label");
//	private JPanel panel = new JPanel();
//	
//	
//	public panel_fade() {
//		
//		JFrame frame = new JFrame();
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.add(label);
//		frame.pack();
//		frame.setLocationRelativeTo(null);
//		frame.setVisible(true);
//		
//		
//		new Timer(80, new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				if (Manager.manager.fadeIn==true) {
//					
//					alpha += increment;
//					if (alpha >= 255) {
//						alpha = 255;
//	//					increment = -increment;
//					}
//				}
////				if (alpha <= 0) {
////					alpha = 0;
////					increment = -increment;
////				}
//				label.setForeground(new Color(0, 0, 0, alpha));
//			}
//		}).start();
//		
// 
//	}
//	
//	
//	
//	public static void main(String[] args) {
//		SwingUtilities.invokeLater(new Runnable() {
//			public void run() {
//				new panel_fade();
//			}
//		});
//	}
//	
//	
//	
//	
//}
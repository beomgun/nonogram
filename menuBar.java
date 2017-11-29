package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import ex.menuItem.MenuHandler;

public class menuBar extends JMenuBar {
	JMenu m1;
	
	
	public menuBar() {
		// �޴��� ���� (���̵�) //////////////////////////////
				m1 = new JMenu("Normal Mode"); 
				JMenuItem m1_mi1 = new JMenuItem("Easy"); 
				JMenuItem m1_mi2 = new JMenuItem("Normal"); 
				JMenuItem m1_mi3 = new JMenuItem("Hard"); 
				m1.add(m1_mi1); 
				m1.add(m1_mi2); 
				m1.add(m1_mi3); 
				// ���θ޴��� �޴��ٿ� �߰� 
				add(m1); 
				// �޴��ٸ� �����ӿ� �޴��ٷ� ���� 
				MenuHandler m = new MenuHandler(); 
				//MenuHandler�� �̸� ���� ���� 
				m1_mi1.addActionListener(m); 
				m1_mi2.addActionListener(m); 
				m1_mi3.addActionListener(m); 
		// ========================================================
	}
	
	
	//���̵����� �޴��� - Start ======================================================
	  public class MenuHandler implements ActionListener { 
	       @Override 
	       public void actionPerformed(ActionEvent e) { 
	          System.out.println(e.getActionCommand() + "�� ����"); 
	          
	          String str = e.getActionCommand(); 
	          if (str.equals("Easy")) {
	        	  Manager.manager.changeLevel(1);
	        	  m1.setText("Easy Mode");
	
	          } 
	          else if (str.equals("Normal")) {
	        	  Manager.manager.changeLevel(2);
	        	  m1.setText("Normal Mode");
	          } 
	          else if (str.equals("Hard")) {
	        	  Manager.manager.changeLevel(3);
	        	  m1.setText("Hard Mode");
	          } 
	       } 
	    } 
///���̵����� �޴��� - End =============================================================

}


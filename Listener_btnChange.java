package game;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class Listener_btnChange implements MouseListener {


	@Override
	public void mouseEntered(MouseEvent e) {
		JButton btn = (JButton) e.getSource();
		
		//����ȭ�� ��ư===================================
		if(btn.getActionCommand()=="���� ����")
			btn.setIcon(new ImageIcon("���ӽ���1.png"));
		else if(btn.getActionCommand()=="��ŷ ����")
			btn.setIcon(new ImageIcon("��ŷ����1.png"));
		else if(btn.getActionCommand()=="����")
			btn.setIcon(new ImageIcon("��������1.png"));
		// ����ȭ���ư===================================

		// ����ȭ���ư===================================

		else if(btn.getActionCommand()=="PAUSE")
			btn.setIcon(new ImageIcon("pause1.png"));
		else if(btn.getActionCommand()=="BACK")
			btn.setIcon(new ImageIcon("����� �ڷ�1.png"));
		else if(btn.getActionCommand()=="MAIN")
			btn.setIcon(new ImageIcon("����� ����1.png"));
		

		// ����ȭ���ư===================================
		
		
		// ��ŷȭ���ư===================================

		else if(btn.getActionCommand()=="Rank_BACK")
			btn.setIcon(new ImageIcon("rankBack.png"));
		

		// ��ŷȭ���ư===================================
	}

	
	@Override
	public void mouseExited(MouseEvent e) {
		JButton btn = (JButton) e.getSource();

		//����ȭ�� ��ư===================================
		if(btn.getActionCommand()=="���� ����")
			btn.setIcon(new ImageIcon("���ӽ���.png"));
		else if(btn.getActionCommand()=="��ŷ ����")
			btn.setIcon(new ImageIcon("��ŷ����.png"));
		else if(btn.getActionCommand()=="����")
			btn.setIcon(new ImageIcon("��������.png"));
		// ����ȭ���ư===================================

		// ����ȭ���ư===================================
		
		else if(btn.getActionCommand()=="PAUSE")
			btn.setIcon(new ImageIcon("pause.png"));
		else if(btn.getActionCommand()=="BACK")
			btn.setIcon(new ImageIcon("����� �ڷ�.png"));
		else if(btn.getActionCommand()=="MAIN")
			btn.setIcon(new ImageIcon("����� ����.png"));

		
		
		// ����ȭ���ư===================================

		
		// ��ŷȭ���ư===================================

		else if(btn.getActionCommand()=="Rank_BACK")
			btn.setIcon(new ImageIcon("rankBack.png"));
		
		
		// ��ŷȭ���ư===================================
	}

	
	
	
	@Override
	public void mouseClicked(MouseEvent e) {}
	
	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

}

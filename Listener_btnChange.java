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
			btn.setIcon(new ImageIcon("image/���ӽ���1.png"));
		else if(btn.getActionCommand()=="��ŷ ����")
			btn.setIcon(new ImageIcon("image/��ŷ����1.png"));
		else if(btn.getActionCommand()=="����")
			btn.setIcon(new ImageIcon("image/��������1.png"));
		// ����ȭ���ư===================================

		// ����ȭ���ư===================================

		else if(btn.getActionCommand()=="PAUSE")
			btn.setIcon(new ImageIcon("image/pause1.png"));
		else if(btn.getActionCommand()=="BACK")
			btn.setIcon(new ImageIcon("image/����� �ڷ�1.png"));
		else if(btn.getActionCommand()=="MAIN")
			btn.setIcon(new ImageIcon("image/����� ����1.png"));
		

		else if(btn.getActionCommand()=="����ϱ�")
			btn.setIcon(new ImageIcon("image/���1.png"));
		else if(btn.getActionCommand()=="���ӳ��������̵�")
			btn.setIcon(new ImageIcon("image/������ ����1.png"));
		else if(btn.getActionCommand()=="���ӳ�����ŷ�̵�")
			btn.setIcon(new ImageIcon("image/��ŷ����_����ȭ��1.png"));
		// ����ȭ���ư===================================
		
		
		// ��ŷȭ���ư===================================

		else if(btn.getActionCommand()=="Rank_BACK")
			btn.setIcon(new ImageIcon("image/rankBack1.png"));
		

		// ��ŷȭ���ư===================================
	}

	
	@Override
	public void mouseExited(MouseEvent e) {
		JButton btn = (JButton) e.getSource();

		//����ȭ�� ��ư===================================
		if(btn.getActionCommand()=="���� ����")
			btn.setIcon(new ImageIcon("image/���ӽ���.png"));
		else if(btn.getActionCommand()=="��ŷ ����")
			btn.setIcon(new ImageIcon("image/��ŷ����.png"));
		else if(btn.getActionCommand()=="����")
			btn.setIcon(new ImageIcon("image/��������.png"));
		// ����ȭ���ư===================================

		// ����ȭ���ư===================================
		
		else if(btn.getActionCommand()=="PAUSE")
			btn.setIcon(new ImageIcon("image/pause.png"));
		else if(btn.getActionCommand()=="BACK")
			btn.setIcon(new ImageIcon("image/����� �ڷ�.png"));
		else if(btn.getActionCommand()=="MAIN")
			btn.setIcon(new ImageIcon("image/����� ����.png"));


		else if(btn.getActionCommand()=="����ϱ�")
			btn.setIcon(new ImageIcon("image/���.png"));
		else if(btn.getActionCommand()=="���ӳ��������̵�")
			btn.setIcon(new ImageIcon("image/������ ����.png"));
		else if(btn.getActionCommand()=="���ӳ�����ŷ�̵�")
			btn.setIcon(new ImageIcon("image/��ŷ����_����ȭ��.png"));
		
		// ����ȭ���ư===================================

		
		// ��ŷȭ���ư===================================

		else if(btn.getActionCommand()=="Rank_BACK")
			btn.setIcon(new ImageIcon("image/rankBack.png"));
		
		
		// ��ŷȭ���ư===================================
	}

	
	
	
	@Override
	public void mouseClicked(MouseEvent e) {}
	
	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

}
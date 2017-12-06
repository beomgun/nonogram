package game;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class Listener_btnChange implements MouseListener {


	@Override
	public void mouseEntered(MouseEvent e) {
		JButton btn = (JButton) e.getSource();
		
		//메인화면 버튼===================================
		if(btn.getActionCommand()=="게임 시작")
			btn.setIcon(new ImageIcon("게임시작1.png"));
		else if(btn.getActionCommand()=="랭킹 보기")
			btn.setIcon(new ImageIcon("랭킹보기1.png"));
		else if(btn.getActionCommand()=="종료")
			btn.setIcon(new ImageIcon("게임종료1.png"));
		// 메인화면버튼===================================

		// 게임화면버튼===================================

		else if(btn.getActionCommand()=="PAUSE")
			btn.setIcon(new ImageIcon("pause1.png"));
		else if(btn.getActionCommand()=="BACK")
			btn.setIcon(new ImageIcon("퍼즈에서 뒤로1.png"));
		else if(btn.getActionCommand()=="MAIN")
			btn.setIcon(new ImageIcon("퍼즈에서 메인1.png"));
		

		// 게임화면버튼===================================
		
		
		// 랭킹화면버튼===================================

		else if(btn.getActionCommand()=="Rank_BACK")
			btn.setIcon(new ImageIcon("rankBack.png"));
		

		// 랭킹화면버튼===================================
	}

	
	@Override
	public void mouseExited(MouseEvent e) {
		JButton btn = (JButton) e.getSource();

		//메인화면 버튼===================================
		if(btn.getActionCommand()=="게임 시작")
			btn.setIcon(new ImageIcon("게임시작.png"));
		else if(btn.getActionCommand()=="랭킹 보기")
			btn.setIcon(new ImageIcon("랭킹보기.png"));
		else if(btn.getActionCommand()=="종료")
			btn.setIcon(new ImageIcon("게임종료.png"));
		// 메인화면버튼===================================

		// 게임화면버튼===================================
		
		else if(btn.getActionCommand()=="PAUSE")
			btn.setIcon(new ImageIcon("pause.png"));
		else if(btn.getActionCommand()=="BACK")
			btn.setIcon(new ImageIcon("퍼즈에서 뒤로.png"));
		else if(btn.getActionCommand()=="MAIN")
			btn.setIcon(new ImageIcon("퍼즈에서 메인.png"));

		
		
		// 게임화면버튼===================================

		
		// 랭킹화면버튼===================================

		else if(btn.getActionCommand()=="Rank_BACK")
			btn.setIcon(new ImageIcon("rankBack.png"));
		
		
		// 랭킹화면버튼===================================
	}

	
	
	
	@Override
	public void mouseClicked(MouseEvent e) {}
	
	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

}

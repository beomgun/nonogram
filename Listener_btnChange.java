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
			btn.setIcon(new ImageIcon("image/게임시작1.png"));
		else if(btn.getActionCommand()=="랭킹 보기")
			btn.setIcon(new ImageIcon("image/랭킹보기1.png"));
		else if(btn.getActionCommand()=="종료")
			btn.setIcon(new ImageIcon("image/게임종료1.png"));
		// 메인화면버튼===================================

		// 게임화면버튼===================================

		else if(btn.getActionCommand()=="PAUSE")
			btn.setIcon(new ImageIcon("image/pause1.png"));
		else if(btn.getActionCommand()=="BACK")
			btn.setIcon(new ImageIcon("image/퍼즈에서 뒤로1.png"));
		else if(btn.getActionCommand()=="MAIN")
			btn.setIcon(new ImageIcon("image/퍼즈에서 메인1.png"));
		

		else if(btn.getActionCommand()=="등록하기")
			btn.setIcon(new ImageIcon("image/등록1.png"));
		else if(btn.getActionCommand()=="게임끝나메인이동")
			btn.setIcon(new ImageIcon("image/끝날때 메인1.png"));
		else if(btn.getActionCommand()=="게임끝나랭킹이동")
			btn.setIcon(new ImageIcon("image/랭킹보기_끝남화면1.png"));
		// 게임화면버튼===================================
		
		
		// 랭킹화면버튼===================================

		else if(btn.getActionCommand()=="Rank_BACK")
			btn.setIcon(new ImageIcon("image/rankBack1.png"));
		

		// 랭킹화면버튼===================================
	}

	
	@Override
	public void mouseExited(MouseEvent e) {
		JButton btn = (JButton) e.getSource();

		//메인화면 버튼===================================
		if(btn.getActionCommand()=="게임 시작")
			btn.setIcon(new ImageIcon("image/게임시작.png"));
		else if(btn.getActionCommand()=="랭킹 보기")
			btn.setIcon(new ImageIcon("image/랭킹보기.png"));
		else if(btn.getActionCommand()=="종료")
			btn.setIcon(new ImageIcon("image/게임종료.png"));
		// 메인화면버튼===================================

		// 게임화면버튼===================================
		
		else if(btn.getActionCommand()=="PAUSE")
			btn.setIcon(new ImageIcon("image/pause.png"));
		else if(btn.getActionCommand()=="BACK")
			btn.setIcon(new ImageIcon("image/퍼즈에서 뒤로.png"));
		else if(btn.getActionCommand()=="MAIN")
			btn.setIcon(new ImageIcon("image/퍼즈에서 메인.png"));


		else if(btn.getActionCommand()=="등록하기")
			btn.setIcon(new ImageIcon("image/등록.png"));
		else if(btn.getActionCommand()=="게임끝나메인이동")
			btn.setIcon(new ImageIcon("image/끝날때 메인.png"));
		else if(btn.getActionCommand()=="게임끝나랭킹이동")
			btn.setIcon(new ImageIcon("image/랭킹보기_끝남화면.png"));
		
		// 게임화면버튼===================================

		
		// 랭킹화면버튼===================================

		else if(btn.getActionCommand()=="Rank_BACK")
			btn.setIcon(new ImageIcon("image/rankBack.png"));
		
		
		// 랭킹화면버튼===================================
	}

	
	
	
	@Override
	public void mouseClicked(MouseEvent e) {}
	
	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

}
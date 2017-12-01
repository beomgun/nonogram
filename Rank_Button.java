import java.awt.Dimension;

import javax.swing.*;

//class rank_table{
//	JFrame Rank_Frame = new JFrame();
//	String columnNames[] = {"순위","이름","시간","난이도"};
//	String rowData[][] = {
//			{"1", "A","15:00","Hard"},
//			{"2", "B","14:00","Normal"},
//			{"3", "C","13:00","Easy"}
//	};
//	JTable Rank_table = new JTable(rowData,columnNames);
//	JScrollPane jscrollpane = new JScrollPane(Rank_table);
//	
//	public rank_table() {
//		Rank_Frame.add(jscrollpane);
//		
//		Rank_Frame.setSize(600,300);
//		Rank_Frame.setVisible(true);
//		Rank_Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		
//	}
//	
//}
public class Rank_Button extends JFrame{
	private static final long serialVersionUID = 1L;
	private JButton rToMain;
	
	public Rank_Button(String title) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(700,700);
		setTitle(title);
		JPanel panel = new JPanel();
		panel.setLayout(null);
		rToMain = new JButton("메인으로");
		
		Dimension d = rToMain.getPreferredSize();
		rToMain.setSize(140,70);
		rToMain.setLocation(700/17,(int)(700/8));
		
		JFrame Rank_Frame = new JFrame();
		
		String columnNames[] = {"순위","이름","시간","난이도"};
		String rowData[][] = {
				{"1", "A","15:00","Hard"},
				{"2", "B","14:00","Normal"},
				{"3", "C","13:00","Easy"}
		};
		
		JTable Rank_table = new JTable(rowData,columnNames);
		JScrollPane jscrollpane = new JScrollPane(Rank_table);
		Rank_Frame.add(jscrollpane);
		
		Rank_Frame.setSize(600,300);
		Rank_Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Rank_table.setSize(600,300);
		Rank_table.setLocation(700/17,200);
		setLayout(null);
		add(rToMain);
		add(Rank_table);
		setVisible(true);
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Rank_Button rB = new Rank_Button("Ranking");
		
	}

}

package game;

import java.io.*;

public class Manager_ranking {

	String rank_name[][] = new String[3][3];     //��ŷ�����   [���̵�][����]
	int rank_time[][] = new int[3][3];            // ��*60 + �� = time     
	
	String line;
	String fname = "src/game/rankingSave.java";
	
	public Manager_ranking()  {
		for(int i=0; i<3; i++) {   // ���̵�
			for(int j=0; j<3; j++) {  //���
				rank_time[i][j] = 99999999;
				if(rank_time[i][j] == 99999999) {
					rank_name[i][j] = "-";
				}
			}
		}
		
		// �������� ������.
		try {
			FileInputStream fis = new FileInputStream(fname);
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader br= new BufferedReader(isr);
			
			for(int i=0; i<3; i++) {
				for (int j=0; j<3; j++) {
					if((line = br.readLine()) != null) {
						
						rank_time[i][j] = Integer.parseInt(line);
						line = br.readLine();
						if(rank_time[i][j] != 99999999)
							rank_name[i][j] = line;
					}
				}
			}
		
			
			
			
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
			br.close();
			isr.close();
			fis.close();
		
		} 	catch (FileNotFoundException e) {} 
			catch(IOException e) {}
		
		
		
		
	}
	
	
	
	
	// �ش����� ������� üũ�ؼ� ������� �̸��� �޾Ƽ� �ð��ϰ� ������Ʈ��.
	
	
	int rank_check(int level, int time) {  // �ش� �ð��� ����ȿ� ������� üũ��.  ������ 1,2,3 �̱⶧���� -1����
		for(int i=0; i<3; i++) {
			if(time<rank_time[level-1][i]) {          // 1���ϰ�� 0, 2���� 1, 3���� 2 ������
				return i;
			}
		}
		return 4;                            // ������ ������� 4 ����
	}
	
	
	
	void rank_update(int level, int rank, String name, int time) {  // ���̵�, ��ũ, ������ �̸�, �ð� �޾Ƽ� ��ŷ�� ����
		if(rank==0) {     // 1���ϰ�� �ؿ� �ٹо�� 1������
			rank_time[level-1][2]=rank_time[level-1][1];     // 2���� 3������ �ű��
			rank_name[level-1][2]=rank_name[level-1][1];
			
			rank_time[level-1][1]=rank_time[level-1][0];    // 1���� 2������ �ű�
			rank_name[level-1][1]=rank_name[level-1][0];
			
			rank_time[level-1][0]=time;           // 1���ڸ��� ��� �������
			rank_name[level-1][0]=name;
		}
		
		else if(rank==1) { // 2���ΰ��
			rank_time[level-1][2]=rank_time[level-1][1];     // 2���� 3������ �ű��
			rank_name[level-1][2]=rank_name[level-1][1];
			
			rank_time[level-1][1]=time;             // 2���ڸ��� ��� �������
			rank_name[level-1][1]=name;
		}
		
		else if(rank==2) {  // 3���ΰ��
			rank_time[level-1][2]=time;             // 3���ڸ��� ��� �������
			rank_name[level-1][2]=name;
		}
		
		else {             // �����ǿ� ���°�� �ƹ��͵� ���� ��
		}
	}
	
	
}
package game;

public class Manager_ranking {

	String rank_name[][] = new String[3][3];     //랭킹담는통   [난이도][순위]
	int rank_time[][] = new int[3][3];            // 분*60 + 초 = time     
	
	
	public Manager_ranking() {
		rank_time[1][0] = 1;
		rank_time[1][1] = 1;
		rank_time[1][2] = 3;
	}
	
	
	
	
	// 해당등수에 들었는지 체크해서 들었으면 이름을 받아서 시간하고 업데이트함.
	
	
	int rank_check(int level, int time) {  // 해당 시간이 등수안에 들었는지 체크함.  레벨이 1,2,3 이기때문에 -1해줌
		for(int i=0; i<3; i++) {
			if(time<rank_time[level-1][i]) {          // 1등일경우 0, 2등은 1, 3등은 2 리턴함
				return i;
			}
		}
		return 4;                            // 순위에 못들어갈경우 4 리턴
	}
	
	
	
	void rank_update(int level, int rank, String name, int time) {  // 난이도, 랭크, 저장할 이름, 시간 받아서 랭킹에 저장
		if(rank==0) {     // 1등일경우 밑에 다밀어내고 1등차지
			rank_time[level-1][2]=rank_time[level-1][1];     // 2등을 3등으로 옮기고
			rank_name[level-1][2]=rank_name[level-1][1];
			
			rank_time[level-1][1]=rank_time[level-1][0];    // 1등을 2등으로 옮김
			rank_name[level-1][1]=rank_name[level-1][0];
			
			rank_time[level-1][0]=time;           // 1등자리에 기록 집어넣음
			rank_name[level-1][0]=name;
		}
		
		else if(rank==1) { // 2등인경우
			rank_time[level-1][2]=rank_time[level-1][1];     // 2등을 3등으로 옮기고
			rank_name[level-1][2]=rank_name[level-1][1];
			
			rank_time[level-1][1]=time;             // 2등자리에 기록 집어넣음
			rank_name[level-1][1]=name;
		}
		
		else if(rank==2) {  // 3등인경우
			rank_time[level-1][2]=time;             // 3등자리에 기록 집어넣음
			rank_name[level-1][2]=name;
		}
		
		else {             // 순위권에 없는경우 아무것도 안함 ㅎ
		}
	}
	
	
}
# 네모네모 로직
 + Manager.java 실행시 게임시작.
 * 자세한 내용은 wiki에! https://github.com/beomgun/nonogram/wiki
 ***
## 기능
* 난이도 설정 기능
 > * Menubar로 난이도 설정가능 (랭킹, 게임 이용 시)
 > * 난이도에 따른 보드 랜덤 선택 기능
* 게임 이용
 > * 게임보드에 커서 올리면 반투명한 박스로 커서위치를 쉽게 알 수 있게 해줌.
 > * 게임보드에서 마우스 오른쪽 클릭시 바로 X 생성되게 함
 > * 게임보드에서 드래그시 연속칸 색칠가능.
 > * 경과시간 구현으로 랭킹이용가능
 > * 해당 난이도 최고기록 보여줌.
 > * 게임 중 일시정지 기능 (일시정지시 타이머도 멈춤)
* 랭킹 등록
 > * 난이도 별로 3등 이내 진입시 랭킹 등록 가능.
 > * 랭킹 등록시 글자수 5개 제한.
 > * 랭킹 등록시 랭킹이 rankingSace.java로 저장되어 종료후 실행시에도 랭킹유지 가능
* UI
 > * 사용자 편의에 맞춘 UI구성
 > * 버튼에 마우스 올릴경우 버튼이미지를 바꿈으로써 버튼인식가능
***
## 구성
* Manager
 > * Manager.java  (Main)    - default setting
 > * Manager_gameBoard.java  - gameboard random setting
 > * Manager_ranking         - ranking update
* JFrame 
 > * Frame.java
* JPanel  
 > * panel_Main.java
 > * panel_Game.java
 > * panel_Rank.java
* JMenubar 
 > * menuBar.java
* MouseListener
 > * Listener_btnChange.java  - 버튼위에 마우스 올릴경우 이미지 바꿔줌.

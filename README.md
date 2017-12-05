# nonogram
  + Manager.java 최초실행.
## 구성
* Manager
   > * Manager.java            - default setting
   > * Manager_gameBoard.java  - gameboard setting
* JFrame 
   > * Frame.java
* JPanel  
   > * panel_Main.java
   > * panel_Game.java
   > * panel_Rank.java
* JMenubar 
   > * menuBar.java
## 요약   
* Manager.java 실행시 default 세팅후 Frame.java 실행
* Frame.java에 Panel들과, Menubar를 add , 최초 panel_Main 보여줌
* 게임이동시 이전게임 초기화를 위해 이동할때마다 panel_game을 재생성후 다시 add시킴
## 기능
* Menubar로 난이도 설정가능 (랭킹, 게임 이용 시)
* 게임보드에 커서 올리면 반투명한 박스로 커서위치를 쉽게 알 수 있게 해줌.
* 게임보드에서 마우스 오른쪽 클릭시 바로 X 생성되게 함
* 난이도에 따른 보드 랜덤 선택 기능

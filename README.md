# nonogram
 + Manager.java 실행시 게임시작.
 
## 기능
* 난이도 설정 기능
 > * Menubar로 난이도 설정가능 (랭킹, 게임 이용 시)
 > * 난이도에 따른 보드 랜덤 선택 기능
* 게임 이용
 > * 게임보드에 커서 올리면 반투명한 박스로 커서위치를 쉽게 알 수 있게 해줌.
 > * 게임보드에서 마우스 오른쪽 클릭시 바로 X 생성되게 함
 > * 게임 중 일시정지 기능 (일시정지시 타이머도 멈춤)
 > * 랭킹 구현 (랭킹에서 menubar로 보고싶은 난이도의 랭킹 확인가능)
## 구성
* Manager
    > * Manager.java            - default setting
    > * Manager_gameBoard.java  - gameboard random setting
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
## 요약   
* Manager.java 실행시 default 세팅후 Frame.java 실행
* Frame.java에 Panel들과, Menubar를 add , 최초 panel_Main 보여줌
* 게임으로 이동시 이전게임 초기화를 위해 이동할때마다 기존 panel_game을 remove하고 재생성후 다시 add시킴

### 해야할 것
* 랭킹패널에 기록 뜨게 만들기
* 버튼이미지 안넣은것들 

package ma.homwork;

import java.awt.*;
import java.util.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.*;


class CalendarDataManager1{
	Calendar today = Calendar.getInstance();
	Calendar cal;
	
	static final int CAL_WIDTH = 7;
	final static int CAL_HEIGHT = 6;
    private int startDay;   // 월 시작 요일
    private int inputDate=1;  //입력 날짜
    int calDates[][] = new int[6][7];
    int calYear;
	int calMonth;
	int calDayOfMon;
	
	final int calLastDateOfMonth[]={31,28,31,30,31,30,31,31,30,31,30,31};
	int calLastDate;
	
    public void setToday() {
    	calYear = today.get(Calendar.YEAR); 
		calMonth = today.get(Calendar.MONTH);
		calDayOfMon = today.get(Calendar.DAY_OF_MONTH);
		makeCalData(today);
    }
    private void makeCalData(Calendar cal){
		// 1일의 위치와 마지막 날짜를 구함 
		int calStartingPos = (cal.get(Calendar.DAY_OF_WEEK)+7-(cal.get(Calendar.DAY_OF_MONTH))%7)%7;
		if(calMonth == 1) calLastDate = calLastDateOfMonth[calMonth] + leapCheck(calYear);//매년 윤년확인
		else calLastDate = calLastDateOfMonth[calMonth];
		
		for(int i = 0 ; i<CAL_HEIGHT ; i++){
			for(int j = 0 ; j<CAL_WIDTH ; j++){
				calDates[i][j] = 0;
			}
		}
		
		for(int i = 0, num = 1, k = 0 ; i<CAL_HEIGHT ; i++){
			if(i == 0) k = calStartingPos;
			else k = 0;
			for(int j = k ; j<CAL_WIDTH ; j++){
				if(num <= calLastDate) calDates[i][j]=num++;
			}
		}// 달력 배열에 값 채워넣기
	}
    private int leapCheck(int year){ // 윤년인지 확인하는 함수
		if(year%4 == 0 && year%100 != 0 || year%400 == 0) return 1;
		else return 0;
	}
    public void moveMonth(int mon){ // 현재달로 부터 n달 전후를 받아 달력 배열을 만드는 함수(1년은 +12, -12달로 이동 가능)
		calMonth += mon;
		if(calMonth>11) while(calMonth>11){
			calYear++;
			calMonth -= 12;
		} else if (calMonth<0) while(calMonth<0){
			calYear--;
			calMonth += 12;
		}
		cal = new GregorianCalendar(calYear,calMonth,calDayOfMon);
		makeCalData(cal);
	}

}


public class Team4 extends CalendarDataManager1 {
	

	JFrame mainFrame;//jframe 메인
	String name="월1";
	
	JPanel topJP;
	JButton todayJB;
	JLabel todayJL;
	JLabel calyyyymm;
	
	JPanel calJP;
	JButton[] weekDaysName;
	final static String WEEK_DAY_NAME[] = { "SUN", "MON", "TUE", "WED", "THR", "FRI", "SAT" };
	JTextArea[][] dateJTA = new JTextArea[6][7];
	JScrollPane dateJSP;

	
	JTextArea memoJTA;
	JScrollPane memoJSP;
	JTextField choseJTF;
	JButton endJB;
	JButton deleteJB;
	JButton clearJB;
	JButton returnJB;
	String returnclear;
	JLabel infoJL;
	
	JButton ExamJB;
	JButton MemoJB;
	JButton pYearJB;
	JButton pMonthJB;

	
	JLabel infoClock;
	JLabel selectedDate;
	



	///////////////////////////////////////////////////////////
	public Team4() {
	mainFrame=new JFrame("캘린더");
	mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	mainFrame.setSize(1500,1000);
	mainFrame.setLocationRelativeTo(null);//프레임 중앙에 띄우기
	mainFrame.setResizable(false);//창크기변경불가
	GridBagLayout gbl = new GridBagLayout();
	GridBagConstraints gbc = new GridBagConstraints();
	mainFrame.setLayout(gbl);
	
	
	topJP=new JPanel();
	topJP.setLayout(gbl);
	todayJB=new JButton("오늘");
	todayJL = new JLabel(today.get(Calendar.YEAR)+"/"+(today.get(Calendar.MONTH)+1)+"/"+today.get(Calendar.DAY_OF_MONTH));
	gbc.gridx=0;
	gbc.gridy=0;
	gbc.gridwidth=3;
	gbc.gridheight=1;
	gbc.weightx=0;
	gbc.weighty=0;
	gbc.ipadx=100;
	gbc.anchor = GridBagConstraints.NORTH;
	gbc.fill = GridBagConstraints.BOTH;
	topJP.add(todayJB,gbc);
	
	gbc.gridx=6;
	gbc.gridy=0;
	gbc.gridwidth=3;
	gbc.gridheight=1;
	topJP.add(todayJL,gbc);
	

	calyyyymm= new JLabel(calYear+"/"+calMonth);
	gbc.gridx=3;
	gbc.gridy=1;
	gbc.gridwidth=3;
	gbc.gridheight=2;
	gbc.ipady=30;
	topJP.add(calyyyymm,gbc);
	gbc.ipady=0;
	
	
	calJP=new JPanel();
	weekDaysName = new JButton[7];
	for(int i=0 ; i<CAL_WIDTH ; i++){
		weekDaysName[i]=new JButton(WEEK_DAY_NAME[i]);
		weekDaysName[i].setBorderPainted(false);//버튼 테두리설정
		weekDaysName[i].setContentAreaFilled(false);//버튼 영역표시설정
		weekDaysName[i].setForeground(Color.WHITE);//버튼의 색상을 지정
		if(i == 0) weekDaysName[i].setBackground (Color.red);//일요일이라면?빨강
		else if (i == 6) weekDaysName[i].setBackground(Color.blue);//토요일은 파랑
		else weekDaysName[i].setBackground(Color.gray);//나머진 회색
		weekDaysName[i].setOpaque(true);//색을 더잘나오게함
		weekDaysName[i].setFocusPainted(false);//같은 기능
		calJP.add(weekDaysName[i]);//
	}//일요일부터 토요일까지 라벨생성
	for(int i=0;i<CAL_HEIGHT;i++) {
	for(int j=0 ; j<CAL_WIDTH ; j++){
		dateJTA[i][j]=new JTextArea();
		dateJTA[i][j].setBackground(Color.WHITE);//흰색배경
		dateJTA[i][j].setOpaque(true);
		dateJTA[i][j].setLineWrap(true);//줄바꿈허락
		dateJTA[i][j].setWrapStyleWord(true);//줄바꿈을 단어의 단위로 허락
		dateJSP = new JScrollPane(dateJTA[i][j], JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);//수직스크롤바 항상보이게,수평스크롤바는 안보이게
		calJP.add(dateJSP);
	}
}//날짜배치완료
	calJP.setLayout(new GridLayout(0,7,2,2));
	calJP.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
	
	gbc.gridx=0;
	gbc.gridy=3;
	gbc.gridwidth=9;
	gbc.gridheight=3;
	gbc.weightx=1.0;
	gbc.weighty=1.0;
	gbc.ipadx=500;
	gbc.ipady=500;
	topJP.add(calJP,gbc);
	gbc.ipadx=1;
	gbc.ipady=1;
	
	choseJTF=new JTextField();
	endJB=new JButton("save");
	endJB.addActionListener(new EventHandler());
	deleteJB=new JButton("delete");
	clearJB=new JButton("clear");
	infoJL=new JLabel("hello");
	
	gbc.gridx=0;
	gbc.gridy=10;
	gbc.gridwidth=1;
	gbc.gridheight=1;
	gbc.ipadx=1;
	gbc.ipady=1;
	topJP.add(choseJTF,gbc);
	gbc.gridx=1;
	gbc.gridy=10;
	gbc.gridwidth=1;
	gbc.gridheight=1;
	gbc.ipady=2;
	topJP.add(endJB,gbc);
	gbc.gridx=3;
	topJP.add(deleteJB,gbc);
	gbc.gridx=4;
	topJP.add(clearJB,gbc);	
	gbc.gridx=0;
	gbc.gridy=11;
	topJP.add(infoJL,gbc);

	
    ExamJB=new JButton("Exam");
    ExamJB.addActionListener(new EventHandler());
    MemoJB=new JButton("Memo");
    MemoJB.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			new Memo("Memo");
			
		}
	});
	pYearJB=new JButton(">>>");
	pMonthJB=new JButton(">>");
	
	gbc.gridx=0;
	gbc.gridy=1;
	gbc.weightx=1;
	gbc.weighty=1;
	topJP.add(ExamJB,gbc);
    gbc.gridx=1;
	topJP.add(MemoJB,gbc);
	gbc.gridx=6;
	topJP.add(pMonthJB,gbc);
	gbc.gridx=7;
	topJP.add(pYearJB,gbc);
	
	
	mainFrame.add(topJP);
	
	
	mainFrame.setVisible(true);
	
	
}

	public class EventHandler implements ActionListener {
	    public void actionPerformed(ActionEvent e) {//액션이벤트가 발생됬을떄 수행하는 동작
			 if(e.getSource() == endJB) {
				if(choseJTF.getText().equals("월1")) {
				dateJTA[1][1].setText(String.valueOf(memoJTA.getText()));
					System.out.println("실행됨");
				}
			}
	    }
	}
	
	
	public static void main(String[] args) {
		new Team4();
	}
}

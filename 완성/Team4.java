package ma.homwork;

import java.awt.*;
import java.util.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.swing.*;


class CalendarDataManager1{
	Calendar today = Calendar.getInstance();
	Calendar ddday = Calendar.getInstance();
	
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
	
	JPanel topJP;
	JButton todayJB;
	JLabel todayJL;
	JLabel calyyyymm;
	
	JPanel calJP;
	JButton[] weekDaysName;
	final static String WEEK_DAY_NAME[] = { "SUN", "MON", "TUE", "WED", "THR", "FRI", "SAT" };
	JTextArea[][] dateJTA = new JTextArea[6][7];
	JScrollPane dateJSP;
	static int color[][];

	
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
	JButton stopJB;
	JButton CalculatorJB;
	JButton ddayJB;

	
	JLabel infoClock;
	JLabel selectedDate;
	

	public String dday(int puty,int putm,int putd) {
		java.util.Calendar cal = java.util.Calendar.getInstance();
		

		int year = puty;//지정된 연도
		int month = putm;//         월
		int date = putd;//          일

		String JL;
		long today = cal.getTimeInMillis(); // 오늘 날짜

		cal.set(year, month-1, date); //cal 날짜를 지정된 D day 연, 월-1, 일로 변경

		long setday = cal.getTimeInMillis(); // D day를 TimeMillis로
		long Dday = (today - setday) / (60*60*24*1000); //밀리초를 일수로
		if(Dday == 0)
			JL="D-Day";
		
		else if(Dday > 0)
			JL="D+" + Dday;
		else
		JL="D" + Dday;
		
		return JL;
		
	}

	///////////////////////////////////////////////////////////
	public Team4() {
	mainFrame=new JFrame("주간계획표");
	mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	mainFrame.setSize(1000,1000);
	mainFrame.setLocationRelativeTo(null);//프레임 중앙에 띄우기
	mainFrame.setResizable(false);//창크기변경불가
	GridBagLayout gbl = new GridBagLayout();
	GridBagConstraints gbc = new GridBagConstraints();
	mainFrame.setLayout(gbl);
	
	SimpleDateFormat s1=new SimpleDateFormat("ss");
	
	topJP=new JPanel();
	topJP.setLayout(gbl);
	todayJB=new JButton("오늘");
	todayJB.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			JFrame f=new JFrame("스윙달력");
		     CalendarTest ct=new CalendarTest();
		     f.getContentPane().add(ct);
		     f.show();
		     f.setSize(200,200);
			
		}
	});
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
	

	calyyyymm= new JLabel("");
	gbc.gridx=3;
	gbc.gridy=1;
	gbc.gridwidth=3;
	gbc.gridheight=2;
	gbc.ipady=30;
	topJP.add(calyyyymm,gbc);
	gbc.ipady=0;
	
	color=new int[CAL_HEIGHT][CAL_WIDTH];
	for(int i=0;i<CAL_HEIGHT;i++) {
		for(int j=0 ; j<CAL_WIDTH ; j++){
		color[i][j]=0;
		}
	}
	
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
		dateJSP = new JScrollPane(dateJTA[i][j], JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);//수직스크롤바 필요하면보이게,수평스크롤바는 안보이게
		calJP.add(dateJSP);
	}
}//날짜배치완료
	calJP.setLayout(new GridLayout(0,7,2,2));
	calJP.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
	
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 9;
		gbc.gridheight = 3;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.ipadx = 500;
		gbc.ipady = 500;
		topJP.add(calJP, gbc);
		gbc.ipadx = 1;
		gbc.ipady = 1;

		choseJTF = new JTextField();
		endJB = new JButton("계획완료");
		endJB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = choseJTF.getText();
				if (s.equals("일1")) {
					if (color[0][0] == 0) {
						color[0][0] = 1;
						dateJTA[0][0].setBackground(Color.gray);
						
					} else {
						color[0][0] = 0;
					dateJTA[0][0].setBackground(Color.WHITE);
					}
				} else if (s.equals("일2")) {
					if (color[1][0] == 0) {
						color[1][0] = 1;
						dateJTA[1][0].setBackground(Color.gray);
					} else {
						color[1][0] = 0;
					dateJTA[1][0].setBackground(Color.WHITE);
					}
				} else if (s.equals("일3")) {
					if (color[2][0] == 0) {
						color[2][0] = 1;
						dateJTA[2][0].setBackground(Color.gray);
					} else {
						color[2][0] = 0;
					dateJTA[2][0].setBackground(Color.WHITE);
					}
				} else if (s.equals("일4")) {
					if (color[3][0] == 0) {
						color[3][0] = 1;
						dateJTA[3][0].setBackground(Color.gray);
					} else {
						color[3][0] = 0;
					dateJTA[3][0].setBackground(Color.WHITE);
					}
				} else if (s.equals("일5")) {
					if (color[4][0] == 0) {
						color[4][0] = 1;
						dateJTA[4][0].setBackground(Color.gray);
					} else {
						color[4][0] = 0;
					dateJTA[4][0].setBackground(Color.WHITE);
					}
				} else if (s.equals("일6")) {
					if (color[5][0] == 0) {
						color[5][0] = 1;
						dateJTA[5][0].setBackground(Color.gray);
					} else {
						color[5][0] = 0;
					dateJTA[5][0].setBackground(Color.WHITE);
					}
				}

				else if (s.equals("월1")) {
					if (color[0][1] == 0) {
						color[0][1] = 1;
						dateJTA[0][1].setBackground(Color.gray);
					} else {
						color[0][1] = 0;
					dateJTA[0][1].setBackground(Color.WHITE);
					}
				} else if (s.equals("월2")) {
					if (color[1][1] == 0) {
						color[1][1] = 1;
						dateJTA[1][1].setBackground(Color.gray);
					} else {
						color[1][1] = 0;
					dateJTA[1][1].setBackground(Color.WHITE);
					}
				} else if (s.equals("월3")) {
					if (color[2][1] == 0) {
						color[2][1] = 1;
						dateJTA[2][1].setBackground(Color.gray);
					} else {
						color[2][1] = 0;
					dateJTA[2][1].setBackground(Color.WHITE);
					}
				} else if (s.equals("월4")) {
					if (color[3][1] == 0) {
						color[3][1] = 1;
						dateJTA[3][1].setBackground(Color.gray);
					} else {
						color[3][1] = 0;
					dateJTA[3][1].setBackground(Color.WHITE);
					}
				} else if (s.equals("월5")) {
					if (color[4][1] == 0) {
						color[4][1] = 1;
						dateJTA[4][1].setBackground(Color.gray);
					} else {
						color[4][1] = 0;
					dateJTA[4][1].setBackground(Color.WHITE);
					}
				} else if (s.equals("월6")) {
					if (color[5][1] == 0) {
						color[5][1] = 1;
						dateJTA[5][1].setBackground(Color.gray);
					} else {
						color[5][1] = 0;
					dateJTA[5][1].setBackground(Color.WHITE);
					}
				} else if (s.equals("화1")) {
					if (color[0][2] == 0) {
						color[0][2] = 1;
						dateJTA[0][2].setBackground(Color.gray);
					} else {
						color[0][2] = 0;
					dateJTA[0][2].setBackground(Color.WHITE);
					}
				} else if (s.equals("화2")) {
					if (color[1][2] == 0) {
						color[1][2] = 1;
						dateJTA[1][2].setBackground(Color.gray);
					} else {
						color[1][2] = 0;
					dateJTA[1][2].setBackground(Color.WHITE);
					}
				} else if (s.equals("화3")) {
					if (color[2][2] == 0) {
						color[2][2] = 1;
						dateJTA[2][2].setBackground(Color.gray);
					} else {
						color[2][2] = 0;
					dateJTA[2][2].setBackground(Color.WHITE);
					}
				} else if (s.equals("화4")) {
					if (color[3][2] == 0) {
						color[3][2] = 1;
						dateJTA[3][2].setBackground(Color.gray);
					} else {
						color[3][2] = 0;
					dateJTA[3][2].setBackground(Color.WHITE);
					}
				} else if (s.equals("화5")) {
					if (color[4][2] == 0) {
						color[4][2] = 1;
						dateJTA[4][2].setBackground(Color.gray);
					} else {
						color[4][2] = 0;
					dateJTA[4][2].setBackground(Color.WHITE);
					}
				} else if (s.equals("화6")) {
					if (color[5][2] == 0) {
						color[5][2] = 1;
						dateJTA[5][2].setBackground(Color.gray);
					} else {
						color[5][2] = 0;
					dateJTA[5][2].setBackground(Color.WHITE);
					}
				} else if (s.equals("수1")) {
					if (color[0][3] == 0) {
						color[0][3] = 1;
						dateJTA[0][3].setBackground(Color.gray);
					} else {
						color[0][3] = 0;
					dateJTA[0][3].setBackground(Color.WHITE);
					}
				} else if (s.equals("수2")) {
					if (color[1][3] == 0) {
						color[1][3] = 1;
						dateJTA[1][3].setBackground(Color.gray);
					} else {
						color[1][3] = 0;
					dateJTA[1][3].setBackground(Color.WHITE);
					}
				} else if (s.equals("수3")) {
					if (color[2][3] == 0) {
						color[2][3] = 1;
						dateJTA[2][3].setBackground(Color.gray);
					} else {
						color[2][3] = 0;
					dateJTA[2][3].setBackground(Color.WHITE);
					}
				} else if (s.equals("수4")) {
					if (color[3][3] == 0) {
						color[3][3] = 1;
						dateJTA[3][3].setBackground(Color.gray);
					} else {
						color[3][3] = 0;
					dateJTA[3][3].setBackground(Color.WHITE);
					}
				} else if (s.equals("수5")) {
					if (color[4][3] == 0) {
						color[4][3] = 1;
						dateJTA[4][3].setBackground(Color.gray);
					} else {
						color[4][3] = 0;
					dateJTA[4][3].setBackground(Color.WHITE);
					}
				} else if (s.equals("수6")) {
					if (color[5][3] == 0) {
						color[5][3] = 1;
						dateJTA[5][3].setBackground(Color.gray);
					} else {
						color[5][3] = 0;
					dateJTA[5][3].setBackground(Color.WHITE);
					}
				} else if (s.equals("목1")) {
					if (color[0][4] == 0) {
						color[0][4] = 1;
						dateJTA[0][4].setBackground(Color.gray);
					} else {
						color[0][4] = 0;
					dateJTA[0][4].setBackground(Color.WHITE);
					}
				} else if (s.equals("목2")) {
					if (color[1][4] == 0) {
						color[1][4] = 1;
						dateJTA[1][4].setBackground(Color.gray);
					} else {
						color[1][4] = 0;
					dateJTA[1][4].setBackground(Color.WHITE);
					}
				} else if (s.equals("목3")) {
					if (color[2][4] == 0) {
						color[2][4] = 1;
						dateJTA[2][4].setBackground(Color.gray);
					} else {
						color[2][4] = 0;
					dateJTA[2][4].setBackground(Color.WHITE);
					}
				} else if (s.equals("목4")) {
					if (color[3][4] == 0) {
						color[3][4] = 1;
						dateJTA[3][4].setBackground(Color.gray);
					} else {
						color[3][4] = 0;
					dateJTA[3][4].setBackground(Color.WHITE);
					}
				} else if (s.equals("목5")) {
					if (color[4][4] == 0) {
						color[4][4] = 1;
						dateJTA[4][4].setBackground(Color.gray);
					} else {
						color[4][4] = 0;
					dateJTA[4][4].setBackground(Color.WHITE);
					}
				} else if (s.equals("목6")) {
					if (color[5][4] == 0) {
						color[5][4] = 1;
						dateJTA[5][4].setBackground(Color.gray);
					} else {
						color[5][4] = 0;
					dateJTA[5][4].setBackground(Color.WHITE);
					}
				} else if (s.equals("금1")) {
					if (color[0][5] == 0) {
						color[0][5] = 1;
						dateJTA[0][5].setBackground(Color.gray);
					} else {
						color[0][5] = 0;
					dateJTA[0][5].setBackground(Color.WHITE);
					}
				} else if (s.equals("금2")) {
					if (color[1][5] == 0) {
						color[1][5] = 1;
						dateJTA[1][5].setBackground(Color.gray);
					} else {
						color[1][5] = 0;
					dateJTA[1][5].setBackground(Color.WHITE);
					}
				} else if (s.equals("금3")) {
					if (color[2][5] == 0) {
						color[2][5] = 1;
						dateJTA[2][5].setBackground(Color.gray);
					} else {
						color[2][5] = 0;
					dateJTA[2][5].setBackground(Color.WHITE);
					}
				} else if (s.equals("금4")) {
					if (color[3][5] == 0) {
						color[3][5] = 1;
						dateJTA[3][5].setBackground(Color.gray);
					} else {
						color[3][5] = 0;
					dateJTA[3][5].setBackground(Color.WHITE);
					}
				} else if (s.equals("금5")) {
					if (color[4][5] == 0) {
						color[4][5] = 1;
						dateJTA[4][5].setBackground(Color.gray);
					} else {
						color[4][5] = 0;
					dateJTA[4][5].setBackground(Color.WHITE);
					}
				} else if (s.equals("금6")) {
					if (color[5][5] == 0) {
						color[5][5] = 1;
						dateJTA[5][5].setBackground(Color.gray);
					} else {
						color[5][5] = 0;
					dateJTA[5][5].setBackground(Color.WHITE);
					}
				} else if (s.equals("토1")) {
					if (color[0][6] == 0) {
						color[0][6] = 1;
						dateJTA[0][6].setBackground(Color.gray);
					} else {
						color[0][6] = 0;
					dateJTA[0][6].setBackground(Color.WHITE);
					}
				} else if (s.equals("토2")) {
					if (color[1][6] == 0) {
						color[1][6] = 1;
						dateJTA[1][6].setBackground(Color.gray);
					} else {
						color[1][6] = 0;
					dateJTA[1][6].setBackground(Color.WHITE);
					}
				} else if (s.equals("토3")) {
					if (color[2][6] == 0) {
						color[2][6] = 1;
						dateJTA[2][6].setBackground(Color.gray);
					} else {
						color[2][6] = 0;
					dateJTA[2][6].setBackground(Color.WHITE);
					}
				} else if (s.equals("토4")) {
					if (color[3][6] == 0) {
						color[3][6] = 1;
						dateJTA[3][6].setBackground(Color.gray);
					} else {
						color[3][6] = 0;
					dateJTA[3][6].setBackground(Color.WHITE);
					}
				} else if (s.equals("토5")) {
					if (color[4][6] == 0) {
						color[4][6] = 1;
						dateJTA[4][6].setBackground(Color.gray);
					} else {
						color[4][6] = 0;
					dateJTA[4][6].setBackground(Color.WHITE);
					}
				} else if (s.equals("토6")) {
					if (color[5][6] == 0) {
						color[5][6] = 1;
						dateJTA[5][6].setBackground(Color.gray);
					} else {
						color[5][6] = 0;
					dateJTA[5][6].setBackground(Color.WHITE);
					}
				}

			}
		});

	deleteJB=new JButton("지우기");
	deleteJB.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			String s =choseJTF.getText();
			if(s.equals("일1"))
			dateJTA[0][0].setText("");
			else if(s.equals("일2"))
				dateJTA[1][0].setText("");
			else if(s.equals("일3"))
				dateJTA[2][0].setText("");
			else if(s.equals("일4"))
				dateJTA[3][0].setText("");
			else if(s.equals("일5"))
				dateJTA[4][0].setText("");
			else if(s.equals("일6"))
				dateJTA[5][0].setText("");
			else if(s.equals("월1"))
				dateJTA[0][1].setText("");
			else if(s.equals("월2"))
				dateJTA[1][1].setText("");
			else if(s.equals("월3"))
				dateJTA[2][1].setText("");
			else if(s.equals("월4"))
				dateJTA[3][1].setText("");
			else if(s.equals("월5"))
				dateJTA[4][1].setText("");
			else if(s.equals("월6"))
				dateJTA[5][1].setText("");
			else if(s.equals("화1"))
				dateJTA[0][2].setText("");
			else if(s.equals("화2"))
				dateJTA[1][2].setText("");
			else if(s.equals("화3"))
				dateJTA[2][2].setText("");
			else if(s.equals("화4"))
				dateJTA[3][2].setText("");
			else if(s.equals("화5"))
				dateJTA[4][2].setText("");
			else if(s.equals("화6"))
				dateJTA[5][2].setText("");
			else if(s.equals("수1"))
				dateJTA[0][3].setText("");
			else if(s.equals("수2"))
				dateJTA[1][3].setText("");
			else if(s.equals("수3"))
				dateJTA[2][3].setText("");
			else if(s.equals("수4"))
				dateJTA[3][3].setText("");
			else if(s.equals("수5"))
				dateJTA[4][3].setText("");
			else if(s.equals("수6"))
				dateJTA[5][3].setText("");
			else if(s.equals("목1"))
				dateJTA[0][4].setText("");
			else if(s.equals("목2"))
				dateJTA[1][4].setText("");
			else if(s.equals("목3"))
				dateJTA[2][4].setText("");
			else if(s.equals("목4"))
				dateJTA[3][4].setText("");
			else if(s.equals("목5"))
				dateJTA[4][4].setText("");
			else if(s.equals("목6"))
				dateJTA[5][4].setText("");
			else if(s.equals("금1"))
				dateJTA[0][5].setText("");
			else if(s.equals("금2"))
				dateJTA[1][5].setText("");
			else if(s.equals("금3"))
				dateJTA[2][5].setText("");
			else if(s.equals("금4"))
				dateJTA[3][5].setText("");
			else if(s.equals("금5"))
				dateJTA[4][5].setText("");
			else if(s.equals("금6"))
				dateJTA[5][5].setText("");
			else if(s.equals("토1"))
				dateJTA[0][6].setText("");
			else if(s.equals("토2"))
				dateJTA[1][6].setText("");
			else if(s.equals("토3"))
				dateJTA[2][6].setText("");
			else if(s.equals("토4"))
				dateJTA[3][6].setText("");
			else if(s.equals("토5"))
				dateJTA[4][6].setText("");
			else if(s.equals("토6"))
				dateJTA[5][6].setText("");
		}
	});
	clearJB=new JButton("전체지우기");
	clearJB.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			int result=JOptionPane.showConfirmDialog(null, "정말 모두 지우시겠습니까?","Confirm",JOptionPane.YES_NO_OPTION);
			 if(result==JOptionPane.YES_OPTION) {
				 for(int i=0;i<CAL_HEIGHT;i++) {
						for(int j=0 ; j<CAL_WIDTH ; j++) {
							dateJTA[i][j].setText("");
						}
				 }
			 }
		}
	});
	infoJL=new JLabel("");
	
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
		gbc.gridx = 4;
		topJP.add(clearJB, gbc);
		gbc.gridx = 5;

		ddayJB = new JButton("디데이 설정");
		ddayJB.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String ymd = JOptionPane.showInputDialog("연도/월/일 로 입력해주세요");
				String[] array = ymd.split("/");
				int y = Integer.parseInt(array[0]);
				int m = Integer.parseInt(array[1]);
				int d = Integer.parseInt(array[2]);

				
				calyyyymm.setText(	dday(y, m, d));
			}
		});
			
			
		topJP.add(ddayJB, gbc);

    ExamJB=new JButton("성적입력");
    ExamJB.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			new GradeInput();
			
		}
	});
    MemoJB=new JButton("메모장");
    MemoJB.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			new Memo("Memo");
			
		}
	});
	stopJB=new JButton("스탑워치");
	stopJB.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			new StopWatch().visibleFrame();
			
		}
	});
	CalculatorJB=new JButton("계산기");
	CalculatorJB.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			Cal frame = new Cal();
			frame.setVisible(true);
			
		}
	});
	
	
	gbc.gridx=0;
	gbc.gridy=1;
	gbc.weightx=1;
	gbc.weighty=1;
	topJP.add(ExamJB,gbc);
    gbc.gridx=1;
	topJP.add(MemoJB,gbc);
	gbc.gridx=6;
	topJP.add(CalculatorJB,gbc);
	gbc.gridx=7;
	topJP.add(stopJB,gbc);
	
	
	mainFrame.add(topJP);
	
	
	mainFrame.setVisible(true);
	
	
	
}
	public static void main(String[] args) {
		new Team4();
	}
	}


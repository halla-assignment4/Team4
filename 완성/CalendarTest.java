package ma.homwork;

import java.awt.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;

class CalendarTest extends JPanel implements ActionListener
{
 private GregorianCalendar cal,cal2;
 private JComboBox  monthChoice;
    private JLabel  year;
    private JButton     previousButton;
    private JButton     nextButton;
    private int        currentMonth;//현재월
    private int        currentYear;//현재연도
 private int        currentDay;//현재요일
 private String     currentDayString;
    private String     currentDateString;//현재 날자.
    private Font helvB16 = 
                new Font("바탕체", Font.PLAIN, 12);
    private String days[] = {"일","월", "화", "수", "목", "금", 
                             "토"};
    private String months[] = {
                     "January", "February", "March", "April",
                     "May", "June", "July", "August", "September",
                     "October", "November", "December"};
    private int daysInMonth[] = {31, 28, 31, 30, 31, 30, 31, 31, 
                                 30, 31, 30, 31};
    private JLabel[][] monthButtons=new JLabel[6][7];
 private JLabel[] dayLabels = new JLabel[7];
 
 
// GUI 구성
 CalendarTest(){
  // 현재 연도 가져오기
  cal=new GregorianCalendar();
  currentYear=cal.get(Calendar.YEAR);

  // 현재 달을 알아낸다.
  currentMonth=cal.get(Calendar.MONTH);

  JPanel main=new JPanel();
  main.setLayout(new BorderLayout());

        // 상단 바 구성 패널
  JPanel up=new JPanel();
  up.setLayout(new GridLayout(1,4));

  // 연도 
  year=new JLabel("" + currentYear,JLabel.CENTER);
  year.setFont(helvB16);
  up.add(year);
  
  // 월 선택 초이스
  monthChoice=new JComboBox();
  for(int i=0;i<months.length;i++){
   monthChoice.addItem(months[i]);
  }
  monthChoice.setSelectedIndex(currentMonth);
  up.add(monthChoice);
  monthChoice.addActionListener(this); 
  main.add("North",up);
  
  // 하단 달력 버튼 만들기
        JPanel down=new JPanel();
  down.setLayout(new BorderLayout());

  // dayp 패널에 요일 버튼을 부착한다. 
  JPanel dayp=new JPanel();
  dayp.setLayout(new GridLayout(1,7));   
  for(int i=0;i<days.length;i++){
   dayLabels[i] = new JLabel(days[i], JLabel.CENTER);
   dayLabels[i].setFont(helvB16);
   dayp.add(dayLabels[i]);
  }
  down.add("North",dayp);

  // datep 패널에 빈라벨 부착하기. 나중에 달력이된다.
        JPanel datep=new JPanel();
  datep.setLayout(new GridLayout(6,7));
  for(int i=0; i < 6; i++)
            for(int j=0; j < 7; j++)
            {
                monthButtons[i][j] = new JLabel("",JLabel.CENTER);
    monthButtons[i][j].setFont(helvB16);
                datep.add(monthButtons[i][j]);
            }  
  down.add("Center",datep);
  main.add("Center",down);
  add(main);
// 실제 날짜를 라벨로 붙이기
  display_cal();
  }

  public void display_cal(){
   
   
   cal2=new GregorianCalendar(currentYear, currentMonth, 1);
   currentDay=cal2.get(Calendar.DAY_OF_WEEK);//현재 달의 첫째요일을 알아낸다.
   
   int MaxDate=daysInMonth[currentMonth];//현재 달의 마지막 날짜를 알아낸다.
   int date_Now=1;//현재 날짜를 나타낸다.
   boolean ok=true;//빈 라벨 개수 여부.
    

   for(int i=0; i < 6; i++){
    for(int j=0; j < 7; j++){
     if(date_Now == 1 && j+1 < currentDay){//1일이 일요일이 아니라면 요일까지 빈버튼.
      monthButtons[i][j].setText("");
     }else if(date_Now > MaxDate)//날짜가 마지막 날짜보다 커지면 
      monthButtons[i][j].setText("");
     else{
      String today = ""+date_Now;
      monthButtons[i][j].setText(today);
      date_Now++;
     }
    }
   }
  }
// 드롭다운 버튼(JComboBox)에서 월을 선택시 이벤트 처리
   public void actionPerformed(ActionEvent ae) {
   Object o=ae.getSource();
   int selectMonth=monthChoice.getSelectedIndex();// 선택한 월의 인텍스를 알아냄.   
     monthChoice.setSelectedIndex(selectMonth);
    cal.set(Calendar.MONTH, selectMonth);// 선택한 월을 현재 달로 설정
    currentMonth=cal.get(Calendar.MONTH);
    display_cal();
   }
          public static void main(String args[]){
     JFrame f=new JFrame("스윙달력");
     CalendarTest ct=new CalendarTest();
     f.getContentPane().add(ct);
     f.show();
     f.setSize(200,200);
            
          }
}
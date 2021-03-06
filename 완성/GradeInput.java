package ma.homwork;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
 
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
 
public class GradeInput extends JFrame implements ActionListener {
    static Scanner sc = new Scanner(System.in);
    private ArrayList<GradeData> AL = new ArrayList<GradeData>();
    GradeData gradedata;
    JButton btn1 = new JButton("입력");
    JButton btn2 = new JButton("출력");
    JButton btn3 = new JButton("시험명 검색");
    JButton btn4 = new JButton("삭제");
    JTextField tf = new JTextField(10);
    JTextField tf1 = new JTextField(10);
    JTextField tf2 = new JTextField(10);
    JTextField tf3 = new JTextField(10);
    JTextField tf4 = new JTextField(10);
    JTextField tf5 = new JTextField(10);

    JPanel p1=new JPanel();
    JPanel p2=new JPanel();
    JPanel p3=new JPanel();
    JTextArea ta = new JTextArea(15, 15);
 
 
    JLabel jl = new JLabel("시험명");
    JLabel jl1 = new JLabel("국어");
    JLabel jl2 = new JLabel("영어");
    JLabel jl3 = new JLabel("수학");
    JLabel jl4 = new JLabel("탐구1");
    JLabel jl5 = new JLabel("탐구2");
 
    FlowLayout flow = new FlowLayout();
    public GradeInput() {
        super("성적처리");
 
 
        //Label과 TextField를 frame에 넣어줍니다
        p1.add(jl);
        p1.add(tf);
 
        p1.add(jl1);
        p1.add(tf1);
        p1.add(jl2);
        p1.add(tf2);
        p1.add(jl3);
        p1.add(tf3);    
        p1.add(jl4);
        p1.add(tf4);
        p1.add(jl5);
        p1.add(tf5);

 
      
        //버튼을 생성합니다.
        p2.add(btn1);
        p2.add(btn2);
        p2.add(btn4);
        
        // frame에 textArea을생성합니다
        add(ta);
        
        //panel p1, p2를 각각 북쪽 남쪽으로 붙여줍니다
        add(p1,"North");
        add(p2,"South");
 
 
    
 
 
 
 
 
 
        //창의 크기를 1800, 800으로 정합니다
        this.setSize(1800, 800);
  
 
 
        //액션리스너를 통해 버튼의 기능을 사용할 수 있게 합니다.
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn4.addActionListener(this);
        
                
        setVisible(true);
 
    }
 
    public static void main(String[] args) {
 
        new GradeInput();
    }
    
    
    //각 버튼의 기능들을 넣어줍니다.
    
    public void actionPerformed(ActionEvent e) {
        String str=e.getActionCommand();
        
        //입력 부분입니다
        if(str.equals("입력")){
            ta.setText("");
            GradeData  gradedata = new GradeData();
            if(tf.getText().equals("")) {
                ta.append("이름값을 넣어주세요!\n");
            }
            if(tf1.getText().equals("")) {
                ta.append("국어점수를 넣어주세요!\n");
            }
            if(tf2.getText().equals("")) {
                ta.append("영어점수를 넣어주세요!\n");
            }
            if(tf3.getText().equals("")) {
                ta.append("수학점수를 넣어주세요!\n");
            }
            if(tf4.getText().equals("")) {
                ta.append("탐구1점수를 넣어주세요!\n");
            }
            if(tf5.getText().equals("")) {
                ta.append("탐구2점수를 넣어주세요!\n");
            }
            else {
 
            	gradedata.setName(tf.getText());
            	gradedata.setKor(Integer.parseInt(tf1.getText()));
            	gradedata.setEng(Integer.parseInt(tf2.getText()));
            	gradedata.setMat(Integer.parseInt(tf3.getText()));
            	gradedata.settam1(Integer.parseInt(tf4.getText()));
            	gradedata.settam2(Integer.parseInt(tf5.getText()));
            	gradedata.get3Total();
            	gradedata.get5Total();
            	gradedata.getAvg();
                AL.add(gradedata);
 
                tf.setText("");
                tf1.setText("");
                tf2.setText("");
                tf3.setText("");
                tf4.setText("");
                tf5.setText("");
                ta.setText("성공적으로 입력되었습니다!\n");
            }
        }
        
        //출력 부분입니다.
        else if(str.equals("출력")){
            ta.setText("");
            if(AL.size()<1) {
                ta.setText("정보가 없습니다!\n");
            }
            else {
                Descend des = new Descend();
                Collections.sort(AL, des); 
                for(GradeData mas : AL) {
 
                    ta.append(mas.toString()+"\n");
 
                }
            }
        }

        //삭제기능
        else if(str.equals("삭제"))
        {
            int count = 0;
 
 
            if(AL.size() < 1) {
                ta.setText("정보가 없습니다!\n");
            }
            else {
 
                for(GradeData ms : AL) {
                    if(ms.getName().equals(tf.getText())) {
                        AL.remove(ms);
                        ta.setText("성공적으로 삭제되었습니다!");
                        count++;
                        break;
                    }
 
                }
 
                if(count == 0) {
                    ta.setText("일치하는 정보가 없습니다!\n");
                }
 
            }       
        }
      
 
    }
}
 
 
//정렬해주는 클래스입니다
class Descend implements Comparator<GradeData> {
   
    public int compare(GradeData o1, GradeData o2) {
        return o2.compareTo(o1);
    }
}
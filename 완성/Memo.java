package ma.homwork;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.io.StringWriter;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Memo extends JFrame{
private JTextArea ta;
private String fileName;
	public Memo(String title) {
		super(title);
		JMenu mfile = new JMenu("파일");
		JMenuItem mOpen = new JMenuItem("열기");
		JMenuItem mNew = new JMenuItem("새파일");
		JMenuItem mSave = new JMenuItem("저장");
		JMenuItem mSaveAs = new JMenuItem("다른이름저장");
		JMenuItem mExit = new JMenuItem("끝내기");
		
		 //메뉴에 메뉴아이템 붙이기
		mfile.add(mNew);
		mfile.add(mOpen);
		mfile.add(mSave);
		mfile.add(mSaveAs);
		mfile.addSeparator();//분리선 넣기
		mfile.add(mExit);
		
		JMenuBar mb = new JMenuBar();
		mb.add(mfile);
		
		setJMenuBar(mb);
		
		 ta = new JTextArea();
//		JScrollPane jsp = new JScrollPane(ta);
		JScrollPane jsp = new JScrollPane();
		jsp.setViewportView(ta);
		add(jsp);//제이프레임은 BorderLayout인데 기본값은 Center가 된다.
		
		//새파일
		mNew.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				ta.setText("");
				setTitle("제목없음");
			}
		});
		//열기
		mOpen.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc = new JFileChooser();
				/*int a = jfc.showOpenDialog(Memo.this);
				if(a==1)return;*/
				if(jfc.showOpenDialog(Memo.this)==JFileChooser.CANCEL_OPTION)
					return;
				//부모클래스를 기반으로 하기 때문에 parant의 값을 해줘야함 
				File f = jfc.getSelectedFile();
				 fileName = f.getPath();//파일이 소속된 절대경로
				setTitle(f.getName());//타이틀을 파일의 이름만 가져옴
				fileRead(fileName);
			}
		});
		//저장
		mSave.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if(getTitle().equals("제목없음")) {//새파일. 제목이 지정되지 않은 경우
					JFileChooser fc = new JFileChooser();
					if(fc.showSaveDialog(Memo.this)
							==JFileChooser.CANCEL_OPTION)
					return;
					File f = fc.getSelectedFile();
					fileName = f.getPath();
					setTitle(f.getName());
					fileSave(fileName);
					//mSaveAs.doClick();
				}else {
					fileSave(fileName);//타이틀이 존재할경우에는 그냥 세이브로 진행
				}
			}
		});
		//새이름 저장
		mSaveAs.addActionListener(new ActionListener() {
			
		
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();
				/*int a = fc.showSaveDialog(Memo.this);//SaveDialog이다.
				if(a==1)return;*/
				if(fc.showSaveDialog(Memo.this)==JFileChooser.CANCEL_OPTION)
					return;
				File f = fc.getSelectedFile();
				 fileName = f.getPath();
				System.out.println("저장 파일 "+fileName);
				setTitle(f.getName());
				fileSave(fileName);
			}
		});
		//끝내기
		mExit.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		setSize(500, 400);
		setVisible(true);
	}
	//	파일 읽기 메서드
	private void fileRead(String fileName) {
		try {
			FileReader fr = new FileReader(fileName);
			StringWriter sw = new StringWriter();//문자열 조작이 많을때 사용
			while(true) {
				int ch = fr.read();//파일을 읽어서 ch에 저장
				if(ch==-1)break;
				//ch가 -1일때 스톱(뒷글자가 없을때 스톱)
				//read의 성질은 값을 가져올때 마지막 다음글자는 자동으로 -1을 반환하기 때문에
				//-1일때 멈추라고 한다.
				sw.write(ch);//ch에 저장된것을 StringWriter에 기록
			}
			sw.close();//StringWriter 닫기
			ta.setText(sw.toString());
			//String Writer는 int값으로 받았기 때문에 toString으로 변환
			
		} catch (FileNotFoundException e) {//FileReader에 대한 catch문
			e.printStackTrace();
		}catch(IOException a) {//read에 대한 catch문
		}	
	}
	//파일로 저장
	private void fileSave(String fileName) {
		try {
			PrintStream ps = new PrintStream(fileName);
			ps.println(ta.getText());
			ps.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new Memo("제목없음");
	}
}


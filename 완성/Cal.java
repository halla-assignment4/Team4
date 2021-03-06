package ma.homwork;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Cal extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JButton btMC;
	private JButton btMR;
	private JButton btMS;
	private JButton btMP;
	private JButton btMM;
	private JButton btBack;
	private JButton btCE;
	private JButton btC;
	private JButton btPM;
	private JButton btRoot;
	private JButton bt4;
	private JButton bt7;
	private JButton bt8;
	private JButton bt5;
	private JButton bt6;
	private JButton bt9;
	private JButton btDevide;
	private JButton btMultiple;
	private JButton bt1x;
	private JButton btPercent;
	private JButton bt0;
	private JButton bt1;
	private JButton bt2;
	private JButton btDot;
	private JButton bt3;
	private JButton btMinus;
	private JButton btPlus;
	private JButton btResult;
	public JLabel topLabel;
	public JLabel resultLabel;
	String oper = "";
	double firstValue = 0;
	double secondValue = 0;
	double resultValue = 0;
	boolean check = false;
	boolean alreadyClick = false;
	String textClean = "";
	String topString = "";



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cal frame = new Cal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public Cal() {
		setTitle("Cal");
		
		setBounds(100, 100, 311, 348);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(Color.WHITE);
		
		panel = new JPanel();
		panel.setBorder(UIManager.getBorder("TitledBorder.border"));
		panel.setBackground(Color.WHITE);
		panel.setBounds(12, 10, 268, 70);
		contentPane.add(panel);
		panel.setLayout(null);
		
		topLabel = new JLabel("");
		topLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 11));
		topLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		topLabel.setBounds(10, 0, 250, 20);
		panel.add(topLabel);
		
		resultLabel = new JLabel("0");
		resultLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		resultLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		resultLabel.setBounds(10, 20, 250, 50);
		panel.add(resultLabel);
		
		btMC = new JButton("MC");
		btMC.setFont(new Font("맑은 고딕", Font.PLAIN, 10));
		btMC.setBackground(Color.CYAN);
		btMC.setBorderPainted(false);
		btMC.setBounds(10, 90, 50, 30);
		contentPane.add(btMC);
		
		btMR = new JButton("MR");
		btMR.setFont(new Font("맑은 고딕", Font.PLAIN, 10));
		btMR.setBackground(Color.CYAN);
		btMR.setBorderPainted(false);
		btMR.setBounds(65, 90, 50, 30);
		contentPane.add(btMR);
		
		btMS = new JButton("MS");
		btMS.setFont(new Font("맑은 고딕", Font.PLAIN, 10));
		btMS.setBackground(Color.CYAN);
		btMS.setBorderPainted(false);
		btMS.setBounds(120, 90, 50, 30);
		contentPane.add(btMS);
		
		btMP = new JButton("M+");
		btMP.setFont(new Font("맑은 고딕", Font.PLAIN, 10));
		btMP.setBackground(Color.CYAN);
		btMP.setBorderPainted(false);
		btMP.setBounds(175, 90, 50, 30);
		contentPane.add(btMP);
		
		btMM = new JButton("M-");
		btMM.setFont(new Font("맑은 고딕", Font.PLAIN, 10));
		btMM.setBackground(Color.CYAN);
		btMM.setBorderPainted(false);
		btMM.setBounds(230, 90, 50, 30);
		contentPane.add(btMM);
		
		btBack = new JButton("\u2190");
		btBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btBack_actionPerformed(e);
			}
		});
		btBack.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		btBack.setBackground(Color.CYAN);
		btBack.setBorderPainted(false);
		btBack.setBounds(10, 125, 50, 30);
		contentPane.add(btBack);
		
		btCE = new JButton("CE");
		btCE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btCE_actionPerformed(e);
			}
		});
		btCE.setFont(new Font("맑은 고딕", Font.PLAIN, 10));
		btCE.setBackground(Color.CYAN);
		btCE.setBorderPainted(false);
		btCE.setBounds(65, 125, 50, 30);
		contentPane.add(btCE);
		
		btC = new JButton("C");
		btC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btC_actionPerformed(e);
			}
		});
		btC.setFont(new Font("맑은 고딕", Font.PLAIN, 10));
		btC.setBackground(Color.CYAN);
		btC.setBorderPainted(false);
		btC.setBounds(120, 125, 50, 30);
		contentPane.add(btC);
		
		btPM = new JButton("\u00B1");
		btPM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btPM_actionPerformed(e);
			}
		});
		btPM.setFont(new Font("맑은 고딕", Font.PLAIN, 10));
		btPM.setBackground(Color.CYAN);
		btPM.setBorderPainted(false);
		btPM.setBounds(175, 125, 50, 30);
		contentPane.add(btPM);
		
		btRoot = new JButton("\u221A");
		btRoot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btRoot_actionPerformed(e);
			}
		});
		btRoot.setFont(new Font("맑은 고딕", Font.PLAIN, 10));
		btRoot.setBackground(Color.CYAN);
		btRoot.setBorderPainted(false);
		btRoot.setBounds(230, 125, 50, 30);
		contentPane.add(btRoot);
		
		bt4 = new JButton("4");
		bt4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_bt4_actionPerformed(e);
			}
		});
		bt4.setBackground(Color.WHITE);
		bt4.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		bt4.setBounds(10, 195, 50, 30);
		contentPane.add(bt4);
		
		bt7 = new JButton("7");
		bt7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_bt7_actionPerformed(e);
			}
		});
		bt7.setBackground(Color.WHITE);
		bt7.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		bt7.setBounds(10, 160, 50, 30);
		contentPane.add(bt7);
		
		bt8 = new JButton("8");
		bt8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_bt8_actionPerformed(e);
			}
		});
		bt8.setBackground(Color.WHITE);
		bt8.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		bt8.setBounds(65, 160, 50, 30);
		contentPane.add(bt8);
		
		bt5 = new JButton("5");
		bt5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_bt5_actionPerformed(e);
			}
		});
		bt5.setBackground(Color.WHITE);
		bt5.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		bt5.setBounds(65, 195, 50, 30);
		contentPane.add(bt5);
		
		bt6 = new JButton("6");
		bt6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_bt6_actionPerformed(e);
			}
		});
		bt6.setBackground(Color.WHITE);
		bt6.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		bt6.setBounds(120, 195, 50, 30);
		contentPane.add(bt6);
		
		bt9 = new JButton("9");
		bt9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_bt9_actionPerformed(e);
			}
		});
		bt9.setBackground(Color.WHITE);
		bt9.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		bt9.setBounds(120, 160, 50, 30);
		contentPane.add(bt9);
		
		btDevide = new JButton("/");
		btDevide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btDevide_actionPerformed(e);
			}
		});
		btDevide.setFont(new Font("맑은 고딕", Font.PLAIN, 10));
		btDevide.setBackground(Color.CYAN);
		btDevide.setBorderPainted(false);
		btDevide.setBounds(175, 160, 50, 30);
		contentPane.add(btDevide);
		
		btMultiple = new JButton("*");
		btMultiple.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btMultiple_actionPerformed(e);
			}
		});
		btMultiple.setFont(new Font("맑은 고딕", Font.PLAIN, 10));
		btMultiple.setBackground(Color.CYAN);
		btMultiple.setBorderPainted(false);
		btMultiple.setBounds(175, 195, 50, 30);
		contentPane.add(btMultiple);
		
		bt1x = new JButton("1/x");
		bt1x.setFont(new Font("맑은 고딕", Font.PLAIN, 10));
		bt1x.setBackground(Color.CYAN);
		bt1x.setBorderPainted(false);
		bt1x.setBounds(230, 195, 50, 30);
		contentPane.add(bt1x);
		
		btPercent = new JButton("%");
		btPercent.setFont(new Font("맑은 고딕", Font.PLAIN, 10));
		btPercent.setBackground(Color.CYAN);
		btPercent.setBorderPainted(false);
		btPercent.setBounds(230, 160, 50, 30);
		contentPane.add(btPercent);
		
		bt0 = new JButton("0");
		bt0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_bt0_actionPerformed(e);
			}
		});
		bt0.setBackground(Color.WHITE);
		bt0.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		bt0.setBounds(10, 265, 105, 30);
		contentPane.add(bt0);
		
		bt1 = new JButton("1");
		bt1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_bt1_actionPerformed(e);
			}
		});
		bt1.setBackground(Color.WHITE);
		bt1.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		bt1.setBounds(10, 230, 50, 30);
		contentPane.add(bt1);
		
		bt2 = new JButton("2");
		bt2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_bt2_actionPerformed(e);
			}
		});
		bt2.setBackground(Color.WHITE);
		bt2.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		bt2.setBounds(65, 230, 50, 30);
		contentPane.add(bt2);
		
		btDot = new JButton(".");
		btDot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btDot_actionPerformed(e);
			}
		});
		btDot.setBackground(Color.WHITE);
		btDot.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		btDot.setBounds(120, 265, 50, 30);
		contentPane.add(btDot);
		
		bt3 = new JButton("3");
		bt3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_bt3_actionPerformed(e);
			}
		});
		bt3.setBackground(Color.WHITE);
		bt3.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		bt3.setBounds(120, 230, 50, 30);
		contentPane.add(bt3);
		
		btMinus = new JButton("-");
		btMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btMinus_actionPerformed(e);
			}
		});
		btMinus.setFont(new Font("맑은 고딕", Font.PLAIN, 10));
		btMinus.setBackground(Color.CYAN);
		btMinus.setBorderPainted(false);
		btMinus.setBounds(175, 230, 50, 30);
		contentPane.add(btMinus);
		
		btPlus = new JButton("+");
		btPlus.setBackground(Color.CYAN);
		btPlus.setBorderPainted(false);
		btPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btPlus_actionPerformed(e);
			}
		});
		btPlus.setFont(new Font("맑은 고딕", Font.PLAIN, 10));
		btPercent.setBackground(Color.CYAN);
		btPercent.setBorderPainted(false);
		btPlus.setBounds(175, 265, 50, 30);
		contentPane.add(btPlus);
		
		btResult = new JButton("=");
		btResult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btResult_actionPerformed(e);
			}
		});
		btResult.setFont(new Font("맑은 고딕", Font.PLAIN, 10));
		btResult.setBackground(Color.DARK_GRAY);
		btResult.setForeground(Color.GREEN);
		btResult.setBorderPainted(true);
		btResult.setBounds(230, 230, 50, 65);
		contentPane.add(btResult);
		btMC.setBackground(Color.CYAN);
		btMC.setBorderPainted(false);
		btMR.setBackground(Color.CYAN);
		btMR.setBorderPainted(false);
		btMS.setBackground(Color.CYAN);
		btMS.setBorderPainted(false);
		btMP.setBackground(Color.CYAN);
		btMP.setBorderPainted(false);
		btMM.setBackground(Color.CYAN);
		btMM.setBorderPainted(false);
		btBack.setBackground(Color.CYAN);
		btBack.setBorderPainted(false);
		btCE.setBackground(Color.CYAN);
		btCE.setBorderPainted(false);
		btC.setBackground(Color.CYAN);
		btC.setBorderPainted(false);
		btPM.setBackground(Color.CYAN);
		btPM.setBorderPainted(false);
		btRoot.setBackground(Color.CYAN);
		btRoot.setBorderPainted(false);
		btDevide.setBackground(Color.CYAN);
		btDevide.setBorderPainted(false);
		btMultiple.setBackground(Color.CYAN);
		btMultiple.setBorderPainted(false);
		btMinus.setBackground(Color.CYAN);
		btMinus.setBorderPainted(false);
		bt1x.setBackground(Color.CYAN);
		bt1x.setBorderPainted(false);
		btPercent.setBackground(Color.CYAN);
		btPercent.setBorderPainted(false);
		btResult.setBackground(Color.DARK_GRAY);
		btResult.setForeground(Color.GREEN);
		btResult.setBorderPainted(true);


	}
	
	protected void do_bt0_actionPerformed	(ActionEvent e)	{if (!resultLabel.getText().equals("0"))	
															{keyInput("0");}}
	protected void do_bt1_actionPerformed	(ActionEvent e)	{keyInput("1");}
	protected void do_bt2_actionPerformed	(ActionEvent e)	{keyInput("2");}
	protected void do_bt3_actionPerformed	(ActionEvent e)	{keyInput("3");}
	protected void do_bt4_actionPerformed	(ActionEvent e)	{keyInput("4");}
	protected void do_bt5_actionPerformed	(ActionEvent e)	{keyInput("5");}
	protected void do_bt6_actionPerformed	(ActionEvent e)	{keyInput("6");}
	protected void do_bt7_actionPerformed	(ActionEvent e)	{keyInput("7");}
	protected void do_bt8_actionPerformed	(ActionEvent e)	{keyInput("8");}
	protected void do_bt9_actionPerformed	(ActionEvent e)	{keyInput("9");}
	protected void do_btDot_actionPerformed	(ActionEvent e)	{if (!resultLabel.getText().contains(".")){	
																resultLabel.setText(resultLabel.getText() + ".");}}
	
	

	protected void do_btPlus_actionPerformed	(ActionEvent e)	{preOp("+");}
	protected void do_btMinus_actionPerformed	(ActionEvent e)	{preOp("-");}
	protected void do_btMultiple_actionPerformed(ActionEvent e)	{preOp("*");}
	protected void do_btDevide_actionPerformed	(ActionEvent e) {preOp("/");}
	protected void do_btResult_actionPerformed	(ActionEvent e) {operator(oper);}
	protected void do_btRoot_actionPerformed	(ActionEvent e) {if (!resultLabel.getText().equals("0")) {
																	resultLabel.setText(Math.sqrt(Double.parseDouble(resultLabel.getText())) + "");
																	dottest();}}
	
	

	protected void preOp (String S) {
			if (textClean == "" && oper != "") {
				if (oper == S) {
					operator(S);
				}
				else {
					operator(oper);
				}
			}
		textClean = S;
		oper = S;
		firstValue = Double.parseDouble(resultLabel.getText());
		check = false;
	}
	
	

	protected void operator (String op) {
		
		if (check == false)	{
			secondValue = Double.parseDouble(resultLabel.getText());
		} 
		
		Calculator calc = new Calculator();
		resultValue = calc.doCal(firstValue, secondValue, op);
		
		
		resultLabel.setText(resultValue + "");
		dottest();
		firstValue = resultValue;
		check = true;
	}
	
	

	public void keyInput(String key)	{
		if (resultLabel.getText().equals("0") || textClean != "")	{
			resultLabel.setText("");
			textClean = "";
		}
		resultLabel.setText(resultLabel.getText() + key);
	}
	

	protected void dottest() {
		int t = resultLabel.getText().length();
		if (resultLabel.getText().substring(t-2).equals(".0")) {
			resultLabel.setText(resultLabel.getText().substring(0, t-2));
		}
	}
	
	

	protected void do_btBack_actionPerformed(ActionEvent e) {
		int resultLabelLength = resultLabel.getText().length();
			if (resultLabelLength == 1) {	
				resultLabel.setText("0");
			} else {
				resultLabel.setText(resultLabel.getText().substring(0, resultLabelLength-1));		
			}
	}
	
	
	protected void do_btC_actionPerformed(ActionEvent e) {
		resultLabel.setText("0");;
		oper = "";
		firstValue = 0;
		secondValue = 0;
		resultValue = 0;
		check = false;
		alreadyClick = false;
		textClean = "";
		topLabel.setText("");
	}
	
	

	protected void do_btPM_actionPerformed(ActionEvent e) {
		double temp = Double.parseDouble(resultLabel.getText());
		if (temp != 0) {resultLabel.setText(-temp+"");
						dottest();}
	}

	

	protected void do_btCE_actionPerformed(ActionEvent e) {
		resultLabel.setText("0");
	}
	
}
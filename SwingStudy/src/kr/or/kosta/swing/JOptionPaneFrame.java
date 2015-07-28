package kr.or.kosta.swing;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import kr.or.kosta.swing.util.GuiUtil;

public class JOptionPaneFrame extends JFrame {
	JButton messageButton, confirmButton, inputButton, optionButton;
	
	public enum Days{
		월요일, 화요일, 수요일, 목요일, 금요일, 토요일, 일요일
	}
	
	public JOptionPaneFrame() {
		this("스윙컴포넌트들...");
	}

	public JOptionPaneFrame(String title) {
		super(title);
		messageButton = new JButton("메시지창");
		confirmButton = new JButton("확인창");
		inputButton = new JButton("입력창");
		optionButton = new JButton("옵션창");
		
	}


	public void setComponents() {
		setLayout(new FlowLayout());
		add(messageButton);
		add(confirmButton);
		add(inputButton);
		add(optionButton);
	}

	public void exit() {
		setVisible(false);
		dispose();
		System.exit(0);
	}
	
	public void showMessageDialog(){
//		JOptionPane.showMessageDialog(this, "서일대 집에가~~~~");
		JOptionPane.showMessageDialog(this, "스윙 참 쉽죠..","공지사항", JOptionPane.ERROR_MESSAGE);
	}
	
	public void showConfirmDialog(){
//		int answer = JOptionPane.showConfirmDialog(this, "승우야 밥 먹었냐?");
//		int answer = JOptionPane.showConfirmDialog(this, "승우야 밥 먹었냐?", "물어봅니다", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		int answer = JOptionPane.showConfirmDialog(this, "승우야 밥 먹었냐?", "물어봅니다", JOptionPane.YES_NO_OPTION, 0, new ImageIcon("classes/images/icons4680.png"));
		switch (answer) {
			case JOptionPane.OK_OPTION:
				System.out.println("집에가");			
				break;
			case JOptionPane.NO_OPTION:
				System.out.println("집에가지마");			
				break;
			default:
				System.out.println("쌩까냐?");	
		}
	}
	
	public void inputDialog(){
//		String food = JOptionPane.showInputDialog(this, "뭐 먹었냐?");
		
//		String[] foods = {"보신탕", "냉면", "곱창", "김치볶음밥"};
//		String food = (String)JOptionPane.showInputDialog(this, "좋아하는 음식", "음식종류", JOptionPane.QUESTION_MESSAGE, null, foods, foods[0]);
		
		Days food = (Days) JOptionPane.showInputDialog(this, "좋아하는 요일은?", "Poll", JOptionPane.QUESTION_MESSAGE, null, Days.values(), Days.values()[6]);
		//System.out.println(food + "먹었구나~~~~");
	}
	
	public void optionDialog(){
		// 버튼 라벨 변경 가능
		String[] buttons = {"로그인", "회원가입", "취소"};
		int answer = JOptionPane.showOptionDialog(this, "어디로 이동할까요", "타이틀", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, buttons, buttons[0]);
	}

	public void eventRegist() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				exit();
			}
		});
		
		messageButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				showMessageDialog();
			}
		});
		
		confirmButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				showConfirmDialog();
			}
		});
		
		inputButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				inputDialog();
			}
		});
		
		optionButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				optionDialog();
			}
		});
	}

	public static void main(String[] args) {
		JOptionPaneFrame frame = new JOptionPaneFrame();
		frame.setComponents();
		frame.setSize(500, 300);
		GuiUtil.setLookNFeel(frame, GuiUtil.THEME_NIMBUS);
		frame.setVisible(true);
		frame.eventRegist();
	}
}







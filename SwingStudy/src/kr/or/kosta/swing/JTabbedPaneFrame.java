package kr.or.kosta.swing;

import java.awt.BorderLayout;
import java.awt.Label;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;

public class JTabbedPaneFrame extends JFrame {
	JTabbedPane tabPane;
	
	public JTabbedPaneFrame() {
		this("스윙컴포넌트들...");
	}

	public JTabbedPaneFrame(String title) {
		super(title);
		tabPane = new JTabbedPane();
//		tabPane = new JTabbedPane(JTabbedPane.BOTTOM);
		tabPane.addTab("계좌등록", new RegistPanel());
		tabPane.addTab("계좌목록", createImageIcon("classes/images/add_index.gif"), new JLabel("계좌목록 화면입니다.."));
		tabPane.addTab("계좌검색", createImageIcon("classes/images/add_index.gif"), new JLabel("계좌검색 화면입니다.."));
		tabPane.addTab("계좌삭제", createImageIcon("classes/images/add_index.gif"), new JLabel("계좌삭제 화면입니다.."));
	}

	public void setComponents() {
		add(tabPane, BorderLayout.CENTER);
	}
	
	private Icon createImageIcon(String path) {
		return new ImageIcon(path);
	}

	public void exit() {
		setVisible(false);
		dispose();
		System.exit(0);
	}

	public void eventRegist() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				exit();
			}
		});
	}

	public static void main(String[] args) {
		JTabbedPaneFrame frame = new JTabbedPaneFrame();
		frame.setComponents();
		frame.setSize(800, 600);
		frame.setVisible(true);
		frame.eventRegist();
	}
}







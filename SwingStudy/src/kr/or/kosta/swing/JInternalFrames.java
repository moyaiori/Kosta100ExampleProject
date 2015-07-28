package kr.or.kosta.swing;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;

public class JInternalFrames extends JFrame {
	
	JDesktopPane desktopPanel;
	JInternalFrame jif, jif2;
	MyInternalFrame mif;
	
	public JInternalFrames() {
		this("스윙컴포넌트들...");
	}

	public JInternalFrames(String title) {
		super(title);
		desktopPanel = new JDesktopPane();
	}

	public void setComponents() {
		// 현재 프레임의 패널 교체
		setContentPane(desktopPanel);
		//jif = new JInternalFrame("내부프레임");
		jif = new JInternalFrame("내부프레임", true, true, true,true);
		jif.setSize(400, 400);
		jif.setVisible(true);
		
		jif2 = new JInternalFrame("내부프레임2", true, true, true, true);
		//jif2.setSize(200, 200);
		jif2.setBounds(300, 100, 200, 200);
		jif2.setVisible(true);
		                                                                                                                
		mif = new MyInternalFrame("사용자정의내부프레임");
		mif.setBounds(100, 100, 300, 300);
		mif.setVisible(true);
		
		add(jif);
		add(jif2);
		add(mif);
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
		JInternalFrames frame = new JInternalFrames();
		frame.setComponents();
		frame.setSize(600, 500);;
		frame.setVisible(true);
		frame.eventRegist();
	}
}

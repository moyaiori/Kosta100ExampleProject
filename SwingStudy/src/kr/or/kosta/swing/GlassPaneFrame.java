package kr.or.kosta.swing;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class GlassPaneFrame extends JFrame {
	
	JTextArea ta;
	JPanel glassPane;
	public GlassPaneFrame() {
		this("스윙컴포넌트들...");
	}

	public GlassPaneFrame(String title) {
		super(title);
		ta = new JTextArea();
		
	}

	public void setComponents() {
		JPanel glassPane = (JPanel) getGlassPane();
		glassPane.setVisible(true);
		glassPane.add(new JButton("클릭하세요"));
		add(new JScrollPane(ta), BorderLayout.CENTER);
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
		GlassPaneFrame frame = new GlassPaneFrame();
		frame.setComponents();
		frame.setSize(600, 500);
		frame.setVisible(true);
		frame.eventRegist();
	}
}


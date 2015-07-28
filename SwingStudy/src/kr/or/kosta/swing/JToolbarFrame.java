package kr.or.kosta.swing;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import kr.or.kosta.swing.util.GuiUtil;

public class JToolbarFrame extends JFrame {
	
	JPanel toolBarPanel;
	
	JToolBar toolBar;
	JButton button1, button2;
	JComboBox<String> combo;

	public JToolbarFrame() {
		this("스윙컴포넌트들...");
	}

	public JToolbarFrame(String title) {
		super(title);
		
		toolBarPanel = new JPanel();
		
		toolBar = new JToolBar();
		button1 = new JButton(createImageIcon("classes/images/back.gif"));
		button2 = new JButton(createImageIcon("classes/images/add_index.gif"));
		
		String[] elements = {"클래스", "인터페이스", "열거형"};
		combo = new JComboBox<String>(elements);
		
		toolBarPanel.add(toolBar);
	}

	public void setComponents() {
		toolBarPanel.setLayout(new FlowLayout(new FlowLayout().LEFT));
		toolBar.add(button1);
		toolBar.addSeparator();
		toolBar.add(button2);
		toolBar.add(combo);
		
		add(toolBarPanel, BorderLayout.NORTH);
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
		JToolbarFrame frame = new JToolbarFrame();
		frame.setComponents();
		frame.setSize(500, 300);
		GuiUtil.setLookNFeel(frame, GuiUtil.THEME_NIMBUS);
		frame.setVisible(true);
		frame.eventRegist();
	}
}







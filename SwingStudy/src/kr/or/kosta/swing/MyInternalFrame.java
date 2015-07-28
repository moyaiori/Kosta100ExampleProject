package kr.or.kosta.swing;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;

// 사용자 정의 인터널프레임
public class MyInternalFrame extends JInternalFrame {
	JButton button;
	JTextArea textArea;
	public MyInternalFrame(){
		this("제목없음");
	}
	public MyInternalFrame(String title){
		super(title, true, true, true, true);
		button = new JButton("임시버튼");
		textArea = new JTextArea();
		add(button, BorderLayout.NORTH);
		add(new JScrollPane(textArea), BorderLayout.CENTER);
	}

}







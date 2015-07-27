import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * 스윙의 기본 컴포넌트들
 * AWT에도 존재하는 컴포넌트들...
 * @author Lee Gwangyong
 *
 */
public class BasicComponentExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame.setDefaultLookAndFeelDecorated(true); // 테마
		JFrame frame = new JFrame("스윙의 기본 컴포넌트들");
		

		Button awtBtn = new Button("AWT 버튼");
		JButton jBtn = new JButton("Swing 버튼");
		
		frame.add(awtBtn);
		frame.add(jBtn);
		
		frame.setSize(800,  600);
		frame.setLayout(new FlowLayout(FlowLayout.LEFT));
		frame.setVisible(true);
		
		
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

}

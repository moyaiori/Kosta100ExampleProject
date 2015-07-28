package kr.or.kosta.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *  사용자 정의 패널
 * @author 김기정
 *
 */
public class RegistPanel extends JPanel {
	JLabel accountNumL;
	JTextField accountNumTF;
	
	public RegistPanel(){
		accountNumL = new JLabel("계좌번호");
		accountNumTF = new JTextField(20);
		setContents();
		eventRegist();
	}
	
	public void setContents(){
		add(accountNumL);
		add(accountNumTF);
	}
	
	public void eventRegist(){
		accountNumTF.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("감사합니다...");
			}
		});
	}
}

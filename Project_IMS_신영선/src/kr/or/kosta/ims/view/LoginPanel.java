package kr.or.kosta.ims.view;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
/**
 * 로그인 페이지 패널
 * @author 신영선
 *
 */

public class LoginPanel extends JPanel{
	
	JLabel idLabel, passwdLabel;
	JTextField idTF;
	JPasswordField passwdF;
	JButton loginB, registB;

	GridBagLayout gridBagLayout;
	GridBagConstraints gridBagConstraints;
	Image img;
	
	public LoginPanel(){
		
		idLabel = new JLabel("아이디");
		passwdLabel = new JLabel("비밀번호");
		idTF = new JTextField();
		passwdF = new JPasswordField();
		loginB = new JButton("로그인");
		registB = new JButton("관리자 등록");
		
		gridBagLayout = new GridBagLayout();
		gridBagConstraints = new GridBagConstraints();
		
		setComponents();
		eventRegist();
		
	}
	
	/**컴포넌트 붙이기*/
	public void setComponents(){
		setLayout(gridBagLayout);
		
		gridBagConstraints.fill = GridBagConstraints.BOTH;
		gridBagConstraints.insets = new Insets(3, 3, 3, 3);
		
		add(new JLabel(""), 0, 1, 1, 1, 1.0, 0.0);
		add(idLabel,     1, 1, 1, 1, 0.0, 0.0);
		add(idTF,        2, 1, 2, 1, 0.0, 0.0);
		add(new JLabel(""), 4, 1, 1, 1, 1.0, 0.0);
		
		add(passwdLabel, 1, 2, 1, 1, 0.0, 0.0);
		add(passwdF,     2, 2, 2, 1, 0.0, 0.0);
		add(loginB,      1, 3, 1, 1, 0.0, 0.0);
		add(registB,     2, 3, 2, 1, 0.0, 0.0);
	}

	public void add(Component component, int gridx, int gridy, int gridwidth, int gridheight, double weightx, double weighty){
		gridBagConstraints.gridx = gridx;
		gridBagConstraints.gridy = gridy;
		gridBagConstraints.gridwidth = gridwidth;
		gridBagConstraints.gridheight = gridheight;
		gridBagConstraints.weightx = weightx;
		gridBagConstraints.weighty = weighty;
		gridBagLayout.setConstraints(component, gridBagConstraints);
		add(component);
	}
	
	public void caution(){
		JOptionPane.showMessageDialog(this, "관리자만 사용 가능","경고", JOptionPane.NO_OPTION);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		URL url = getClass().getResource("/images/guitar1.jpg");
		img = Toolkit.getDefaultToolkit().getImage(url); 	
		g.drawImage(img, 0, 0, getWidth(), getHeight(),this);
	}
	
	public void eventRegist(){
		registB.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent e) {
				caution();
				
			}
		});
	}
	
}

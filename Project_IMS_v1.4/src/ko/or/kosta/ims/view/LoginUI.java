package ko.or.kosta.ims.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * 로그인 화면
 * 
 * @author Lee Gwangyong
 *
 */
public class LoginUI extends JPanel{

	JPanel panel;
	JTextField idTF;
	JPasswordField passTF;
	JLabel idL, passL, idAndPass;
	JButton loginBtn, signUpBtn;
	
	GridBagConstraints gc;
	GridBagLayout gl;
	
	Image bgImage;


	public LoginUI() {

		idTF = new JTextField();
		passTF = new JPasswordField();
		idL = new JLabel("아이디");
		passL = new JLabel("비밀번호");
		loginBtn = new JButton("로그인");
		signUpBtn = new JButton("관리자 등록");

		gc = new GridBagConstraints();
		gl = new GridBagLayout();
		
		URL url = getClass().getResource("/images/mainbg.jpg");
		bgImage = Toolkit.getDefaultToolkit().getImage(url);
		
		setComponents();

	}
	
	/**
	 * 화면 배치
	 */
	public void setComponents() {
		setLayout(gl);
		gc.fill = GridBagConstraints.HORIZONTAL;

		addGrid(gl, gc, new JLabel("  "), 	0, 0, 1, 1, 0.2, 0.0);
		addGrid(gl, gc, idL,				1, 0, 1, 1, 0.2, 0.0);
		addGrid(gl, gc, idTF, 				2, 0, 1, 1, 0.5, 0.0);
		addGrid(gl, gc, new JLabel("  "),   3, 0, 1, 1, 0.1, 0.0);
		addGrid(gl, gc, new JLabel("  "), 	0, 1, 1, 1, 0.2, 0.0);
		addGrid(gl, gc, passL,				1, 1, 1, 1, 0.2, 0.0);
		addGrid(gl, gc, passTF, 			2, 1, 1, 1, 0.5, 0.0);
		addGrid(gl, gc, new JLabel("  "),   3, 1, 1, 1, 0.1, 0.0);
		addGrid(gl, gc, new JLabel("  "),   3, 2, 4, 1, 0.1, 0.0);
		addGrid(gl, gc, new JLabel("  "), 	0, 3, 1, 1, 0.2, 0.0);
		addGrid(gl, gc, loginBtn,			1, 3, 1, 1, 0.2, 0.0);
		addGrid(gl, gc, signUpBtn, 			2, 3, 1, 1, 0.5, 0.0);
		addGrid(gl, gc, new JLabel("  "),   3, 3, 1, 1, 0.1, 0.0);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(bgImage, 0, 0, getWidth(), getHeight() , this);
	}
	

	private void addGrid(GridBagLayout gbl, GridBagConstraints gbc, Component c, int gridx, int gridy, int gridwidth,
			int gridheight, double weightx, double weighty) {
		gbc.gridx = gridx;
		gbc.gridy = gridy;
		gbc.gridwidth = gridwidth;
		gbc.gridheight = gridheight;
		gbc.weightx = weightx;
		gbc.weighty = weighty;
		gbl.setConstraints(c, gbc);
		add(c);
	}

}

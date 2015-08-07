package kr.or.kosta.ims.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import kr.or.kosta.ims.util.GUIUtil;
import kr.or.kosta.ims.util.Validate;

/**
 * 로그인 화면을 나타내는 패널
 * 
 * @author 손진영
 *
 *         작성일 : 2015-08-03
 */
public class LoginPanel extends JPanel {
	/** 화면 구성에 들어가는 컴포넌트 */
	private JLabel idL, passwdL;
	private JTextField idTF;
	private JPasswordField passwdTF;
	private JButton loginB, addAdminB;

	private GridBagLayout grid;
	private GridBagConstraints constraints;
	
	/** 배경으로 들어갈 이미지 */
	Image image;

	/** 화면 변경을 위한 로그인 프레임과 메인프레임 */
	LoginFrame frame;
	InstrumentManagerFrame mainF;

	/** 패널 생성자 */
	public LoginPanel(LoginFrame frame) {
		idL = new JLabel("아이디", Label.LEFT);
		idTF = new JTextField();

		passwdL = new JLabel("비밀번호", Label.LEFT);
		passwdTF = new JPasswordField();

		loginB = new JButton("로그인");
		addAdminB = new JButton("관리자 등록");

		grid = new GridBagLayout();
		constraints = new GridBagConstraints();

		mainF = new InstrumentManagerFrame("악기 개조 관리 시스템 - 메인화면");

		/** 이미지 리소스 받기 */
		URL url = getClass().getResource("/images/instrument.png");
		image = Toolkit.getDefaultToolkit().getImage(url);
		
		this.frame = frame;

		setComponents();
	}

	/** 컴포넌트를 패널에 부착 */
	public void setComponents() {
		setLayout(grid);
		constraints.fill = GridBagConstraints.BOTH;
		constraints.insets = new Insets(5, 5, 5, 5);
		
		add(idL,             1, 1, 1, 1, 0.0, 0.0);
		add(idTF,            2, 1, 2, 1, 0.0, 0.0);
		add(passwdL,         1, 2, 1, 1, 0.0, 0.0);
		add(passwdTF,        2, 2, 2, 1, 0.0, 0.0);
		add(loginB,          1, 3, 1, 1, 0.0, 0.0);
		add(addAdminB,       2, 3, 1, 1, 0.0, 0.0);
		add(new JLabel(" "), 3, 3, 1, 1, 0.0, 0.0);
	}

	/** GridBagLayout에 맞게 설정 */
	public void add(JComponent comp, int x, int y, int w, int h, double wx, double wy) {
		constraints.weightx = wx;
		constraints.weighty = wy;

		constraints.gridx = x;
		constraints.gridy = y;
		constraints.gridwidth = w;
		constraints.gridheight = h;

		grid.setConstraints(comp, constraints);
		add(comp);
	}

	/** 이벤트 처리 */
	public void eventRegist() {
		loginB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame();
			}
		});

		addAdminB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				showMessage("관리자 등록", "관리자 등록입니다.");
			}
		});

		idTF.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame();
			}
		});
		
		passwdTF.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame();
			}
		});
	}

	/** SWING에서는 패널에서 paintComponent를 해줘야한다. */
	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
	}

	/** 메인 화면으로 화면 넘기기 */
	public void mainFrame() {
		String id = idTF.getText();
		char[] pass = passwdTF.getPassword();
		String passwd = "";
		for (char c : pass) {
			passwd += c;
		}
		/** 아이디와 패스워드에 입력이 없을 경우 */
		if (Validate.isNull(id) || Validate.isNull(passwd)) {
			showErrorMessage("로그인 실패", "아이디와 비밀번호를 입력하여주세요.");
			return;
		}
		/** 하나의 관리자 계정만 로그인 가능 */
		if(!id.equals("kosta") || !passwd.equals("1111")){
			showErrorMessage("로그인 실패", "아이디와 비밀번호가 틀립니다.");
			return;
		}
		mainF.setSize(700, 500);
		mainF.setComponents();
		GUIUtil.setCenterScreen(mainF);
		GUIUtil.setLookNFeel(mainF, GUIUtil.THEME_NIMBUS);
		mainF.setVisible(true);
		mainF.eventRegist();
		frame.setVisible(false);
		frame.dispose();
	}

	/** 메시지 창 띄우기 */
	public void showMessage(String title, String message) {
		JOptionPane.showMessageDialog(this, message, title, JOptionPane.PLAIN_MESSAGE);
	}
	
	/** 에러 메시지 창 띄우기 */
	public void showErrorMessage(String title, String message) {
		JOptionPane.showMessageDialog(this, message, title, JOptionPane.WARNING_MESSAGE);
	}
}

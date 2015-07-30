import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;
import java.net.URL;

import javax.swing.ImageIcon;

/**
 * 메인화면에 사용할 그래픽 배경히 있는 패널
 * @author Lee Gwangyong
 *
 */
public class LoginPanel extends Panel {
	
	Button loginB;	
	Image image;
	public LoginPanel() {
		// TODO Auto-generated constructor stub
		loginB = new Button("login");
		URL url = getClass().getResource("/images/다운로드.jpg");
		image = Toolkit.getDefaultToolkit().getImage(url);
//		image = new ImageIcon(url).getImage();
	}
	
	public void setComponents(){
		add(loginB);
	}
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(image, 0, 0, getWidth(), getHeight() , this);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Frame frame = new Frame();
		LoginPanel imagePanel = new LoginPanel();
		imagePanel.setComponents();
		frame.add(imagePanel, BorderLayout.CENTER);
		frame.setSize(500, 400);
		frame.setVisible(true);
	}

}

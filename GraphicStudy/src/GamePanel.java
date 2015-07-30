import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

/**
 * 화면 갱신 관련 처리
 * @author Lee Gwangyong
 *
 */
public class GamePanel extends Panel {
	
	Panel southP, btnP;
	Button upB, downB, leftB, rightB;
	
	Image image;
	int x, y;
	
	public GamePanel() {
		URL url = getClass().getResource("/images/다운로드.jpg");
		image = Toolkit.getDefaultToolkit().getImage(url);
		
		southP = new Panel();
		btnP = new Panel();
		
		upB = new Button("▲");
		downB = new Button("▼");
		leftB = new Button("◀");
		rightB = new Button("▶");
		
	}
	
	public void directionControl(int keyCode){
		
		switch (keyCode) {
		case KeyEvent.VK_UP: 	y -= 10; 	break;
		case KeyEvent.VK_DOWN: 	y += 10;	break;
		case KeyEvent.VK_LEFT:	x -= 10;	break;
		case KeyEvent.VK_RIGHT: x += 10;	break;
		}

		repaint();
	}
	
	public void eventRegist(){
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				x = e.getX();
				y = e.getY();
				repaint();
			}
		});
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				directionControl(e.getKeyCode());
			}
		});
		
		upB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				directionControl(KeyEvent.VK_UP);
			}
		});

		
		downB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				directionControl(KeyEvent.VK_DOWN);
				
			}
		});

		
		rightB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				directionControl(KeyEvent.VK_RIGHT);
				
			}
		});

		
		leftB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				directionControl(KeyEvent.VK_LEFT);
				
			}
		});
		
		
	}
	
	public void setComponent(){
		setLayout(new BorderLayout());
		add(southP, BorderLayout.SOUTH);
		
		southP.setLayout(new BorderLayout());
		southP.add(upB, BorderLayout.NORTH);
		southP.add(downB, BorderLayout.CENTER);
		southP.add(rightB, BorderLayout.EAST);
		southP.add(leftB, BorderLayout.WEST);
	}
	
	/*
	@Override
	public void update(Graphics g) {
		// TODO Auto-generated method stub
//		super.update(g);
		paint(g);
	}*/
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(image, x, y, this);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Frame frame = new Frame();
		GamePanel panel = new GamePanel();
		
		frame.add(panel, BorderLayout.CENTER);
		panel.setComponent();
		frame.setSize(500, 400);
		frame.setVisible(true);
		panel.eventRegist();
		
		panel.setFocusable(true);
		panel.requestFocusInWindow();
	}
	
	
	
	

}

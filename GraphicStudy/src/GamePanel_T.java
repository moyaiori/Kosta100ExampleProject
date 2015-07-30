import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

import javax.swing.ImageIcon;

/**
 * 화면 갱신 관련 처리
 * @author 김기정
 *
 */
public class GamePanel extends Panel {
	
	Image image;
	int x, y;
	
	int distance = 10;
	
	public enum Direction{
		LEFT, RIGHT, UP, DOWN;
	}
	
	
	public GamePanel() {
		URL url = getClass().getResource("/images/icons4681.png");
		image = Toolkit.getDefaultToolkit().getImage(url);
	}
	
	public void move(Direction direction){
		switch (direction) {
			case LEFT:
				x -= distance;			
				break;
			case RIGHT:
				x += distance;			
				break;
			case UP:
				y -= distance;			
				break;
			case DOWN:
				y += distance;			
				break;
		}
		repaint();
	}
	
	public void eventRegist(){
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				x = e.getX();
				y = e.getY();
				repaint();
			}
			
		});
	}
	
	/*
	@Override
	public void update(Graphics g) {
		paint(g);
	}
	*/
	
	@Override
	public void paint(Graphics g) {
		g.drawImage(image, x, y, this);
	}
}

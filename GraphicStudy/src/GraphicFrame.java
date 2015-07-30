import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.nio.Buffer;

public class GraphicFrame extends Frame {
	
	Button button;
	
	public GraphicFrame() {
		// TODO Auto-generated constructor stub
		button = new Button("My Graphic Button"){
			@Override
			public void paint(Graphics g) {
				g.setColor(Color.red);
				g.drawRect(2, 2, getWidth() - 4, getHeight() - 4);
			}
		};
		add(button, BorderLayout.CENTER);
	}
	
	
	
	/*
	 * 모든 컴포넌트가 처음 화면에 보여질 때, 리사이징될 때,
	 * 활성화/비활성화 될 때 JVM에 자동으로 호출되는 그래픽 처리 콜백메소드
	 * (java.awt.Component 클래스에 정의)로 사용자가 그래픽을 처리하고자 
	 * 할 경우 paint(Graphics g)를 오버라이딩 한다.
	 * 전달인자로 주어지는 Graphics는 그래픽 처리에 필요한 그리기 도구 제공(붓 역할)
	 */
	
	@Override
	public void paint(Graphics g){
		//super.paint(g)
		//개발자가 원하는 그래픽 처리...
		System.out.println("paint(Graphics g) 자동 호출됨");
		g.setColor(Color.red);
		g.drawLine(10, 10, 200, 200);
		
		Font font1 = new Font("Serif", Font.BOLD, 12);
		Font font2 = new Font("Batang", Font.ITALIC + Font.BOLD, 24);
		Font font3 = new Font("SansSerif", Font.PLAIN, 14);
		g.setFont(font1);
		g.setColor(Color.red);
		g.drawString("Serif 12 point bold.", 20, 100);
		g.setFont(font2);
		g.setColor(Color.green);
		g.drawString("바탕 24 point italic.", 20, 65);
		g.setFont(font3);
		g.setColor(Color.blue);
		g.drawString("SansSerif 14 point plain.", 20, 80);

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GraphicFrame frame = new GraphicFrame();
		frame.setSize(500, 400);
		frame.setVisible(true);
	}

}

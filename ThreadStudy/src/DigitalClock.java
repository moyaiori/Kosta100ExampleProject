

import java.awt.Canvas;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;


public class DigitalClock extends JFrame implements Runnable{
	
	JLabel time;
	DigitalClockCanvas canvas;
	
	public DigitalClock() {
		this("스레드를 이용한 디지털시계");
	}

	public DigitalClock(String title) {
		super(title);
		
		time = new JLabel("");
		canvas = new DigitalClockCanvas();
		Thread thread = new Thread(DigitalClock.this);
		thread.start();

		setComponents();
	}

	public void setComponents() {
		add(canvas);
	}
	
	
	public void exit() {
		setVisible(false);
		dispose();
		System.exit(0);
	}

	public void eventRegist() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				exit();
			}
		});
	}

	@Override
	public void run() {
		
		while(true){
			try {
				Thread.sleep(1000);
				canvas.repaint();
				System.out.println("run");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public class DigitalClockCanvas extends Canvas{

		Font font;
		
		public DigitalClockCanvas(){
		}
		
		@Override
		public void paint(Graphics g) {
			Calendar time = Calendar.getInstance();
			String now = String.format("%1$tF %1$tT", time);
			Font font = new Font("Serif", Font.BOLD, 50);
			Font font2 = new Font("Batang",  Font.BOLD, 30);
			System.out.println("paint");
			g.setFont(font);
			g.drawString(now, 50, 170);
		}
	}
	
	
	

	public static void main(String[] args) {
		DigitalClock frame = new DigitalClock();
		frame.setComponents();
		frame.setSize(500, 300);
		frame.setVisible(true);
		frame.eventRegist();
	}


	
}







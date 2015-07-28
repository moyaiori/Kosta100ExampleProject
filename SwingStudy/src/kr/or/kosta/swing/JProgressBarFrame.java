package kr.or.kosta.swing;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.JSlider;
import javax.swing.JSpinner;

import kr.or.kosta.swing.util.GuiUtil;

public class JProgressBarFrame extends JFrame {
	JProgressBar pb;
	JSlider slier;
	JSpinner spinner;
	
	public JProgressBarFrame() {
		this("스윙컴포넌트들...");
	}

	public JProgressBarFrame(String title) {
		super(title);
		//pb = new JProgressBar(JProgressBar.HORIZONTAL, 0, 100);
		pb = new JProgressBar(0, 100);
		pb.setValue(50);
		pb.setForeground(Color.cyan);
		pb.setStringPainted(true);
		
		slier = new JSlider(0, 100, 50);
		slier.setPaintTicks(true);
		slier.setPaintLabels(true);
		slier.setMajorTickSpacing(100);
		slier.setMinorTickSpacing(10);
		
		spinner = new JSpinner();
	}
	
	public void progress(){
		for(int i=0; i<=100; i++){
			pb.setValue(i);
			pb.setString(i+"% 진행중");
			if(i==100){
				pb.setString("복사완료");
			}
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void setComponents() {
		setLayout(new FlowLayout());
		add(pb);
		add(slier);
		add(spinner);
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

	public static void main(String[] args) {
		JProgressBarFrame frame = new JProgressBarFrame();
		frame.setComponents();
		frame.setSize(400, 300);
		GuiUtil.setLookNFeel(frame, GuiUtil.THEME_NIMBUS);
		frame.setVisible(true);
		frame.eventRegist();
		frame.progress();
	}
}







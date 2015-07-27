import java.awt.Color;
import java.awt.FlowLayout;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class BasicComponentJFrame extends JFrame {
	
	JButton btn1, iconBtn, lableBtn;
	JToggleButton toggleBtn;
	Icon icon, bannerIcon;
	JLabel bannerL;
	
	JButton borderBtn;
	
	JPanel panel;
	
	public BasicComponentJFrame(){
		this("스윙 기본 컴포넌트들...");
	}
	
	public BasicComponentJFrame(String title){
		super(title);
		btn1 = new JButton("스윙버튼");
		
		icon = new ImageIcon("classes/images/icons4680.png");
		iconBtn = new JButton(icon);
		
		lableBtn = new JButton("텍스트 버튼", icon);
		
		lableBtn.setVerticalTextPosition(JButton.BOTTOM);
		lableBtn.setHorizontalTextPosition(JButton.CENTER);
		
		URL imageUrl = null;
		try {
			imageUrl = new URL("http://www.kosta.or.kr/resources/images/common/logo.gif");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bannerIcon = new ImageIcon(imageUrl);
		bannerL = new JLabel(bannerIcon);
		
		toggleBtn = new JToggleButton("토글버튼");
		
		borderBtn = new JButton("보더 설정하기");
		
//		Border border = new BevelBorder(BevelBorder.RAISED);
//		Border border = new EtchedBorder(EtchedBorder.LOWERED);
		Border border = new LineBorder(Color.RED);
//		Border border = new TitledBorder();
		borderBtn.setBorder(border);
		
		panel = new JPanel();
		panel.add(new JButton("AAA"));
		panel.add(new JButton("BBB"));
		panel.add(new JButton("CCC"));
		panel.add(new JButton("DDD"));
		
		panel.setBorder(new TitledBorder("버튼 테스트"));
	}
	
	public void setComponents(){
		setLayout(new FlowLayout(FlowLayout.LEFT));
		add(btn1);
		add(iconBtn);
		add(lableBtn);
		add(bannerL);
		add(toggleBtn);
		add(borderBtn);
		add(panel);
	}
	
	public void eventReigst(){
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JFrame.setDefaultLookAndFeelDecorated(true);
		
		BasicComponentJFrame frame = new BasicComponentJFrame();
		frame.setSize(800, 600);
		
		frame.setComponents();
		frame.eventReigst();
		
		frame.setVisible(true);

	}

}

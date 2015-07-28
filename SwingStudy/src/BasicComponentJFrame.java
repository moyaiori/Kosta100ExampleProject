import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.KeyStroke;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import kr.or.kosta.swing.util.GuiUtil;

public class BasicComponentJFrame extends JFrame {
	
	JButton btn1, iconBtn, lableBtn;
	JToggleButton toggleBtn;
	Icon icon, bannerIcon;
	JLabel bannerL;
	
	JButton borderBtn;
	
	JPanel panel;
	
	
	// AWT에도 존재하느 비주얼 컴포넌트
	JCheckBox hobbys;
	JRadioButton manRB, womanRB;
	
	JToggleButton b;
	
	JList<String> list;
	
	JTextArea ta;
	
	JTextField tf;
	JPasswordField pf;
	JComboBox<String> combo;
	
	// 메뉴 컴포넌트
	JMenuBar menuBar;
	JMenu fileMenu;
	JMenuItem newMI, saveMI, exitMI;
	
	
	
	public BasicComponentJFrame(){
		this("스윙 기본 컴포넌트들...");
	}
	
	public BasicComponentJFrame(String title){
		super(title);
		btn1 = new JButton("스윙버튼");
		
		icon = new ImageIcon("classes/images/icons4680.png");
		iconBtn = new JButton(icon);
		
		lableBtn = new JButton("텍스트 버튼", icon);
		String html = "<html><body><font color='red'>버튼입니다.</body></html>";
		lableBtn.setToolTipText(html);
//		lableBtn.setToolTipText("버튼입니다.");
		
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
		
		hobbys = new JCheckBox("독서");
		
		ButtonGroup bg = new ButtonGroup();
		manRB = new JRadioButton("남자", true);
		womanRB = new JRadioButton("여자");
		bg.add(manRB);
		bg.add(womanRB);
		bg.add(b = new JToggleButton("중성"));
		
		String[] items = {"자바", "C", "C#", "C++", "코볼", "베이직", "베이직", "베이직", "베이직", "베이직"};
		list = new JList<String>(items);
		
		ta = new JTextArea(5, 20);
		
		tf = new JTextField(10);
		pf = new JPasswordField(10);
		pf.setEchoChar('★');
		Vector<String> vecter = new Vector<String>();
		vecter.addElement("라이온즈");
		vecter.addElement("두산 베어즈");
		vecter.addElement("NC 다이노즈");
		vecter.addElement("넥센 히어로즈");
		combo = new JComboBox<String>(vecter);
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
		add(hobbys);
		add(manRB);
		add(womanRB);
		add(b);
		
		// 뷰 포트
		JScrollPane sp = new JScrollPane(list);
		add(sp);
		add(new JScrollPane(ta));
		
		add(tf);
		add(pf);
		add(combo);

	}
	
	// 메뉴구성
	public void setMenus(){
		menuBar = new JMenuBar();
		fileMenu = new JMenu("파일");
		newMI = new JMenuItem("새파일", createImageIcon("classes/images/icons4680.png"));
		
		JMenu subMenu = new JMenu("새파일");
		subMenu.add(new JMenuItem("클래스"));
		subMenu.add(new JMenuItem("인터페이스"));
		subMenu.add(new JMenuItem("이넘"));
		
//		saveMI = new JMenuItem("저장", createImageIcon("classes/images/icons5063.png"));
		saveMI = new JMenuItem("저장");
//		saveMI.setMnemonic(KeyEvent.VK_S);
		saveMI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.ALT_MASK));
		exitMI = new JMenuItem("종료", createImageIcon("classes/images/icons5139.png"));
		
//		fileMenu.add(newMI);
		fileMenu.add(subMenu);
		fileMenu.addSeparator();
		fileMenu.add(saveMI);
		fileMenu.addSeparator();
		fileMenu.add(exitMI);
		
		menuBar.add(fileMenu);
		setJMenuBar(menuBar);
	}
	
	// 이미지 아이콘 생성 및 반환
	private Icon createImageIcon(String path){
		return new ImageIcon(path);
	}
	
	public void eventReigst(){
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		JFrame.setDefaultLookAndFeelDecorated(true);
		
		BasicComponentJFrame frame = new BasicComponentJFrame();
		frame.setSize(800, 600);
		
		frame.setComponents();
		GuiUtil.setLookNFeel(frame, GuiUtil.THEME_SWING);
		frame.setMenus();
		frame.eventReigst();
		
		frame.setVisible(true);

	}

}

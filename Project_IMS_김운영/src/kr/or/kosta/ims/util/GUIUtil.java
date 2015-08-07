package kr.or.kosta.ims.util;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JComponent;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 * GUI 관련 공통 유틸리티 메소드
 * @author 김운영
 *
 */
public class GUIUtil { //GUI 유틸을 클래스로 만들어 메소드 호출
	
	//화면중앙배치
	public static void setCenterScreen(Container container){
		Toolkit toolKit = Toolkit.getDefaultToolkit(); // 이건 얻어오는 클래스
		int x = (toolKit.getScreenSize().width - container.getWidth()) / 2;
		int y = (toolKit.getScreenSize().height - container.getHeight()) / 2;
		container.setLocation(x, y);
	}
	

	//화면 풀배치
	public static void setFullScreen(Container container){
		Toolkit toolKit = Toolkit.getDefaultToolkit(); // 이건 얻어오는 클래스
		container.setSize(toolKit.getScreenSize());
	}
	
	//상수처리
	public static final String THEME_SWING = "javax.swing.plaf.metal.MetalLookAndFeel";
	public static final String THEME_WINDOW = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
	public static final String THEME_LINUX = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";
	public static final String THEME_NIMBUS = "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel";
	public static final String THEME_OS = UIManager.getSystemLookAndFeelClassName();
	
	
	/**
	 * 룩앤필(Look&Feel) 설정
	 */
	public static void setLookNFeel(Container component, String className){ //제일 큰 프레임
	    
	    try {
            UIManager.setLookAndFeel(className);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
        SwingUtilities.updateComponentTreeUI(component);
	}
}

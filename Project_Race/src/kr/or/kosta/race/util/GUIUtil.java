package kr.or.kosta.race.util;

import java.awt.Container;
import java.awt.Toolkit;

import javax.swing.JComponent;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 * GUI 관련 공통 유틸리티 메소드
 * @author 김기정
 *
 */
public class GUIUtil {
	
	/**
	 * 화면 중앙 배치
	 */
	public static void setCenterScreen(Container container){
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		int x = (toolkit.getScreenSize().width - container.getWidth()) / 2;
		int y = (toolkit.getScreenSize().height - container.getHeight()) / 2;
		container.setLocation(x, y);
	}
	
	/**
	 * 화면 풀 배치
	 */
	public static void setFullScreen(Container container){
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		container.setSize(toolkit.getScreenSize());
	}
	
	
	public static final String THEME_SWING = "javax.swing.plaf.metal.MetalLookAndFeel";
	public static final String THEME_WINDOW = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
	public static final String THEME_UNIX = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";
	public static final String THEME_NIMBUS = "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel";
	public static final String THEME_OS = UIManager.getSystemLookAndFeelClassName();
	
	/**
	 * 룩앤필(Look&Feel) 설정
	 */
	public static void setLookNFeel(Container component, String className){
		try {
			UIManager.setLookAndFeel(className);
		} catch (Exception e) {
			e.printStackTrace();
		}
		SwingUtilities.updateComponentTreeUI(component);
		
	}
}







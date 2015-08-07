package kr.or.kosta.ims.util;


import java.awt.Container;
import java.awt.Toolkit;

import javax.swing.JComponent;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 * GUI에 관련된 공통 유틸리티 메소드
 * @author 신영선
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
		container.setLocation(x,y);
	}
	
	/**
	 * 화면 풀 배치
	 */
	public static void setFullScreen(Container container){
		Toolkit toolkit = Toolkit.getDefaultToolkit(); 

		container.setSize(toolkit.getScreenSize());
	}
	
	/** 
	 * 상수 설정
	 * 셋룩앤필 메소드에서 두 번째 인자를 편하게 받기 위해서 설정
	 */
	
	public static final String THEME_SWING = "javax.swing.plaf.metal.MetalLookAndFeel";
	public static final String THEME_WINDOW = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
	public static final String THEME_LINUX = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";
	public static final String THEME_NIMBUS = "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel";
	public static final String THEME_OS = UIManager.getSystemLookAndFeelClassName();
	
	/**
	 * 룩앤필(LOOK&FEEL) 설정
	 * 테마를 설정하고자하는 컴포넌트, 원하는 테마이름을 받아서 설정해주는 메소드
	 *  
	 */
	public static void setLookNFeel(Container component, String className){ 
		try {
			UIManager.setLookAndFeel(className);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		SwingUtilities.updateComponentTreeUI(component); // 설정
	}

}

package kr.or.kosta.ims.util;

import java.awt.Container;
import java.awt.Toolkit;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 * GUI에 관련된 공통 유틸리티 메소드
 * @author 손진영
 *
 * 작성일 : 2015-07-24
 */
public class GUIUtil {
	/**
	 * 화면 중앙 배치
	 */
	public static void setCenterScreen(Container container){
		Toolkit toolKit = Toolkit.getDefaultToolkit();
		int x = (toolKit.getScreenSize().width - container.getWidth()) / 2;
		int y = (toolKit.getScreenSize().height - container.getHeight()) / 2;
		container.setLocation(x, y);
	}
	/**
	 * 화면 Full 배치
	 */
	public static void setFullScreen(Container container){
		Toolkit toolKit = Toolkit.getDefaultToolkit();
		container.setSize(toolKit.getScreenSize());
	}
	
	/**
	 * setLookNFeel() 메소드의 두번째 인자에서 편하게 사용하기 위한 상수 설정
	 */
	/** Look & Feel을 Swing으로 설정하는 문자열 */
	public static final String THEME_SWING = "javax.swing.plaf.metal.MetalLookAndFeel";
	/** Look & Feel을 Window로 설정하는 문자열 */
	public static final String THEME_WINDOW = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
	/** Look & Feel을 UNIX로 설정하는 문자열 */
	public static final String THEME_UNIX = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";
	/** Look & Feel을 NIMBUS로 설정하는 문자열 */
	public static final String THEME_NIMBUS = "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel";
	public static final String THEME_OS = UIManager.getSystemLookAndFeelClassName();

	/**
	 * Look & Feel 설정
	 */
	public static void setLookNFeel(Container container, String className){
		try {
			UIManager.setLookAndFeel(className);
		} catch (Exception e) {
			e.printStackTrace();
		}
		SwingUtilities.updateComponentTreeUI(container);
	}
}

package ko.or.kosta.ims.util;

import java.awt.Container;
import java.awt.Toolkit;
import java.text.DecimalFormat;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 * GUI관련된 공통 유틸리티 메소드
 * @author Lee Gwangyong
 *
 */
public class GuiUtil {
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
	
	/**
	 *  콤마로찍기
	 *  포맷터가 초기화 되지않는 현상으로 아래와 같이 처리했습니다.
	 *  인터넷 참조하였습니다.
	 */
	public static String numFormat(long num) {
		  DecimalFormat df = new DecimalFormat("#,###");
		  return df.format(num);
	}
	
	public static final String THEME_SWING = "javax.swing.plaf.metal.MetalLookAndFeel";
	public static final String THEME_WINDOW = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
	public static final String THEME_UNIX = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";
	public static final String THEME_NIMBUS= "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel";
	public static final String THEME_OS= UIManager.getSystemLookAndFeelClassName();
	
	/**
	 * 룩엔필(Look&Feel) 설정
	 * @param jcomponent		 설정할 대상
	 * @param className			 look&Feel 종류
	 */
	public static void setLookNFeel(Container container, String className){
		try {
			UIManager.setLookAndFeel(className);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SwingUtilities.updateComponentTreeUI(container);
	}
}

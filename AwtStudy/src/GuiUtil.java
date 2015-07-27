import java.awt.Container;
import java.awt.Toolkit;

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
}

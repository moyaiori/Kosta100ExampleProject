package ko.or.kosta.ams.util;

import java.awt.Container;
import java.awt.Toolkit;
import java.text.DecimalFormat;

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
}

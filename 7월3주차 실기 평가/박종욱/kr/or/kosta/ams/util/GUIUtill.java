package kr.or.kosta.ams.util;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;

/**
 * GUI 관련 공통 유틸리티 메소드
 * @author 박종욱
 *
 */
public class GUIUtill {
	
	//화면 중앙 배치
	public static void setCenterScreen(Container c){

		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension dimension = toolkit.getScreenSize();

		int x = (dimension.width - c.getWidth()) / 2;
		int y = (dimension.height - c.getHeight()) / 2;
		c.setLocation(x, y);
	}	
	
	//화면 풀 배치
	public static void setFullScreen(Container c){

		Toolkit toolkit = Toolkit.getDefaultToolkit();
		c.setSize(toolkit.getScreenSize());
	}
}



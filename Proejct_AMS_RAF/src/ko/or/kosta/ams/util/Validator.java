package ko.or.kosta.ams.util;

import javax.swing.text.JTextComponent;

/**
 * 유효성 검사 클래스
 * @author Lee Gwangyong
 *
 */
public class Validator {
	
	/**
	 * Text File 가 비어있는지 확인
	 */
	public static boolean isNull(JTextComponent textComponent){
		String value = textComponent.getText();
		if(value == null || value.trim().length() == 0){
			return true;
		} 
		return false;
	}
}

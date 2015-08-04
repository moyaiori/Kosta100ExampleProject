package ko.or.kosta.ims.util;

import java.awt.Component;

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
	public static boolean isEmpty(JTextComponent textComponent){
		String value = textComponent.getText();
		if(value == null || value.trim().length() == 0){
			return true;
		} 
		return false;
	}
	
	
	
	
	/**
	 * 해당 문자열이 null인지 확인
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str){
		if(str == null || str.trim().length() == 0){
			return true;
		}
		return false;
	}
	
}

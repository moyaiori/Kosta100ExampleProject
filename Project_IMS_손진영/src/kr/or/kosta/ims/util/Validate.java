package kr.or.kosta.ims.util;

import java.awt.Component;
import java.awt.Container;

import javax.swing.JComboBox;
import javax.swing.text.JTextComponent;

/**
 * 유효성 판별을 하는 클래스
 * @author 손진영
 *
 * 작성일 : 2015-08-03
 */
public class Validate {
	/** 값이 비어있을경우 */
	public static boolean isNull(String str){
		/** null이거나 공백을 제외한 길이가 0인 경우 */
		if(str == null || str.trim().length() == 0){
			return true;
		}
		return false;
	}
	
	/** 숫자만 입력할 수 있게 하는 경우 */
	public static boolean onlyNumber(String num){
		for (int i = 0; i < num.length(); i++) {
			char c = num.charAt(i);
			/** 아스키코드 48~57(숫자 0~9) */
			if(c < 48 || c > 57){
				return false;
			}
		}
		return true;
	}
	
	/** 건네받는 컨테이너에 포함된 텍스트 필드와 콤보박스 초기화 */
	public static void initInformation(Container con){
		Component[] comps = con.getComponents();
		for (Component component : comps) {
			/** 콤보박스일 경우 첫 값으로 설정 */
			if (component instanceof JComboBox) {
				((JComboBox) component).setSelectedIndex(0);
			}
			/** 텍스트 컴포넌트일 경우 빈 값으로 설정 */
			if (component instanceof JTextComponent) {
				((JTextComponent) component).setText("");
			}
		}
	}
}

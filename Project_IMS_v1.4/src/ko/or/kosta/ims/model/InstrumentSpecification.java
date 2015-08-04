package ko.or.kosta.ims.model;

import java.util.HashMap;
/**
 * 5단계 적용
 * @author Lee Gwangyong
 * 2015. 08. 03
 */
public class InstrumentSpecification {

	public HashMap<specPropertie, Object> properties; /** 악기 정보 */
	
	public InstrumentSpecification(){
		properties = new HashMap<specPropertie, Object>();
	}
	
	/** 악기 속성 종류 */
	public enum specPropertie{
		INSTRUMENT, BUILDERS, TYPE, STYLE, TOPWOOD, BACKWOOD, MODEL
	}

	/** 악기 종류 */
	public enum Instruments {
		GUITAR, MANDOLIN
	}

	/** 제조사 */
	public enum Builders {
		FENDER, MARTIN, GIBSON, COLLINGS, OLSON, SAMIC
	}

	/** 기타 종류(유형) */
	public enum Types {
		ACOUSTIC, CLASSIC, ELECTRIC
	}

	/** 스타일 */
	public enum Style {
		A, F
	}

	/** 나무 앞,뒤 종류 */
	public enum Woods {
		ROSEWOOD, MAPLE, MAHOGANY, COCOBOLO, ALDER
	}

	/**
	 * 악기 속성값 추가
	 * @param key - 없으면 null, 아니면 enum에서 찾아서 넣기
	 * @param value
	 */
	public void setProperty(specPropertie key, Object value){
		properties.put(key, value);
	}

	/**
	 * 악기 속성값 가져오기
	 * 
	 * @param key
	 */
	public Object getProperty(specPropertie key) {
		return properties.get(key);
	}

	/**
	 * 모든 속성값 map으로 가져오기
	 * 
	 * @param map
	 */
	public HashMap<specPropertie, Object> getPropertys() {
		return properties;
	}

	@Override
	public String toString() {
		return "InstrumentSpecification [properties=" + properties + "]";
	}

	/**
	 * 불명
	 * 
	 * @return
	 */
	// public boolean equals(){
	// return false;
	// }

}

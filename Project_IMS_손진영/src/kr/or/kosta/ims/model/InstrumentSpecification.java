package kr.or.kosta.ims.model;

import java.util.HashMap;
import java.util.Map;

/**
 * 악기의 명세를
 * 
 * @author 손진영
 *
 *         작성일 : 2015-08-03
 */
public class InstrumentSpecification {
	/** 악기 종류별 동적인 속성 */
	private Map<String, Object> properties;

	/** 생성자 */
	public InstrumentSpecification() {
		super();
		properties = new HashMap<String, Object>();
	}

	/** 동적인 명세를 저장하는 메소드 */
	public void setProperty(String key, Object value) {
		properties.put(key, value);
	}

	/** 키값에 저장되어 있는 명세를 불러오는 메소드 */
	public Object getProperty(String key) {
		Object property = properties.get(key);
		return property;
	}

	/** 저장되어 있는 명세 전체를 가져오는 메소드 */
	public Map<String, Object> getProperties() {
		return properties;
	}

	@Override
	public boolean equals(Object spec) {
		if (this == spec)
			return true;
		if (spec == null)
			return false;
		if (getClass() != spec.getClass())
			return false;
		InstrumentSpecification other = (InstrumentSpecification) spec;
		if (properties == null) {
			if (other.properties != null)
				return false;
		} else if (!properties.equals(other.properties))
			return false;
		return true;
	}

	/** Object의 toString() 오버라이딩 */
	@Override
	public String toString() {
		return "properties=" + properties;
	}

}

package kr.or.kosta.ims.model;

import java.util.HashMap;
import java.util.Map;
/**
 * 악기가 가지는 속성에 대한 객체 추상화 클래스
 * @author 신영선
 *
 */
public class InstrumentSpecification {
	
	Map<String, Object> properties;	
	/**
	 * 생성자 (1)
	 * - 제조사와 모델만 가지고 생성
	 */
	public InstrumentSpecification(Builders builder, String model){
		properties = new HashMap<String, Object>();	
		setProperty("builder", builder);
		setProperty("model", model);
	}
	
	//Spec 순서 : 제조사, 모델, 타입(기타), 재질(앞), 재질(뒤), 스타일(만돌린의경우)
	/** 
	 * 생성자(2)
	 * 기타 생성 - Types 
	 */
	public InstrumentSpecification(Builders builder, String model, Types type, Woods fWood, Woods bWood){
		properties = new HashMap<String, Object>();	
		setProperty("builder", builder);
		setProperty("model", model);
		setProperty("type", type);
		setProperty("fWood", fWood);
		setProperty("bWood", bWood);
	}
	
	/** 
	 * 생성자 (3)
	 * 만돌린 생성 - Styles 
	 */
	public InstrumentSpecification(Builders builder,String model, Styles style, Woods fWood, Woods bWood){
		properties = new HashMap<String, Object>();	
		setProperty("builder", builder);
		setProperty("model", model);
		setProperty("style", style);
		setProperty("fWood", fWood);
		setProperty("bWood", bWood);
	}
	
	/**
	 * 악기 속성값 입력
	 */
	public void setProperty(String key, Object value){
		properties.put(key, value);		
	}
	
	/**
	 * 입력받은 key에 해당하는 속성 값 가져오기
	 */
	public Object getProperty(String key){
		return properties.get(key);		
	}
	
	/**
	 * 악기의 모든 속성 가져오기
	 */
	public Map<String,Object> getProperties(){
		
		return properties;
	}

	@Override
	public boolean equals(Object spec) {
		return super.equals(spec);
	}
	
	
	@Override
	public String toString() {
		return properties.toString();
	}
}

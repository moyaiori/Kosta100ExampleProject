package ko.or.kosta.ims.model;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;
import java.util.Vector;


import ko.or.kosta.ims.model.InstrumentSpecification.Builders;
import ko.or.kosta.ims.model.InstrumentSpecification.Instruments;
import ko.or.kosta.ims.model.InstrumentSpecification.Types;
import ko.or.kosta.ims.model.InstrumentSpecification.Woods;
import ko.or.kosta.ims.model.InstrumentSpecification.Style;

/**
 * 1.3 (5단계)
 * @author Lee Gwangyong
 * 2015. 08. 03
 */
public class Inventory {

	private Vector<Instrument> inventory;

	public Inventory() {
		inventory = new Vector<Instrument>();
	}

	/**
	 * 속성을 받아서 Guitar 객체생성 및 저장
	 * v1.2 : GuitarSpecification으로 속성 분리
	 * 
	 * @param serialNumber
	 * @param price
	 * @param builder
	 * @param model
	 * @param type
	 * @param topWood
	 * @param backWood
	 */
	public void add(Instruments name, String serialNumber, double price, InstrumentSpecification spec) {
		inventory.addElement(new Instrument(name, serialNumber, price, spec));
	}

	/**
	 * Guitar 객체로 바로 생성한다.
	 * 
	 * @param guitar
	 */
	public void add(Instrument instrument) {
		inventory.addElement(instrument);
	}

	

	/**
	 * 기타 일련번호로 기타를 찾는다.
	 * 
	 * @param serialNumber
	 * @return
	 */
	public Instrument get(String serialNumber) {
		Enumeration<Instrument> e = inventory.elements();
		while (e.hasMoreElements()) {
			Instrument guitar = e.nextElement();
			if (guitar.getSerialNumber().equals(serialNumber)) {
				return guitar;
			}
		}
		return null;
	}

	/**
	 * 검색 속성으로 기타를 찾는다. AND 조건으로 검색한다.(주어진 속성이 모두같은 객체만 찾는다.) serialNumber를 제외한
	 * 속성값으로 검색한다.
	 * 1.2v : 검색조건을 Guitar에서 GuitarSpecificaton으로 변경(가격, 일련번호 삭제)
	 * 
	 * @param guitar
	 * @return
	 */
	public List<Instrument> search(InstrumentSpecification spec) {
		Hashtable<String, Object> value = getSearchValue(spec); // 검색어와 검색어의타입
		Set<String> tempSet = value.keySet(); // 검색어 키값(타입) 추출
		String[] keyArray = new String[tempSet.size()]; // 검색어 크기만큼 배열 생성
		tempSet.toArray(keyArray); // 검색하고자하는 속성타입을 배열로 변환
		List<Instrument> listAll = searchAll(); // 현재 인벤토리에 있는 모든 기타 객체들
		
		/*
		 * 매게변수
		 * 1 (int) : 검색 루프 횟수
		 * 2 (ArrayList<Guitar> : 전체 리스트
		 * 3 (String[]) : 검색어
		 * 4 (HashTable<String, Object>) : 검색어와, 각 검색어 타입
		 */
//		return null;
		return loopFun(keyArray.length, (ArrayList<Instrument>) listAll, keyArray, value);
	}

	/**
	 * 재귀함수로 검색 구현
	 * @param keyNum
	 * @param list
	 * @param keyArray
	 * @param value
	 * @return
	 */
	public ArrayList<Instrument> loopFun(int keyNum, ArrayList<Instrument> list, String[] keyArray,
			Hashtable<String, Object> value) {
//		System.out.println("keyNum : " + keyNum);
//		System.out.println("list : " + list);
//		System.out.println("keyArray : " + keyArray[0]);
//		System.out.println("value : " + value);
		
		int getListSize = list.size();
		ArrayList<Instrument> resultList = new ArrayList<Instrument>();
		
		Object KeyByValue;
		Instrument g;
		
		
		if (keyNum == 0) {
//			System.out.println("end of Function");
			return list;
		} else {
			keyNum--;
			for (int i = 0; i < getListSize; i++) {
				KeyByValue = value.get(keyArray[keyNum]);
				g = list.get(i);
//				System.out.println("KeyByValue : " + KeyByValue);
				if (KeyByValue.equals(getGuitarAttribute(keyArray[keyNum], g))) {
					resultList.add(g);
				}
			}
//			System.out.println("resultList : " + resultList);
			return loopFun(keyNum, resultList, keyArray, value);
		}
	}

	/**
	 * 해당 검색어를 비교할 객체의 속성값을 가져온다.
	 * 
	 * @param methodName
	 * @param guitar
	 * @return
	 */
	public Object getGuitarAttribute(String methodName, Instrument instrument) {
		Object result = "";
//		System.out.println("methodName : " + methodName);
//		System.out.println("instrument : " + instrument);
		switch (methodName) {
		case "Builders":
			result = instrument.getSpecification().getProperty("Builders");
			break;
		case "Model":
			result = instrument.getSpecification().getProperty("Model");
			break;
		case "Type":
			result = instrument.getSpecification().getProperty("Type");
			break;
		case "TopWood":
			result = instrument.getSpecification().getProperty("TopWood");
			break;
		case "BackWood":
			result = instrument.getSpecification().getProperty("BackWood");
			break;
		}
		
//		System.out.println("result : " + result);
		return result;
	}

	/**
	 * 검색조건 검출
	 * 
	 * @param guitar
	 * @return
	 */
	public Hashtable<String, Object> getSearchValue(InstrumentSpecification spec) {
		Hashtable<String, Object> result = new Hashtable<String, Object>();
		
		if (spec.getProperty("Builders") != null) {
			result.put("Builders", spec.getProperty("Builders"));
		}

		if (spec.getProperty("Model") != null) {
			result.put("Model", spec.getProperty("Model"));
		}

		if (spec.getProperty("Types") != null) {
			result.put("Types", spec.getProperty("Types"));
		}

		if (spec.getProperty("TopWood") != null) {
			result.put("TopWood", spec.getProperty("TopWood"));
		}

		if (spec.getProperty("BackWood") != null) {
			result.put("BackWood", spec.getProperty("BackWood"));
		}
		
		if (spec.getProperty("Style") != null){
			result.put("Style", spec.getProperty("Style"));
		}
		return result;
	}

	/**
	 * 현재 보유하고있는 모든기타를 보여준다.
	 * 
	 * @return
	 */
	public ArrayList<Instrument> searchAll() {
		ArrayList<Instrument> list = new ArrayList<Instrument>(inventory.size());
		list.addAll(inventory);
		return list;
	}

}

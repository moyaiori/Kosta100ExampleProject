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
import ko.or.kosta.ims.model.InstrumentSpecification.specPropertie;
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
		testData(this);
	}
	
	/**
	 * 테스트를 위한 임시 데이터
	 */
	
	public static void testData(Inventory inven) {
		
		InstrumentSpecification spec01 = new InstrumentSpecification();
		spec01.setProperty(specPropertie.BUILDERS ,Builders.COLLINGS);
		spec01.setProperty(specPropertie.TYPE ,Types.ACOUSTIC);
		spec01.setProperty(specPropertie.TOPWOOD ,Woods.MAPLE);
		spec01.setProperty(specPropertie.BACKWOOD ,Woods.ROSEWOOD);
		spec01.setProperty(specPropertie.MODEL ,"AAAA");
		inven.add(new Instrument(Instruments.GUITAR, "1111-1111", 1000.0, spec01));
		

		InstrumentSpecification spec02 = new InstrumentSpecification();
		spec02.setProperty(specPropertie.BUILDERS ,Builders.SAMIC);
		spec02.setProperty(specPropertie.TYPE ,Types.CLASSIC);
		spec02.setProperty(specPropertie.TOPWOOD ,Woods.ALDER);
		spec02.setProperty(specPropertie.BACKWOOD ,Woods.COCOBOLO);
		spec02.setProperty(specPropertie.MODEL ,"BBBB");
		inven.add(new Instrument(Instruments.GUITAR, "2222-2222", 2000.0, spec02));
		

		InstrumentSpecification spec03 = new InstrumentSpecification();
		spec03.setProperty(specPropertie.BUILDERS ,Builders.MARTIN);
		spec03.setProperty(specPropertie.TYPE ,Types.ELECTRIC);
		spec03.setProperty(specPropertie.TOPWOOD ,Woods.COCOBOLO);
		spec03.setProperty(specPropertie.BACKWOOD ,Woods.MAPLE);
		spec03.setProperty(specPropertie.MODEL ,"CCCC");
		inven.add(new Instrument(Instruments.GUITAR, "3333-3333", 3000.0, spec03));
		

		InstrumentSpecification spec04 = new InstrumentSpecification();
		spec04.setProperty(specPropertie.BUILDERS ,Builders.GIBSON);
		spec04.setProperty(specPropertie.TYPE ,Types.ACOUSTIC);
		spec04.setProperty(specPropertie.STYLE, Style.A);
		spec04.setProperty(specPropertie.TOPWOOD ,Woods.MAHOGANY);
		spec04.setProperty(specPropertie.BACKWOOD ,Woods.COCOBOLO);
		spec04.setProperty(specPropertie.MODEL ,"DDDD");
		inven.add(new Instrument(Instruments.MANDOLIN, "4444-4444", 4000.0, spec04));

		InstrumentSpecification spec05 = new InstrumentSpecification();
		spec05.setProperty(specPropertie.BUILDERS ,Builders.FENDER);
		spec05.setProperty(specPropertie.TYPE ,Types.CLASSIC);
		spec05.setProperty(specPropertie.TOPWOOD ,Woods.MAHOGANY);
		spec05.setProperty(specPropertie.BACKWOOD ,Woods.MAPLE);
		spec05.setProperty(specPropertie.MODEL ,"EEEE");
		inven.add(new Instrument(Instruments.MANDOLIN, "5555-5555", 5000.0, spec05));
		
		InstrumentSpecification spec06 = new InstrumentSpecification();
		spec06.setProperty(specPropertie.BUILDERS ,Builders.FENDER);
		spec06.setProperty(specPropertie.TYPE ,Types.CLASSIC);
		spec06.setProperty(specPropertie.TOPWOOD ,Woods.MAHOGANY);
		spec06.setProperty(specPropertie.BACKWOOD ,Woods.MAPLE);
		spec06.setProperty(specPropertie.MODEL ,"FFFF");
		inven.add(new Instrument(Instruments.MANDOLIN, "6666-6666", 6000.0, spec06));
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
			Instrument instrument = e.nextElement();
			if (instrument.getSerialNumber().equals(serialNumber)) {
				return instrument;
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
		Hashtable<specPropertie, Object> value = getSearchValue(spec); // 검색어와 검색어의타입
		System.out.println("value : "+ value);
		Set<specPropertie> tempSet = value.keySet(); // 검색어 키값(타입) 추출
		specPropertie[] keyArray = new specPropertie[tempSet.size()]; // 검색어 크기만큼 배열 생성
//		System.out.println("search keyArray0 : " + keyArray[0]);
//		System.out.println("search keyArray1 : " + keyArray[1]);
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
	public ArrayList<Instrument> loopFun(int keyNum, ArrayList<Instrument> list, specPropertie[] keyArray,
			Hashtable<specPropertie, Object> value) {
		System.out.println("keyNum : " + keyNum);
		System.out.println("list : " + list);
		System.out.println("keyArray : " + keyArray[0]);
		System.out.println("value : " + value);
		
		int getListSize = list.size();
		ArrayList<Instrument> resultList = new ArrayList<Instrument>();
		
		Object KeyByValue;
		Instrument g;
		
		
		if (keyNum == 0) {
			System.out.println("end of Function");
			return list;
		} else {
			keyNum--;
			for (int i = 0; i < getListSize; i++) {
				KeyByValue = value.get(keyArray[keyNum]);
				g = list.get(i);
				System.out.println("KeyByValue : " + KeyByValue);
				if (KeyByValue.equals(getGuitarAttribute(keyArray[keyNum], g))) {
					resultList.add(g);
				}
			}
			System.out.println("resultList : " + resultList);
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
	public Object getGuitarAttribute(specPropertie methodName, Instrument instrument) {
		Object result = "";
//		System.out.println("methodName : " + methodName);
//		System.out.println("instrument : " + instrument);
		switch (methodName) {
		case BUILDERS:
			result = instrument.getSpecification().getProperty(specPropertie.BUILDERS);
			break;
		case MODEL:
			result = instrument.getSpecification().getProperty(specPropertie.MODEL);
			break;
		case TYPE:
			result = instrument.getSpecification().getProperty(specPropertie.TYPE);
			break;
		case TOPWOOD:
			result = instrument.getSpecification().getProperty(specPropertie.TOPWOOD);
			break;
		case BACKWOOD:
			result = instrument.getSpecification().getProperty(specPropertie.BACKWOOD);
			break;
		case STYLE:
			result = instrument.getSpecification().getProperty(specPropertie.STYLE);
			break;
		default:
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
	public Hashtable<specPropertie, Object> getSearchValue(InstrumentSpecification spec) {
		System.out.println("getSearchValue : " + spec);
		Hashtable<specPropertie, Object> result = new Hashtable<specPropertie, Object>();
		
		if (spec.getProperty(specPropertie.BUILDERS) != null) {
			result.put(specPropertie.BUILDERS, spec.getProperty(specPropertie.BUILDERS));
		}

		if (spec.getProperty(specPropertie.MODEL) != null) {
			result.put(specPropertie.MODEL, spec.getProperty(specPropertie.MODEL));
		}

		if (spec.getProperty(specPropertie.TYPE) != null) {
			result.put(specPropertie.TYPE, spec.getProperty(specPropertie.TYPE));
		}

		if (spec.getProperty(specPropertie.TOPWOOD) != null) {
			result.put(specPropertie.TOPWOOD, spec.getProperty(specPropertie.TOPWOOD));
		}

		if (spec.getProperty(specPropertie.BACKWOOD) != null) {
			result.put(specPropertie.BACKWOOD, spec.getProperty(specPropertie.BACKWOOD));
		}
		
		if (spec.getProperty(specPropertie.STYLE) != null){
			result.put(specPropertie.STYLE, spec.getProperty(specPropertie.STYLE));
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

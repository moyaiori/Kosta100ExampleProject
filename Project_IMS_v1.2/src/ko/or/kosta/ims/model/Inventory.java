package ko.or.kosta.ims.model;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import ko.or.kosta.ims.model.GuitarSpecification.Builders;
import ko.or.kosta.ims.model.GuitarSpecification.Types;
import ko.or.kosta.ims.model.GuitarSpecification.Woods;

public class Inventory {

	private Vector<Guitar> inventory;

	public Inventory() {
		inventory = new Vector<Guitar>();
		testData();
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
	public void add(String serialNumber, double price, Builders builder, String model, Types type, Woods topWood,
			Woods backWood) {
		inventory.addElement(
				new Guitar(serialNumber, price, new GuitarSpecification(builder, model, type, topWood, backWood)));
	}

	/**
	 * Guitar 객체로 바로 생성한다.
	 * 
	 * @param guitar
	 */
	public void add(Guitar guitar) {
		inventory.addElement(guitar);
	}

	/**
	 * 테스트를 위한 임시 데이터
	 */
	public void testData() {
		add(new Guitar("111", 1000,
				new GuitarSpecification(GuitarSpecification.Builders.COLLINGS, "모델02",
						GuitarSpecification.Types.ACOUSTIC, GuitarSpecification.Woods.COCOBOLO,
						GuitarSpecification.Woods.ROSEWOOD)));
		add(new Guitar("222", 2000,
				new GuitarSpecification(GuitarSpecification.Builders.FENDER, "모델02", GuitarSpecification.Types.ACOUSTIC,
						GuitarSpecification.Woods.ALDER, GuitarSpecification.Woods.MAHOGANY)));
		add(new Guitar("333", 3000,
				new GuitarSpecification(GuitarSpecification.Builders.GIBSON, "모델03", GuitarSpecification.Types.ELECTRIC,
						GuitarSpecification.Woods.MAHOGANY, GuitarSpecification.Woods.COCOBOLO)));
		add(new Guitar("444", 2000,
				new GuitarSpecification(GuitarSpecification.Builders.COLLINGS, "모델04",
						GuitarSpecification.Types.CLASSIC, GuitarSpecification.Woods.MAHOGANY,
						GuitarSpecification.Woods.ROSEWOOD)));
		add(new Guitar("555", 2000,
				new GuitarSpecification(GuitarSpecification.Builders.COLLINGS, "모델04",
						GuitarSpecification.Types.CLASSIC, GuitarSpecification.Woods.MAHOGANY,
						GuitarSpecification.Woods.ROSEWOOD)));
	}

	/**
	 * 기타 일련번호로 기타를 찾는다.
	 * 
	 * @param serialNumber
	 * @return
	 */
	public Guitar get(String serialNumber) {
		Enumeration<Guitar> e = inventory.elements();
		while (e.hasMoreElements()) {
			Guitar guitar = e.nextElement();
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
	public List<Guitar> search(GuitarSpecification spec) {
		Hashtable<String, Object> value = getSearchValue(spec); // 검색어와 검색어의타입
		Set<String> tempSet = value.keySet(); // 검색어 키값(타입) 추출
		String[] keyArray = new String[tempSet.size()]; // 검색어 크기만큼 배열 생성
		tempSet.toArray(keyArray); // 검색하고자하는 속성타입을 배열로 변환
		List<Guitar> listAll = searchAll(); // 현재 인벤토리에 있는 모든 기타 객체들

		/*
		 * 매게변수
		 * 1 (int) : 검색 루프 횟수
		 * 2 (ArrayList<Guitar> : 전체 리스트
		 * 3 (String[]) : 검색어
		 * 4 (HashTable<String, Object>) : 검색어와, 각 검색어 타입
		 */
//		return null;
		return loopFun(keyArray.length, (ArrayList<Guitar>) listAll, keyArray, value);
	}

	/**
	 * 재귀함수로 검색 구현
	 * @param keyNum
	 * @param list
	 * @param keyArray
	 * @param value
	 * @return
	 */
	public ArrayList<Guitar> loopFun(int keyNum, ArrayList<Guitar> list, String[] keyArray,
			Hashtable<String, Object> value) {
		int getListSize = list.size();
		ArrayList<Guitar> resultList = new ArrayList<Guitar>();
		
		Object KeyByValue;
		Guitar g;

		if (keyNum == 0) {
//			System.out.println("end of Function");
			return list;
		} else {
			keyNum--;
			for (int i = 0; i < getListSize; i++) {
				KeyByValue = value.get(keyArray[keyNum]);
				g = list.get(i);
				if (KeyByValue.equals(getGuitarAttribute(keyArray[keyNum], g))) {
					resultList.add(g);
				}
			}
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
	public Object getGuitarAttribute(String methodName, Guitar guitar) {
		Object result = "";
		switch (methodName) {
		case "builder":
			result = guitar.getSpecification().getBuilder();
			break;
		case "model":
			result = guitar.getSpecification().getModel();
			break;
		case "type":
			result = guitar.getSpecification().getType();
			break;
		case "topWood":
			result = guitar.getSpecification().getTopWood();
			break;
		case "backWood":
			result = guitar.getSpecification().getBackWood();
			break;
		}
		return result;
	}

	/**
	 * 검색조건 검출
	 * 
	 * @param guitar
	 * @return
	 */
	public Hashtable<String, Object> getSearchValue(GuitarSpecification spec) {
		Hashtable<String, Object> result = new Hashtable<String, Object>();

		if (spec.getBuilder() != null) {
			result.put("builder", spec.getBuilder());
		}

		if (spec.getModel() != null) {
			result.put("model", spec.getModel());
		}

		if (spec.getType() != null) {
			result.put("type", spec.getType());
		}

		if (spec.getTopWood() != null) {
			result.put("topWood", spec.getTopWood());
		}

		if (spec.getBackWood() != null) {
			result.put("backWood", spec.getBackWood());
		}
		return result;
	}

	/**
	 * 현재 보유하고있는 모든기타를 보여준다.
	 * 
	 * @return
	 */
	public ArrayList<Guitar> searchAll() {
		ArrayList<Guitar> list = new ArrayList<Guitar>(inventory.size());
		list.addAll(inventory);
		return list;
	}

}

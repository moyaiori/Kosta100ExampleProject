package ko.or.kosta.ims.model;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;
import java.util.Vector;

public class Inventory {

	private Vector<Guitar> inventory;

	public Inventory() {
		inventory = new Vector<Guitar>();
		testData();
	}

	/**
	 * 속성을 받아서 기타 객체생성 및 저장
	 * 
	 * @param serialNumber
	 * @param price
	 * @param builder
	 * @param model
	 * @param type
	 * @param topWood
	 * @param backWood
	 */
	public void add(String serialNumber, double price, Guitar.Builders builder, String model, Guitar.Types type,
			Guitar.Woods topWood, Guitar.Woods backWood) {
		inventory.addElement(new Guitar(serialNumber, price, builder, model, type, topWood, backWood));

	}

	/**
	 * 테스트를 위한 임시 데이터
	 */
	public void testData() {
		add(new Guitar("111", 1000, Guitar.Builders.COLLINGS, "모델02", Guitar.Types.ACOUSTIC, Guitar.Woods.COCOBOLO,
				Guitar.Woods.ROSEWOOD));
		add(new Guitar("222", 2000, Guitar.Builders.FENDER, "모델02", Guitar.Types.ACOUSTIC, Guitar.Woods.ALDER,
				Guitar.Woods.MAHOGANY));
		add(new Guitar("333", 3000, Guitar.Builders.GIBSON, "모델03", Guitar.Types.ELECTRIC, Guitar.Woods.MAHOGANY,
				Guitar.Woods.COCOBOLO));
		add(new Guitar("444", 2000, Guitar.Builders.COLLINGS, "모델04", Guitar.Types.CLASSIC, Guitar.Woods.MAHOGANY,
				Guitar.Woods.ROSEWOOD));
		add(new Guitar("555", 2000, Guitar.Builders.COLLINGS, "모델04", Guitar.Types.CLASSIC, Guitar.Woods.MAHOGANY,
				Guitar.Woods.ROSEWOOD));
	}

	/**
	 * 기타 객체로 바로 생성한다.
	 * 
	 * @param guitar
	 */
	public void add(Guitar guitar) {
		inventory.addElement(guitar);
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
	 * 
	 * @param guitar
	 * @return
	 */
	public List<Guitar> search(Guitar guitar) {
		Hashtable<String, Object> value = getSearchValue(guitar);	// 검색어와 검색어의 타입
		Set<String> tempSet = value.keySet();						// 검색어 키값(타입) 추출
		String[] keyArray = new String[tempSet.size()]; 			// 검색어 크기만큼 배열 생성
		tempSet.toArray(keyArray);									// 검색하고자하는 속성타입을 배열로 변환

		List<Guitar> listAll = searchAll(); 						// 현재 인벤토리에 있는 모든 기타 객체들

		return loopFun(keyArray.length, (ArrayList<Guitar>) listAll, keyArray, value);
	}
	
	/**
	 * 재귀함수로 검색 구현
	 * @param keyNum
	 * @param list
	 * @return
	 */
	public ArrayList<Guitar> loopFun(int keyNum, ArrayList<Guitar> list, String[] keyArray, Hashtable<String, Object> value){		
		int getListSize = list.size();
		ArrayList<Guitar> resultList = new ArrayList<Guitar>(); 
		
		if (keyNum == 0) {
			System.out.println("end of Function");
			return list;
		} else {
			keyNum--;
			for (int i = 0; i < getListSize; i++) {
				Object keyByValue = value.get(keyArray[keyNum]);
				Guitar g = list.get(i);
				if (keyByValue.equals(getGuitarAttribute(keyArray[keyNum], g))) {
					resultList.add(g);
				}
			}
			return loopFun(keyNum, resultList, keyArray, value);
		}
	}
	
	
	/**
	 * 해당 검색어를 비교할 객체의 속성값을 가져온다.
	 * @param methodName
	 * @param guitar
	 * @return
	 */
	public Object getGuitarAttribute(String methodName, Guitar guitar) {
		Object result = "";
		switch (methodName) {
		case "price":
			result = guitar.getPrice();
			break;
		case "builder":
			result = guitar.getBuilder();
			break;
		case "model":
			result = guitar.getModel();
			break;
		case "type":
			result = guitar.getType();
			break;
		case "topWood":
			result = guitar.getTopWood();
			break;
		case "backWood":
			result = guitar.getBackWood();
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
	public Hashtable<String, Object> getSearchValue(Guitar guitar) {
		Hashtable<String, Object> result = new Hashtable<String, Object>();
		// System.out.println(guitar.getModel());

		if (guitar.getPrice() != 0.0) {
			result.put("price", guitar.getPrice());
		}

		if (guitar.getBuilder() != null) {
			result.put("builder", guitar.getBuilder());
		}

		if (guitar.getModel() != null) {
			result.put("model", guitar.getModel());
		}

		if (guitar.getType() != null) {
			result.put("type", guitar.getType());
		}

		if (guitar.getTopWood() != null) {
			result.put("topWood", guitar.getTopWood());
		}

		if (guitar.getBackWood() != null) {
			result.put("backWood", guitar.getBackWood());
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
